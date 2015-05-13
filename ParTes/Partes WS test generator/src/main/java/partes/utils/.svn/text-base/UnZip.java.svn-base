/**
 * <copyright>
 * This file is part of BPTesting project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: UnZip.java 24/gen/2012 11:44:07 francesco $
 */
package partes.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * The Class UnZip.
 * 
 * @author francesco
 */
public class UnZip {

	/** The new path. */
	private String newPath;

	/**
	 * Instantiates a new un zip.
	 * 
	 * @param extractPath
	 *            the extract path
	 */
	public UnZip(String extractPath) {
		this.newPath = extractPath;
	}

	/**
	 * Unzip.
	 * 
	 * @param zipFile
	 *            the zip file
	 * @throws ZipException
	 *             the zip exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void unzip(String zipFile) throws ZipException, IOException {

		System.out.println(zipFile);
		int BUFFER = 2048;
		File file = new File(zipFile);

		ZipFile zip = new ZipFile(file);

		new File(newPath).mkdir();

		Enumeration zipFileEntries = zip.entries();

		// Process each entry
		while (zipFileEntries.hasMoreElements()) {
			// grab a zip file entry
			ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
			if (!entry.getName().contains("MACOSX")
					&& !entry.getName().contains("DS_Store")) {

				if (entry.isDirectory()) {
					// System.out.println("Name of Extract directory: "
					// + entry.getName());
					(new File(newPath, entry.getName())).mkdir();
					continue;
				}

				String currentEntry = entry.getName();

				File destFile = new File(newPath, currentEntry);

				if (!entry.isDirectory()) {
					BufferedInputStream is = new BufferedInputStream(
							zip.getInputStream(entry));
					int currentByte;
					// establish buffer for writing file
					byte data[] = new byte[BUFFER];

					// write the current file to disk
					FileOutputStream fos = new FileOutputStream(destFile);
					BufferedOutputStream dest = new BufferedOutputStream(fos,
							BUFFER);

					// read and write until last byte is encountered
					while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, currentByte);
					}
					dest.flush();
					dest.close();
					is.close();
				}

				if (currentEntry.endsWith(".zip")) {
					// found a zip file, try to open
					unzip(destFile.getAbsolutePath());
				}
			}
		}
		zip.close();
	}

	/**
	 * Clean.
	 * 
	 * @return true, if successful
	 */
	public boolean clean() {
		return deleteDir(new File(this.newPath));
	}

	// Deletes all files and subdirectories under dir.
	// Returns true if all deletions were successful.
	// If a deletion fails, the method stops attempting to delete and returns
	// false.
	/**
	 * Delete dir.
	 * 
	 * @param dir
	 *            the dir
	 * @return true, if successful
	 */
	private boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}

}
