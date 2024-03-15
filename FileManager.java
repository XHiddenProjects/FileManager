package FileManager;

import java.io.*;
import java.nio.file.*;
import java.text.StringCharacterIterator;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * FileManager is an easy-to-use file management functions and keeps 
 * things organized and does the importing for you
 * @author XhiddenProjects
 * @version 1.0.2
 * @since 3/15/2024
 * @see <a href="https://github.com/XHiddenProjects/FileManager" target>Documentation</a>
 */
public class FileManager {
	/**
	 * Allows users input
	 * @param title - Show input title
	 * @return Users response*/
	public String usePrompt(String title) {
		String prompt = JOptionPane.showInputDialog(title);
		return prompt;
	}
	/**
	 * Converts String to valid File element
	 * @param path - String path to convert
	 * @return Returns a valid File object
	 * */
	public File toFile(String path) {
		return Paths.get(path).toFile();
	}
	/**
	 * Creates a file/directory 
	 * @param filePath - Path to add directory
	 * @param isDir - Creates folder, if true
	 * @return Returns the success on creating element
	 * */
	public boolean add(File filePath, boolean isDir) {
		try {
			if(isDir) {
				if(filePath.mkdirs()) {
					return true;
				}else {
					return false;
				}
			}else {
				if(filePath.createNewFile()) {
					return true;
				}else {
					return false;
				}
			}
			
		}catch(IOException e) {
			System.out.println("Error cannot add file");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Creates a file/directory 
	 * @param filePath - Path to add directory
	 * @return Returns the success on creating element
	 * */
	public boolean add(File filePath) {
		try {
			if(filePath.createNewFile()) {
				return true;
			}else {
				return false;
			}
		}catch(IOException e) {
			System.out.println("Error cannot add file");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Closes a file/directory 
	 * @param filePath - Path to add directory
	 * @return Returns the success on creating element
	 * */
	public boolean close(File filePath) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
		    fis.close();
		} catch (IOException e) {
			System.out.println("Failed to close file.");
		    e.printStackTrace();
		}
		return false;
	}
	/**
	 * Writes inside a file
	 * @param filePath - Path to file
	 * @param context - The value to place inside of file
	 * @return Returns the success on writing element
	 * */
	public boolean write(File filePath, String context) {
		try {
			FileWriter fileObj = new FileWriter(filePath);
			fileObj.write(context);
			fileObj.close();
			return true;
		} catch (IOException e) {
			System.out.println("Cannot write file");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Writes inside a file
	 * @param filePath - Path to file
	 * @return Returns the files context
	 * */
	public String read(File filePath) {
		try {
			String text="";
			Scanner fileRead = new Scanner(filePath);
			while(fileRead.hasNextLine()) {
				String data = fileRead.nextLine();
				text+=data;
			}
			fileRead.close();
			return text;
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Deletes files/folders
	 * @param filePath - Path to file
	 * @param isDir - File is a directory
	 * @return Returns the files deletion
	 * */
	public boolean remove(File filePath, boolean isDir) {
		//File fileObj = new File(file2);
		if(isDir) {
			File[] files = filePath.listFiles();
			for (File file : files) {
	            if (file.isDirectory()) {
	                this.remove(file, true);
	            } else {
	                file.delete();
	            }
	        }
			filePath.delete();
			return true;
		}else
			return false;
	}
	/**
	 * Deletes file/directory
	 * @param filePath - Path to file
	 * @return Returns the files deletion
	 * */
	public boolean remove(File filePath) {
		if(filePath.delete()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Renames file/directory
	 * @param filePath - Path to file
	 * @param newName - The new path to rename
	 * @return Returns the files rename succession
	 * */
	public boolean rename(File filePath, File newName) {
		if(filePath.renameTo(newName)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Get files` full name
	 * @param filePath - Path to file
	 * @return Returns the files full name
	 * */
	public String getFullName(File filePath) {
		return filePath.getName();
	}
	/**
	 * Get files` parent full name
	 * @param filePath - Path to file
	 * @return Returns the files full name
	 * */
	public String getParent(File filePath) {
		return filePath.getParent();
	}
	/**
	 * Get files' path
	 * @param filePath - Path to file
	 * @return Returns the files path
	 * */
	public String getPath(File filePath) {
		return filePath.getPath();
	}
	/**
	 * Get Absolute file
	 * @param filePath - Path to file
	 * @return Returns the files absolute file
	 * */
	public File getAbsFile(File filePath) {
		return filePath.getAbsoluteFile();
	}
	/**
	 * Get Absolute path
	 * @param filePath - Path to file
	 * @return Returns the absolute path
	 * */
	public String getAbsPath(File filePath) {
		return filePath.getAbsolutePath();
	}
	/**
	 * Get files` extension
	 * @param filePath - Path to file
	 * @return Returns the files` extension
	 * */
	public String getExtension(File filePath) {
		String[] args = this.getFullName(filePath).split("\\.");
		return args[1];
	}
	/**
	 * Get files' name
	 * @param filePath - Path to file
	 * @return Returns the files` name
	 * */
	public String getName(File filePath) {
		String[] args = this.getFullName(filePath).split("\\.");
		return args[0];
	}
	private String byte2read(long bytes) {
		 if (-1000 < bytes && bytes < 1000) {
		        return bytes + " B";
		    }
		    StringCharacterIterator ci = new StringCharacterIterator("kMGTPE");
		    while (bytes <= -999_950 || bytes >= 999_950) {
		        bytes /= 1000;
		        ci.next();
		    }
		    return String.format("%.1f %cB", bytes / 1000.0, ci.current());
	}
	/**
	 * Get paths free space
	 * @param filePath - Path to file
	 * @return Returns the path free space
	 * */
	public String getFreeSpace(File filePath) {
		return this.byte2read(filePath.getFreeSpace());
	}
	/**
	 * Get paths total space
	 * @param filePath - Path to file
	 * @return Returns the paths total space
	 * */
	public String getTotalSpace(File filePath) {
		return this.byte2read(filePath.getTotalSpace());
	}
	/**
	 * Get paths usable space
	 * @param filePath - Path to file
	 * @return String - Returns the paths usable space
	 * */
	public String getUsableSpace(File filePath) {
		return this.byte2read(filePath.getUsableSpace());
	}
	/**
	 * Get canonical files
	 * @param filePath - Path to file
	 * @return Returns the canonical file
	 * */
	public File getCanFile(File filePath) {
		File path = null;
		try {
			path = filePath.getCanonicalFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	/**
	 * Get canonical path
	 * @param filePath - Path to file
	 * @return Returns the canonical path
	 * */
	public String getCanPath(File filePath) {
		String path = null;
		try {
			path = filePath.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	/**
	 * Compares both paths
	 * @param filePath1 - Path to file
	 * @param filePath2 - Path to file
	 * @return Returns the files full name
	 * */
	public int compare(File filePath1, File FilePath2) {
		return filePath1.compareTo(FilePath2);
	}
	/**
	 * Get hashcode from filepath
	 * @param filePath - Path to file
	 * @return Returns the hashcode filepath
	 * */
	public int hashCode(File filePath) {
		return filePath.hashCode();
	}
	/**
	 * List all files
	 * @param filePath - Path to file
	 * @param files - Returns all files
	 * @return Returns the all files
	 * */
	public File[] list(File filePath, boolean files) {
		if(files) {
			return filePath.listFiles();
		}
		return null;
	}
	/**
	 * List all files
	 * @param filePath - Path to file
	 * @return Returns the all files names
	 * */
	public String[] list(File filePath) {
		return filePath.list();
	}
	/**
	 * List all files
	 * @param filePath - Path to file
	 * @param files - Returns all files
	 * @return Returns the all abstract files/directory
	 * */
	public File[] listFilter(File filePath, boolean files, FilenameFilter filter) {
		if(files) {
		return filePath.listFiles(filter);
		}
		return null;
	}
	/**
	 * List all files
	 * @param filePath - Path to file
	 * @param files - Returns all files
	 * @return Returns an array of abstract files/directory
	 * */
	public String[] listFilter(File filePath, FilenameFilter filter) {
		return filePath.list(filter);
	}
	/**
	 * Checks if the file/directory is...
	 * @param filePath - Path to file
	 * @param type - The type to check
	 * @return Returns boolean of file/directory status
	 * */
	public boolean is(File filePath, String type) {
		boolean results=false;
		switch(type.toLowerCase()) {
			case "hidden":
				results = filePath.isHidden();
			break;
			case "absolute":
				results = filePath.isAbsolute();
			break;
			case "dir":
				results = filePath.isDirectory();
			break;
			case "file":
				results = filePath.isFile();
			break;
			case "exists":
				results = filePath.exists();
			break;
			default:
				System.out.println("You must select the following options:\n- hidden\n- absolute\n- dir\n- file\n- exists");
			break;
		}
		return results;
	}
	/**
	 * Check if the file/directory can...
	 * @param filePath - Path to file
	 * @param type - The type to check
	 * @return Returns the all files
	 * */
	public boolean can(File filePath, String type) {
		boolean result=false;
		switch(type.toLowerCase()) {
			case "read":
				result = filePath.canRead();
			break;
			case "write":
				result = filePath.canWrite();
			break;
			case "execute":
				result = filePath.canExecute();
			break;
			default:
				System.out.println("You must select\n- read\n- write\n- execute");
			break;
		}
		return result;
	}
	/**
	 * Sets the file/directory permission
	 * @param filePath - Path to file
	 * @param type - The type to check
	 * @return Returns the boolean of the file/directory permission
	 * */
	public void set(File filePath, String type) {
		switch(type.toLowerCase()) {
			case "read":
				filePath.setReadable(true);
			break;
			case "write":
				filePath.setWritable(true);
			break;
			case "execute":
				filePath.setExecutable(true);
			break;
			default:
				System.out.println("You must select\n- read\n- write\n- execute");
			break;
		}
	}
	/**
	 * Sets the file/directory permission
	 * @param filePath - Path to file
	 * @param type - The type to check
	 * @param value - Sets the permission
	 * @return Returns the boolean of the file/directory permission
	 * */
	public void set(File filePath, String type, boolean value) {
		switch(type.toLowerCase()) {
			case "read":
				filePath.setReadable(value);
			break;
			case "write":
				filePath.setWritable(value);
			break;
			case "execute":
				filePath.setExecutable(value);
			break;
			default:
				System.out.println("You must select read, write, and execute");
			break;
		}
	}
	
}
