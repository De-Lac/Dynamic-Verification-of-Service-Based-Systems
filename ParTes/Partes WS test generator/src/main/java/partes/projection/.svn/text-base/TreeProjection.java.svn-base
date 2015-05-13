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
 * $Id: TreeProjection.java 28/ott/2009 11:34:56 francesco $
 */

package partes.projection;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
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
import org.ow2.choreos.partes.ParticipantInteractionTreeGenerator;

import partes.commons.Interaction;
import partes.utils.TreeUtils;
import partes.utils.WriteToFile;

import com.thoughtworks.xstream.XStream;

/**
 * The Class TreeProjection.
 */
public class TreeProjection implements ParticipantInteractionTreeGenerator {

	/** The log. */
	private Log log = LogFactory.getLog(TreeProjection.class);

	/* (non-Javadoc)
	 * @see partes.projection.ParticipantInteractionTreeGenerator#makeProjection(jdsl.core.api.Tree, java.lang.String[])
	 */
	@Override
	public/* HashMap<String, Tree> */Vector<ProjectionInfo> makeProjection(
			Tree tree, String[] services) {
		Vector<ProjectionInfo> projections = new Vector<ProjectionInfo>();

		log.info("processing of tree ");

		HashMap<String, Tree> testTrees = evaluateSubTree(tree, services);

		Iterator<String> i = testTrees.keySet().iterator();

		//XStream xstream = new XStream();
		while (i.hasNext()) {
			String key = i.next();
			Tree valueTree = testTrees.get(key);
			// String valueTreeXML = xstream.toXML(valueTree);
			projections.add(new ProjectionInfo(key, valueTree));
		}
		// printTests(testTrees, 1);
		log.info("end of processing");
		return projections;
	}

	/**
	 * Prints the tests.
	 * 
	 * @param testTrees
	 *            the test trees
	 * @param treeCounter
	 *            the tree counter
	 */
	private void printTests(HashMap<String, Tree> testTrees, int treeCounter) {
		Set<String> services = testTrees.keySet();
		Iterator<String> serviceIterator = services.iterator();

		while (serviceIterator.hasNext()) {
			String service = serviceIterator.next();
			Tree tree = testTrees.get(service);

			String dotSource = TreeUtils.writeTreeToDotFile(tree, "test-"
					+ treeCounter + "-" + service + ".dot");

			String xmlSource = TreeUtils.writeTreeToXMLFile(tree, "test-"
					+ treeCounter + "-" + service + ".xml");

			TreeUtils.generateImage(dotSource, "test-" + treeCounter + "-"
					+ service + ".png");
			log.info("generated dot, png and xml files: test-" + treeCounter
					+ "-" + service);
			// System.out.println("[TreeProjection] generated dot, png and xml files: test-"+treeCounter+"-"+service);
		}

	}

	/**
	 * Evaluate positions.
	 * 
	 * @param tree
	 *            the tree
	 * @param service
	 *            the service
	 * @return the tree
	 */
	private Tree evaluatePositions(Tree tree, String service) {
		PositionIterator positions = tree.positions();

		while (positions.hasNext()) {
			Position position = positions.nextPosition();
			tree = evaluatePosition(tree, position, service);
		}

		return tree;
	}

	/**
	 * Evaluate sub tree.
	 * 
	 * @param tree
	 *            the tree
	 * @return the hash map
	 */
	private HashMap<String, Tree> evaluateSubTree(Tree tree, String[] services) {
		HashMap<String, Tree> testTrees = new HashMap<String, Tree>();

		// Patch:
		// salva una rappresentaizone xml dell'oggetto tree
		// altrimenti viene modificato sempre lo stesso!
		XStream xstream = new XStream();
		String xml = xstream.toXML(tree);

		int serviceIndex = 0;
		while (serviceIndex < services.length) {
			log.info("looking for service: " + services[serviceIndex]);
			Tree searchTree = (Tree) xstream.fromXML(xml);
			Tree test = evaluatePositions(searchTree, services[serviceIndex]);
			testTrees.put(services[serviceIndex], test);
			serviceIndex++;
		}

		return testTrees;

	}

	/**
	 * Evaluate position.
	 * 
	 * @param tree
	 *            the tree
	 * @param p
	 *            the p
	 * @param service
	 *            the service
	 * @return the tree
	 */
	private Tree evaluatePosition(Tree tree, Position p, String service) {
		if (p.element() == null) {
			log.info("evaluatePosition: null interaction!");
			//System.out
			//		.println("[TreeProjection] evaluatePosition: null interaction!");
			return tree;
		}
		/*
		 * la seconda parte dell'if serve per considerare solo le parti
		 * rilevanti!
		 */
		//if (((Interaction) p.element()).getMethodClass().compareTo(service) != 0
		//		|| !((Interaction) p.element()).isInteresting()) {
		 if (((Interaction)p.element()).getMethodClass().compareTo(service) != 0) {

			// usando questo if al posto del precedente si proietta tutto senza
			// considerare le parti interessanti
			// if (((Interaction)
			// p.element()).getMethodClass().compareTo(service) != 0) {

			if (!tree.isRoot(p) && !tree.isExternal(p)) 
				{
				 tree.contract(p);
				} 
			else 
				{// radice o foglia
				 if (tree.isExternal(p) && !tree.isRoot(p)) 
				 	{// foglia
					 tree.removeExternal(p);
				 	} 
				 else 
				 	{// radice
					 // if (tree.isRoot(p)) {
					 if (tree.numChildren(p) != 1) 
					   {
						Interaction init = new Interaction("root");
						tree.replaceElement(p, init);
						// radice fittizia
					   } 
					 else 
					   { // un solo figlio
						tree = tree.cut(tree.firstChild(p));
					   }
					// }
				 	}
				}
		 }

		return tree;
	}

	/**
	 * Detach sub tree from root.
	 * 
	 * @param aTree
	 *            the a tree
	 * @return the vector
	 */
	private Vector<Tree> detachSubTreeFromRoot(Tree aTree) {
		Vector<Tree> subTrees = new Vector<Tree>();

		PositionIterator childrenOfRoot = aTree.children(aTree.root());

		while (childrenOfRoot.hasNext()) {
			Position children = childrenOfRoot.nextPosition();
			Tree subTree = aTree.cut(children);
			subTrees.add(subTree);
		}

		return subTrees;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String fileTreeOfInteraction = "";
		String[] services = new String[1];
		services[0] = "";

		Options options = new Options();
		HelpFormatter formatter = new HelpFormatter();
		options.addOption("t", "interactiontree", true,
				"specify interaction tree file");
		options.addOption("p", "participant", true,
				"specify participant to project");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			if (cmd.getOptions().length == 0) {
				formatter.printHelp("TreeProjection", options, true);
				System.exit(0);
			}

			fileTreeOfInteraction = cmd.getOptionValue("t");
			services[0] = cmd.getOptionValue("p");

			if (fileTreeOfInteraction == null || services[0] == null) {
				formatter.printHelp("TreeProjection", options, true);
				System.exit(0);
			}

		} catch (ParseException e) {
			formatter.printHelp("TreeProjection", options, true);
			System.exit(0);
		}

		ParticipantInteractionTreeGenerator tp = new TreeProjection();
		TreeUtils tu = new TreeUtils(fileTreeOfInteraction);

		Vector<ProjectionInfo> piv = tp.makeProjection(tu.getTree(), services);

		for (ProjectionInfo pi : piv) {
			XStream xstream = new XStream();
			String xml = xstream.toXML(pi.getProjectionTree());
			WriteToFile.writeToANewFileInOutputDir("TestSuite"+File.separator,
					"projection-" + pi.getService() + ".xml", xml);
		}

	}
}
