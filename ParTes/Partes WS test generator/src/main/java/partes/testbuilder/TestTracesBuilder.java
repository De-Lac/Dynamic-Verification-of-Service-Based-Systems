package partes.testbuilder;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import jdsl.core.api.Position;
import jdsl.core.api.Tree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;

import partes.commons.Interaction;
import partes.exception.TestGenerationException;
import partes.refactorRunner.PartesInfo;

import com.eviware.soapui.config.TestStepConfig;
import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.actions.request.RecreateRequestAction;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockOperation;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.registry.WsdlTestRequestStepFactory;
import com.eviware.soapui.model.testsuite.TestProperty;
import com.eviware.soapui.model.testsuite.TestSuite.TestSuiteRunType;
import com.eviware.soapui.support.SoapUIException;

public class TestTracesBuilder 
{
	/** The log. */
	private static Log log = LogFactory.getLog(TestBuilder.class);
	private static HashMap<String, WsdlInterface> ifaces; //array of imported WSDL
	private static final String MOCK_SUFFIX = " mock service";
	private static int step_number = 0;
	
	
	public TestTracesBuilder()
	{
		ifaces = new HashMap<String, WsdlInterface>(); 
	}
	
	
	/**
	 * Make SOAPUI project
	 * 
	 * @param trees HashMap of (condition,tree)
	 * @param wsdls HashMap of (service name, endpoint)
	 * @return
	 * @throws XmlException
	 * @throws IOException
	 * @throws SoapUIException
	 * @throws TestGenerationException 
	 */
	public WsdlProject makeSOAPuiProject(HashMap<String, Tree> trees,  Vector<PartesInfo> participants)
			throws XmlException, IOException, SoapUIException, TestGenerationException {
		WsdlProject project = new WsdlProject();
		project.setName("integration test");
		for (PartesInfo p : participants)
			{
			 WsdlInterface wsdlInterface = WsdlInterfaceFactory.importWsdl(project, p.getWsdlLocation(), true)[0];
			 
			 for(int i=0; i < wsdlInterface.getOperationCount(); i++)
			 	{
				 WsdlRequest request = wsdlInterface.getOperationAt(i).getRequestAt(0);
				 String defaultRequest = ((WsdlOperation)request.getOperation()).createRequest(true);
				 request.setRequestContent( defaultRequest );
				 // i don't know how attach the defaultResponse to the defaultRequest
			 	}
			 //do you want to create a mock service for this 'wsdlInterface' ?
			 //int choice = JOptionPane.showConfirmDialog(null, "create a Mock Service for the participant '"+p.getModelImplClass()+"' ?");
			 int choice = JOptionPane.YES_OPTION;
			 if ( choice == JOptionPane.YES_OPTION)
				 { // create a local virtual participant with fake operations
				  WsdlMockService mockService = project.addNewMockService(p.getModelImplClass()+MOCK_SUFFIX);
				  mockService.setPath("/"+p.getModelImplClass());
				  for(int i=0; i < wsdlInterface.getOperationCount(); i++)
				  	{
					  WsdlMockOperation mockOperation = mockService.addNewMockOperation(wsdlInterface.getOperationAt(i));
					  mockOperation.addNewMockResponse(wsdlInterface.getOperationAt(i).createResponse(true), true);
					  wsdlInterface.addEndpoint( mockService.getLocalMockServiceEndpoint() );
				  	}
				 }
			 ifaces.put(p.getModelImplClass(), wsdlInterface);
			}
		for(String condition: trees.keySet())
		{
		 WsdlTestSuite testsuite = project.addNewTestSuite("TestSuite with: "+condition);
		 testsuite.setRunType(TestSuiteRunType.PARALLEL);
		 Tree tree = trees.get(condition);	
		 int counter=1;
		 while (tree.size() > 1) //the root is not deleted, so min size = 1
		 	{//loads the traces (test cases)
			 ArrayList<Interaction> trace = new ArrayList<Interaction>(); 
			 retriveTraceFromTree(tree.root(), tree, trace);
			 createTestCase(trace, counter, testsuite, project);
			 counter++;
			}
		}
		log.info("end");
		return project;
	}
		
	private void createTestCase(ArrayList<Interaction> trace, int i, WsdlTestSuite testsuite, WsdlProject project) throws TestGenerationException
	{
		WsdlTestCase testcase1 = testsuite.addNewTestCase("TestCase_"+i);
		log.info("testcase: " + testcase1.getName());
		for (Interaction ct:trace) 
		  {	
			WsdlInterface service = ifaces.get(ct.getMethodClass());
			try{
				WsdlOperation operation = service.getOperationByName(ct.getMethod());
			TestStepConfig config = WsdlTestRequestStepFactory.createConfig(operation, ct.getMethod()+"_"+step_number);
			
			step_number++;

			WsdlTestRequestStep step = (WsdlTestRequestStep)testcase1.addTestStep(config);
			step.addAssertion( "SOAP Response" );
			step.addAssertion( "Schema Compliance" );
			step.addAssertion( "Script Assertion" );
			
			WsdlMockService mockService = project.getMockServiceByName(ct.getMethodClass()+MOCK_SUFFIX);
			if (mockService != null)
				{// if there exist a mock service, its endpoint will be used
				 String mockEndpoint = mockService.getLocalMockServiceEndpoint();
				 TestProperty property = step.getProperties().get("Endpoint");
				 property.setValue(mockEndpoint);
				}
			}
			catch(java.lang.NullPointerException ex)
				{
				 String error = "ERROR service "+ct.getMethodClass()+ ", operation "+ct.getMethod()+" not found";
				 log.error(error);
				 throw new TestGenerationException(error);
				}
		  }
	}

	
	   
	/**
	 * load in @param trace a possible trace (path root-leaf).
	 * @param node the root
	 * @param tree the tree
	 * @param trace where store traces
	 */
	private void retriveTraceFromTree (Position node, Tree tree, ArrayList<Interaction> trace)
	{ 
	 if (!tree.isRoot(node))
		 {trace.add((Interaction) node.element());}
	 if (tree.children(node).hasNext())
	 	{ // is not a leaf
		 Position child = tree.childAtRank(node, 0) ;
		 retriveTraceFromTree(child, tree, trace);
		}
	 else
	 	{ //delete the visited nodes until a node with not visited children
		 while (!tree.children(node).hasNext() && !(tree.isRoot(node)))
		 	{
			 Position father = tree.parent(node);
			 tree.removeExternal(node);
			 node = father;
		 	}
	 	}
	}
	
	
	
	

}
