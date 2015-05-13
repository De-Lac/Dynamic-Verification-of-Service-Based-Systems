/**
 * <copyright>
 * This file is part of Partes project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: TestBuilder.java 28/ott/2011 11:59:33 francesco $
 */

package partes.testbuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import jdsl.core.api.Position;
import jdsl.core.api.PositionIterator;
import jdsl.core.api.Tree;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.ow2.choreos.partes.ParticipantTestBuilder;

import partes.commons.Interaction;
import partes.exception.TestGenerationException;
import partes.refactorRunner.PartesInfo;
import partes.service.PartesMain;
import partes.utils.TreeUtils;
import partes.utils.WriteToFile;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlGroovyScriptTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.GroovyScriptAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.basic.SchemaComplianceAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.assertions.soap.SoapResponseAssertion;
import com.eviware.soapui.impl.wsdl.teststeps.registry.GroovyScriptStepFactory;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestRequestStepFactory;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.testsuite.TestAssertion;
import com.eviware.soapui.model.testsuite.TestSuite.TestSuiteRunType;
import com.eviware.soapui.support.SoapUIException;

/**
 * The Class TestBuilder.
 */
public class TestBuilder implements ParticipantTestBuilder {

	/** The log. */
	private static Log log = LogFactory.getLog(TestBuilder.class);

	/** The vector tree. */
	private Vector<TreeWithEndpoint> vectorTree;

	/**
	 * Instantiates a new test builder.
	 */
	public TestBuilder() {
		this.vectorTree = new Vector<TreeWithEndpoint>();
	}

	/**
	 * Make soapui project.
	 * 
	 * @param treeWithEndpoint
	 *            the tree with endpoint
	 * @throws XmlException
	 *             the xml exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SoapUIException
	 *             the soap ui exception
	 */
	public WsdlProject makeSOAPuiProject(TreeWithEndpoint treeWithEndpoint)
			throws XmlException, IOException, SoapUIException {

		WsdlProject project = new WsdlProject();
		project.setName(treeWithEndpoint.getPortType() + "-tests");
		WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project,
					treeWithEndpoint.getWsdlFileName(), true)[0]; 
		
		printDebug("start");

		WsdlTestSuite testsuite1 = project.addNewTestSuite("TestSuite1");
		String setupCode = "//code for testsuite setup\n\n";
		testsuite1.setRunType(TestSuiteRunType.PARALLEL);
        
		// spezzare l'albero in tanti tronconi e fare test case per ognuno

		// WsdlTestCase testcase1 = testsuite1.addNewTestCase("testcase1");
		// WsdlTestStepRegistry registry = WsdlTestStepRegistry.getInstance();
		// WsdlTestStepFactory wtsf = registry.getFactory("request");
		// //WsdlTestRequestStepFactory

		// usare qui tanti tree diversi per ogni testfragment

		// Iterator<Tree> trees = treeWithEndpoint.getTreeFragment().iterator();

		Iterator<TestFragment> testFragments = treeWithEndpoint
				.getTestFragments().iterator();

		// WsdlTestStepRegistry registry = WsdlTestStepRegistry.getInstance();
		while (testFragments.hasNext()) {

			// Tree tree = treeWithEndpoint.getTree();
			TestFragment tFragment = testFragments.next();

			Tree tree = tFragment.getTree();

			String testFragmentName = "testcase-fragment-"
					+ tFragment.getFragmentID();
			boolean startDisabled = true;

			if (tFragment.isInitialFragment()) {
				printDebug("found start fragment " + tFragment.getFragmentID());
				testFragmentName = "testcase-start-"
						+ tFragment.getFragmentID();
				startDisabled = false;
			} else if (tFragment.isBranchFragment()) {
				printDebug("found branch fragment" + tFragment.getFragmentID());
				testFragmentName = "testcase-branch-"
						+ tFragment.getFragmentID();
				startDisabled = true;
			}

			if (tFragment.isBranchFragment() && tFragment.isInitialFragment()) {
				printDebug("found start&branch fragment "
						+ tFragment.getFragmentID());
				testFragmentName = "testcase-start-branch-"
						+ tFragment.getFragmentID();
				startDisabled = false;
			}

			WsdlTestCase testcase1 = testsuite1
					.addNewTestCase(testFragmentName);
			printDebug("testcase: " + testcase1.getName());
			testcase1.setDisabled(startDisabled);

			if (startDisabled) {
				if (tFragment.isBranchFragment()) {
					// patch: controllare
					setupCode += "def " + "tf" + tFragment.getFragmentID()
							+ " = " + "testSuite.project.testSuites[\""
							+ testsuite1.getName()
							+ "\"].testCases[\"testcase-branch-"
							+ tFragment.getFragmentID() + "\"]\n";
					setupCode += "tf" + tFragment.getFragmentID()
							+ ".disabled=true\n";
				} else { // fragment
					setupCode += "def " + "tf" + tFragment.getFragmentID()
							+ " = " + "testSuite.project.testSuites[\""
							+ testsuite1.getName()
							+ "\"].testCases[\"testcase-fragment-"
							+ tFragment.getFragmentID() + "\"]\n";
					setupCode += "tf" + tFragment.getFragmentID()
							+ ".disabled=true\n";
				}
			}

			
			PositionIterator pi = tree.positions();
			// pi.nextPosition(); // to exclude the root element
			while (pi.hasNext()) {
				Position p = pi.nextPosition();

				Interaction interaction = (Interaction) p.element();
				printDebug("interaction: " + interaction.getMethod());
				
				WsdlOperation wo = (WsdlOperation) iface
						.getOperationByName(interaction.getMethod());

				Iterator<Request> ir = wo.getRequestList().iterator();

				//while (ir.hasNext()) {
				//	WsdlRequest wr = ((WsdlRequest) ir.next());
				    // you can set request content here
				//}

				// wsdlTestRequestStep.getTestRequest().setRequestContent(holder.xml);

				TestStepConfig tsc = WsdlTestRequestStepFactory.createConfig(
						wo, "Step " + interaction.getMethod() + " "
								+ interaction.hashCode());

				if (tsc != null) {
					WsdlTestStep teststep = testcase1.addTestStep(tsc);

					// recupero input dal tree delle interazioni
					String input = interaction.getAllParams();

					// qui se si utilizzano le label si possono recuperare le
					// buste soap da un DB

					String comment = "<!-- SOAP request generated by interactions analyzed in the model -->\n";

					// per settare il contenuto occorre fare un cast!
					((WsdlTestRequestStep) teststep).getTestRequest()
							.setRequestContent(comment + input);

					// Soap Response Assertion
					TestAssertion assertion4 = ((WsdlTestRequestStep) teststep)
							.addAssertion("SOAP Response");
					SoapResponseAssertion soapResponseAssertion = ((SoapResponseAssertion) assertion4);

					// Schema Compliance Assertion
					TestAssertion assertion3 = ((WsdlTestRequestStep) teststep)
							.addAssertion("Schema Compliance");
					SchemaComplianceAssertion schemaComplianceAssertion = ((SchemaComplianceAssertion) assertion3);

					// Script Assertion
					TestAssertion assertion2 = ((WsdlTestRequestStep) teststep)
							.addAssertion("Script Assertion");

					GroovyScriptAssertion scriptAssertion = ((GroovyScriptAssertion) assertion2);

					String codeForAssertion = "//assertion\n\n";

					codeForAssertion += "import org.custommonkey.xmlunit.Diff\n";
					codeForAssertion += "import org.custommonkey.xmlunit.XMLUnit\n";
					codeForAssertion += "import groovy.xml.StreamingMarkupBuilder\n\n";

					codeForAssertion += "// response from ws\n";
					codeForAssertion += "def response =  messageExchange.responseContentAsXml\n\n";

					codeForAssertion += "//SOAP responses generated by interactions analyzed in the model\n\n";

					codeForAssertion += "def expectedResponses = new Vector<String>()\n\n";

					String results2 = interaction.getAllRetValues();
					results2 = results2.replace("[#", "").replace("#]", "");
					String delimiter2 = "##";
					String[] temp2 = results2.split(delimiter2);

					// qui da ogni label temp2[] si puo' recuperare la busta
					// soap corrispondente da db se si usano le label

					if (temp2 != null && temp2.length != 0) {
						for (int i = 0; i < temp2.length; i++) {
							if (temp2[i] != null) {
								codeForAssertion += "def expectedResult" + i
										+ " = '''" + temp2[i] + "'''\n";
								codeForAssertion += "expectedResponses.add(expectedResult"
										+ i + ")\n\n";
							}
						}
					}

					codeForAssertion += "def root = new XmlSlurper().parseText(response)\n\n";

					codeForAssertion += "// check the whole document using XmlUnit\n";
					codeForAssertion += "def outputBuilder = new StreamingMarkupBuilder()\n";
					codeForAssertion += "String result = outputBuilder.bind{ mkp.yield root }\n\n";

					codeForAssertion += "XMLUnit.setIgnoreWhitespace(true)\n";
					codeForAssertion += "XMLUnit.setIgnoreComments(true)\n";
					codeForAssertion += "XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true)\n\n";

					codeForAssertion += "def iteratorExpectedResponses = expectedResponses.iterator()\n";
					codeForAssertion += "def assertResult = false\n";
					codeForAssertion += "def foundSimilarResult = -1\n";
					codeForAssertion += "def found = false\n\n";

					codeForAssertion += "for(def i=0;  i<expectedResponses.size(); i++){\n";
					codeForAssertion += "    if (!found){\n";
					codeForAssertion += "        def xmlDiff = new Diff(result, expectedResponses.get(i))\n";
					codeForAssertion += "        //println \"[\"+ i +\"] xmlDiff.similar() = \" + xmlDiff.similar()\n";
					codeForAssertion += "        //println \"[\"+ i +\"] xmlDiff.identical() = \" + xmlDiff.identical()\n";
					codeForAssertion += "        //println \"[\"+ i +\"] xmlDiff.toString() = \" + xmlDiff.toString()\n";
					codeForAssertion += "        if (xmlDiff.similar()){\n";
					codeForAssertion += "            found = true\n";
					codeForAssertion += "            foundSimilarResult = i\n";
					codeForAssertion += "            log.info \"found similar result = \" + i\n";
					codeForAssertion += "        } else {\n";
					codeForAssertion += "            log.info \"found differences in \" + i + \": \" + xmlDiff.toString()\n";
					codeForAssertion += "        }\n";
					codeForAssertion += "    }\n";
					codeForAssertion += "}\n\n";

					codeForAssertion += "log.info \"foundSimilarResult = \" + foundSimilarResult\n";

					codeForAssertion += "messageExchange.modelItem.testStep.testCase.setPropertyValue(\"branch\", foundSimilarResult+\"\")\n";

					codeForAssertion += "assert foundSimilarResult != -1\n";

					scriptAssertion.setScriptText(codeForAssertion);

				}

			}

			if (tFragment.isBranchFragment()) {
				TestStepConfig branchStep = (new GroovyScriptStepFactory())
						.createNewTestStep(testcase1,
								"branchstep-" + testcase1.getName());

				WsdlTestStep teststep = testcase1.addTestStep(branchStep);

				boolean selective = true;

				if (selective) {
					testcase1.addProperty("branch");
					Iterator<TestFragment> strItr = tFragment.getSuccessors()
							.iterator();
					String codeComment = "//selective branching - ";
					String code = "import com.eviware.soapui.support.types.StringToObjectMap\n\n";
					code += "def list = [";
					while (strItr.hasNext()) {
						TestFragment tf = strItr.next();
						String id = tf.getFragmentID() + "";
						if (tf.isBranchFragment()) {
							code += "\'" + "branch-" + id + "\', ";
							codeComment += id + " ";
						} else { // no branch fragment
							code += "\'" + "fragment-" + id + "\', ";
							codeComment += id + " ";
						}
						// code += "\'"+id+"\', ";
						// codeComment += id + " ";
					}

					code = code.substring(0, code.length() - 2);
					code += "]\n\n";
					code += "def branch = testRunner.testCase.getPropertyValue(\"branch\")\n";
					code += "def fragment = list.get(branch.toInteger())\n";
					// code +=
					// "def fragmentToExec = testRunner.testCase.testSuite.project.testSuites[\""+testsuite1.getName()+"\"].testCases[\"testcase-fragment-\"+fragment]\n";
					code += "def fragmentToExec = testRunner.testCase.testSuite.project.testSuites[\""
							+ testsuite1.getName()
							+ "\"].testCases[\"testcase-\"+fragment]\n";
					code += "fragmentToExec.disabled=false\n";
					code += "fragmentToExec.run(new StringToObjectMap(), false)\n\n";
					((WsdlGroovyScriptTestStep) teststep).setScript(codeComment
							+ "\n\n" + code);

				} else {
					// testfragment in parallelo
					Iterator<TestFragment> strItr = tFragment.getSuccessors()
							.iterator();
					String codeComment = "//parallel execution - ";
					String code = "import com.eviware.soapui.support.types.StringToObjectMap\n\n";
					while (strItr.hasNext()) {
						String id = strItr.next().getFragmentID() + "";
						code += "def "
								+ "tf"
								+ id
								+ " = "
								+ "testRunner.testCase.testSuite.project.testSuites[\""
								+ testsuite1.getName()
								+ "\"].testCases[\"testcase-fragment-" + id
								+ "\"]\n";
						code += "tf" + id + ".disabled=false\n";
						code += "tf" + id
								+ ".run(new StringToObjectMap(), false)\n\n";
						codeComment += id + " ";
					}
					((WsdlGroovyScriptTestStep) teststep).setScript(codeComment
							+ "\n\n" + code);
				}

			}

		}

		testsuite1.setSetupScript(setupCode);

		testsuite1.setTearDownScript(setupCode);

		// project.saveAs(ConfTestBuilder.get("TestBuilder.outDir") +
		// File.separator + treeWithEndpoint.getPortType() + "-tests.xml");

		printDebug("end");

		return project;

	}
	
	
	/* (non-Javadoc)
	 * @see partes.testbuilder.ParticipantTestBuilder#makeSOAPuiProject(jdsl.core.api.Tree, java.lang.String, java.lang.String)
	 */
	@Override
	public WsdlProject makeSOAPuiProject(Tree tree, String portTypeToSearch, String wsdlLocation)
			throws XmlException, IOException, SoapUIException {
		TreeWithEndpoint twe = new TreeWithEndpoint(tree, wsdlLocation, portTypeToSearch);
		WsdlProject project = this.makeSOAPuiProject(twe);
		return project;
		
	}
	
	
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String fileOfTree="";
		String wsdlLocation="";
		String portTypeToSearch = "";
		
		
		Options options = new Options();
		HelpFormatter formatter = new HelpFormatter();
		options.addOption("f", "projectionfile", true, "specify projection file");
		options.addOption("w", "wsdl", true, "specify wsdl of service");
		options.addOption("p", "porttype", true, "specify porttype to test");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			if (cmd.getOptions().length == 0) {
				formatter.printHelp("TestBuilder", options, true);
				System.exit(0);
			}

			fileOfTree = cmd.getOptionValue("f");
			wsdlLocation = cmd.getOptionValue("w");
			portTypeToSearch = cmd.getOptionValue("p");

			if (fileOfTree == null || wsdlLocation == null  || portTypeToSearch == null  ) {
				formatter.printHelp("TestBuilder", options, true);
				System.exit(0);
			}

		} catch (ParseException e) {
			formatter.printHelp("TestBuilder", options, true);
			System.exit(0);
		}
		
		ParticipantTestBuilder tb = new TestBuilder();
		TreeUtils tu = new TreeUtils(fileOfTree);
		
		try {
			String xmlTest = tb.makeSOAPuiProject(tu.getTree(), portTypeToSearch, wsdlLocation).getProjectDocument().toString();
			
			WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator,"test-"+portTypeToSearch+".xml", xmlTest);
			System.exit(0);
		} catch (XmlException e) {
			//e.printStackTrace();
			System.out.println("TestBuilder causes an XmlException!");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("TestBuilder causes an IOException!");
		} catch (SoapUIException e) {
			//e.printStackTrace();
			System.out.println("TestBuilder causes an SoapUIException!");
		}
	}
	
		
	
	public WsdlProject makeSOAPuiProjectTracesTest(HashMap<String, Tree> trees, Vector<PartesInfo> participants) throws TestGenerationException
	{
	 try 
	 	{ return new TestTracesBuilder().makeSOAPuiProject(trees, participants);} 
	 catch (XmlException e) {e.printStackTrace();} 
	 catch (IOException e) {e.printStackTrace();} 
	 catch (SoapUIException e) {e.printStackTrace();}
	return null;
	}
	
	private void printDebug(String message)
	{
	 if (PartesMain.instance.doDebug())
	 	{
		 log.debug(message);
	 	}
	}
	
}
