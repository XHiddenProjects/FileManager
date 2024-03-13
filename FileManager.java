package CS121Chapter4;
import java.io.*;
import java.nio.file.*;
import java.text.StringCharacterIterator;
import java.util.*;

public class FileManager {
	public File toFile(String path) {
		return Paths.get(path).toFile();
	}
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
	public String read(File filePath) {
		try {
			String text="";
			Scanner fileRead = new Scanner(filePath);
			while(fileRead.hasNextLine()) {
				String data = fileRead.nextLine();
				text+=data;
			}
			return text;
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return "";
	}
	public boolean delete(File filePath, boolean isDir) {
		//File fileObj = new File(file2);
		if(isDir) {
			File[] files = filePath.listFiles();
			for (File file : files) {
	            if (file.isDirectory()) {
	                this.delete(file, true);
	            } else {
	                file.delete();
	            }
	        }
			filePath.delete();
			return true;
		}else
			return false;
	}
	public boolean delete(File filePath) {
		if(filePath.delete()) {
			return true;
		}else {
			return false;
		}
	}
	public String getFullName(File filePath) {
		return filePath.getName();
	}
	public String getParent(File filePath) {
		return filePath.getParent();
	}
	public String getPath(File filePath) {
		return filePath.getPath();
	}
	public File getAbsFile(File filePath) {
		return filePath.getAbsoluteFile();
	}
	public String getAbsPath(File filePath) {
		return filePath.getAbsolutePath();
	}
	public String getExtension(File filePath) {
		String[] args = this.getFullName(filePath).split("\\.");
		return args[1];
	}
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
	public String getFreeSpace(File filePath) {
		return this.byte2read(filePath.getFreeSpace());
	}
	public String getTotalSpace(File filePath) {
		return this.byte2read(filePath.getTotalSpace());
	}
	public String getUsableSpace(File filePath) {
		return this.byte2read(filePath.getUsableSpace());
	}
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
	public int compare(File filePath1, File FilePath2) {
		return filePath1.compareTo(FilePath2);
	}
	public int hashCode(File filePath) {
		return filePath.hashCode();
	}
	
	public File[] list(File filePath, boolean files) {
		if(files) {
			return filePath.listFiles();
		}
		return null;
	}
	public String[] list(File filePath) {
		return filePath.list();
	}
	public File[] listFilter(File filePath, boolean files, FilenameFilter filter) {
		if(files) {
		return filePath.listFiles(filter);
		}
		return null;
	}
	public String[] listFilter(File filePath, FilenameFilter filter) {
		return filePath.list(filter);
	}
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
	public void set(File filePath, String type) {
		switch(type.toLowerCase()) {
			case "read":
				filePath.setReadable(false);
			break;
			case "write":
				filePath.setWritable(false);
			break;
			case "execute":
				filePath.setExecutable(false);
			break;
			default:
				System.out.println("You must select\n- read\n- write\n- execute");
			break;
		}
	}
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
