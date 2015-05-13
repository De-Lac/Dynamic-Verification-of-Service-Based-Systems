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
 * $Id: WriteToFile.java 28/ott/2009 11:59:33 francesco $
 */

package partes.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * The Class WriteToFile.
 */
public class WriteToFile {

	/** The out. */
	private static BufferedWriter out;

	/** The hm. */
	private static HashMap<String, BufferedWriter> hm = new HashMap<String, BufferedWriter>();

	/**
	 * Write.
	 * 
	 * @param fileToWrite
	 *            the file to write
	 * @param strToWrite
	 *            the string to write
	 */
	public static void appendToFile(String fileToWrite, String strToWrite) {

		if (hm.containsKey(fileToWrite)) {
			out = hm.get(fileToWrite);
		} else {
		//	boolean success = (new File("logs")).mkdirs();
			try {
				out = new BufferedWriter(new FileWriter(fileToWrite));
				hm.put(fileToWrite, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			out.write(strToWrite);
			out.newLine();
			out.flush();
			// out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Write to a new file.
	 * 
	 * @param fileToWrite
	 *            the file to write
	 * @param strToWrite
	 *            the string to write
	 */
	public static void writeToANewFile(String fileToWrite, String strToWrite) {
		//boolean success = (new File("logs")).mkdirs();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite));
			bw.write(strToWrite);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println("wrong file creation!");
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Write to a new file.
	 * @param subdir
	 * 			  sub-directory of 'output' where to write
	 * @param fileToWrite
	 *            the file to write
	 * @param strToWrite
	 *            the string to write
	 */
	public static void writeToANewFileInOutputDir(String subidr, String fileToWrite, String strToWrite) {
		String dir = PartesConf.getString("outputPath")+"/"+subidr;
		boolean success = (new File(dir)).mkdirs();
		WriteToFile.writeToANewFile(dir+File.separator+fileToWrite, strToWrite);
		/*try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite));
			bw.write(strToWrite);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
}
