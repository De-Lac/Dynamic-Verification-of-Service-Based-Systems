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
 * $Id: TreeToDot.java 21-giu-2012 19.02.07 francesco $
 */
package partes.utils;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * The Class TreeToDot.
 */
public class TreeToDot {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String fileTree = "";
		Options options = new Options();
		HelpFormatter formatter = new HelpFormatter();
		options.addOption("f", "filetree", true, "specify file of tree to visualize");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd;
		try {
			cmd = parser.parse(options, args);
			if (cmd.getOptions().length == 0) {
				formatter.printHelp("TreeToDot", options, true);
				System.exit(0);
			}

			// get model option value
			fileTree = cmd.getOptionValue("f");

			if (fileTree==null) {
				formatter.printHelp("TreeToDot", options, true);
				System.exit(0);
			}

		} catch (ParseException e) {
			formatter.printHelp("TreeToDot", options, true);
			System.exit(0);
		}

		
		TreeUtils tu = new TreeUtils(fileTree);
		
		if (fileTree.endsWith(".xml")){
			fileTree = fileTree.substring(0, fileTree.length()-4);
		}
		
		String imgName = fileTree+".png";
		
		System.out.print("generating image... " + imgName);
		
		tu.generateImage(imgName);
		
		System.out.print(" done!");
		
		
	}

}
