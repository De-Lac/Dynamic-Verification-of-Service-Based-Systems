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
 * $Id: TreeReader.java 28/ott/2009 11:34:56 francesco $
 */

package partes.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jdsl.core.api.Position;
import jdsl.core.api.PositionIterator;
import jdsl.core.api.Tree;
import partes.commons.Interaction;

import com.thoughtworks.xstream.XStream;

/**
 * The Class TreeReader.
 */
public class TreeUtils {
	
	/** The xml. */
	private String xml;
	
	/** The tree. */
	private Tree tree;
	
	/** The dot source. */
	private String dotSource;

	/**
	 * Instantiates a new tree reader.
	 * 
	 * @param fileName
	 *            the file name
	 */
	public TreeUtils(String fileName) {
		this.xml = read(fileName);
		XStream xstream = new XStream();
		this.tree = (Tree) xstream.fromXML(this.xml);
		
		StringBuilder sb = new StringBuilder();
		sb.append("digraph G {\n");
		writeTreeDot(this.tree, this.tree.root(), sb);
		sb.append("}");
		this.dotSource = sb.toString().trim();
		
	}

	/**
	 * Generate image.
	 * 
	 * @param imageFile
	 *            the image file
	 */
	public void generateImage(String imageFile) {
		GraphViz gv = new GraphViz();
		gv.add(this.dotSource.trim());
		File out = new File(imageFile);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource()), out);
	}
	
	/**
	 * Write tree to dot file.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the string
	 */
	public String writeTreeToDotFile(String fileName) {
		//StringBuilder sb = new StringBuilder();
		//sb.append("digraph G {\n");
		//writeTreeDot(this.tree, this.tree.root(), sb);
		//sb.append("}");
		WriteToFile.writeToANewFile(fileName, this.dotSource.trim());
		//this.dotSource = sb.toString().trim();
		return this.dotSource;
	}
	
	
	
//	/**
//	 * Write tree dot.
//	 * 
//	 * @param tree
//	 *            the tree
//	 * @param p
//	 *            the p
//	 * @param sb
//	 *            the sb
//	 */
//	private void writeTreeDot(Tree tree, Position p, StringBuilder sb) {
//		if (tree.numChildren(p) != 0) {
//			if (!tree.isRoot(p)) {
//				sb.append(((Interaction) tree.parent(p).element()).hashCode()
//						+ " [label = \""
//						+ ((Interaction) tree.parent(p).element())
//								.showInteraction() + "\"];\n");
//				sb.append(((Interaction) p.element()).hashCode()
//						+ " [label = \""
//						+ ((Interaction) p.element()).showInteraction()
//						+ "\"];\n");
//				sb.append(((Interaction) tree.parent(p).element()).hashCode()
//						+ " -> " + ((Interaction) p.element()).hashCode()
//						+ ";\n");
//			} //else {
//			//
//			//}
//			PositionIterator pi = tree.children(p);
//			while (pi.hasNext()) {
//				writeTreeDot(tree, pi.nextPosition(), sb);
//			}
//		} else {
//			if (!tree.isRoot(p)) {
//				sb.append(((Interaction) tree.parent(p).element()).hashCode()
//						+ " [label = \""
//						+ ((Interaction) tree.parent(p).element())
//								.showInteraction() + "\"];\n");
//				sb.append(((Interaction) p.element()).hashCode()
//						+ " [label = \""
//						+ ((Interaction) p.element()).showInteraction()
//						+ "\"];\n");
//				sb.append(((Interaction) tree.parent(p).element()).hashCode()
//						+ " -> " + ((Interaction) p.element()).hashCode()
//						+ ";\n");
//			} //else {
//			//
//			//}
//		}
//
//	}
	
	/**
	 * Write tree dot.
	 * 
	 * @param tree
	 *            the tree
	 * @param p
	 *            the p
	 * @param sb
	 *            the sb
	 */
	private static void writeTreeDot(Tree tree, Position p, StringBuilder sb) {
		if (tree.numChildren(p) != 0) {
			if (!tree.isRoot(p) && !((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " [label = \""
						+ ((Interaction) tree.parent(p).element())
								.showInteraction() + "\"];\n");
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element()).showInteraction()
						+ "\"];\n");
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " -> " + ((Interaction) p.element()).hashCode()
						+ ";\n");
			} //else {
			//
			//}

			if (!tree.isRoot(p) && ((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " [label = \""
						+ ((Interaction) tree.parent(p).element())
								.showInteraction() + "\", color=red];\n");
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element()).showInteraction()
						+ "\", color=red];\n");
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " -> " + ((Interaction) p.element()).hashCode()
						+ ";\n");
			}

			PositionIterator pi = tree.children(p);
			while (pi.hasNext()) {
				writeTreeDot(tree, pi.nextPosition(), sb);
			}
		} else {
			if (!tree.isRoot(p) && !((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " [label = \""
						+ ((Interaction) tree.parent(p).element())
								.showInteraction() + "\"];\n");
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element()).showInteraction()
						+ "\"];\n");
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " -> " + ((Interaction) p.element()).hashCode()
						+ ";\n");
			} //else {
			//
			//}

			if (!tree.isRoot(p) && ((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " [label = \""
						+ ((Interaction) tree.parent(p).element())
								.showInteraction() + "\", color=red];\n");
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element()).showInteraction()
						+ "\", color=red];\n");
				sb.append(((Interaction) tree.parent(p).element()).hashCode()
						+ " -> " + ((Interaction) p.element()).hashCode()
						+ ";\n");
			}
			
			// this is for projected trees with only one node
			if (tree.isRoot(p) && !((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element())
								.showInteraction() + "\"];\n");
			}
			
			if (tree.isRoot(p) && ((Interaction) p.element()).isInteresting()) {
				sb.append(((Interaction) p.element()).hashCode()
						+ " [label = \""
						+ ((Interaction) p.element())
								.showInteraction() + "\", color=red];\n");
			}
			
			

		}

	}
	
	/**
	 * Gets the tree.
	 * 
	 * @return the tree
	 */
	public Tree getTree() {
		return tree;
	}

	/**
	 * Read.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the string
	 */
	private static String read(String fileName) {
		BufferedReader br;
		String xml = "";
		try {
			/*
			br = new BufferedReader(new FileReader("logs" + File.separator
					+ fileName));
			*/
			br = new BufferedReader(new FileReader(fileName));
			String str;
			while ((str = br.readLine()) != null) {
				xml = xml.concat(str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xml;
	}
	
	/**
	 * Generate image.
	 * 
	 * @param dotSource
	 *            the dot source
	 * @param imageFile
	 *            the image file
	 */
	public static void generateImage(String dotSource, String imageFile) {
		GraphViz gv = new GraphViz();
		gv.add(dotSource.trim());
		File out = new File(imageFile);
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource()), out);
	}
	
	/**
	 * Write tree to dot file.
	 * 
	 * @param tree
	 *            the tree
	 * @param fileName
	 *            the file name
	 * @return the string
	 */
	public static String writeTreeToDotFile(Tree tree, String fileName) {
		StringBuilder sb = new StringBuilder();
		sb.append("digraph G {\n");
		writeTreeDot(tree, tree.root(), sb);
		sb.append("}");

		String str = sb.toString().trim();
		//boolean success = (new File(PartesConf.getString("treeprojection.outdir"))).mkdirs();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(str);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString().trim();
	}
	
	/**
	 * Write tree to xml file.
	 * 
	 * @param tree
	 *            the tree
	 * @param fileName
	 *            the file name
	 * @return the string
	 */
	public static String writeTreeToXMLFile(Tree tree, String fileName) {
		XStream xstream = new XStream();
		String xml = xstream.toXML(tree);

		//boolean success = (new File(PartesConf.getString("treeprojection.outdir"))).mkdirs();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(xml);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return xml;
	}
	

}
