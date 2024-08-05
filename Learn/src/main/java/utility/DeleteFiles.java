package utility;

import java.io.File;

public class DeleteFiles {

	/**
	 * This is a method created to delete the old files from a folder/directory.
	 * 
	 * @param dirPath : Directory path from where the file needs to be deleted.
	 * @param days    : file older than how many days should be deleted? ex. 10 days
	 *                or 20 days.
	 */
	// A method that takes a directory path and a number of days as parameters
	public void deleteFilesOlderThanNdays(String dirPath, int days) {
		// Create a File object for the directory
		File directory = new File(dirPath);
		// Check if the directory exists and is a directory
		if (directory.exists() && directory.isDirectory()) {
			// Get the current time in milliseconds
			long currentTime = System.currentTimeMillis();
			// Loop through all the files and subdirectories in the directory
			for (File file : directory.listFiles()) {
				// If the file is a file (not a directory) and is older than the specified
				// number of days, delete it
				if (file.isFile() && currentTime - file.lastModified() > days * 24 * 60 * 60 * 1000L) {
					file.delete();
					System.out.println("File deleted : " + file.getName());
				}
			}
		}
	}

}
