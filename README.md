# FileManager
FileManager is a easy Java extension that makes file managing easier
### How to install
1. Download `FileManager.java`
2. Create a package named _FileManager_
3. Import the code by using this code:
    ```java
      import FileManager.*;
    ```
4. Then too use it, use this code:
   ```java
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
	}
   ```
Now you are finished with the activation! 

**Note**: `fm` is going to be use throughout the documentation.
***
## Basics
### Converting String to File
To convert a String to a File use this code
```java
  File fPath = fm.toFile("demo/test.html"); //Makes "test.html" to a file
  File dPath = fm.toFile("demo"); //Makes "demo" to a directory
```
### Adding files/directories
To create a file/directory type:
```java
  fm.add(dPath,true); //Create a directory
  fm.add(fPath); //Creates a file inside the directory
```
### Writing in files
To add context into a file, type:
```java
  fm.write(fPath, "Random text"); //Adds "Random text" to the file
```
### Reading files
To read a file, type:
```java
  fm.read(fPath);//Reads lines from the file
```
### Deleting files/directories
To delete files/directories, type:
```java
  fm.delete(fPath);//Deletes file
  fm.delete(dPath, true);//Deletes Directory
```
### Renaming files/directories
To rename files/directories, type:
```java
  File newPath = fm.toFile("demo/updated.html");
  fm.rename(fPath,newPath);//Renames "test.html" to "updated.html"
```
***
## GET functions
These are methods that will get file informations

### getFullName
This will get the files full name; type:
```java
  fm.getFileName(fPath);//Returns the file name
```
### getParent
This is get the parent of the file; type:
```java
  fm.getParent(fPath);//Returns the files parent
```
### getPath
This will get the files path
```java
  fm.getPath(fPath);//Returns the files path
```
### getAbsFile / getAbsPath
This will get the "absolute file" or "absolute path"; type:
```java
  fm.getAbsFile(fPath);//Returns the absolute file
  fm.getAbsPath(fPath);//Returns the absolute path
```
### getExtension
This will get the file extension; type:
```java
  fm.getExtension(fPath);//Returns file extension
```
### getName
This will get the file name
```java
  fm.getName(fPath);//Returns files name
```
### getFreeSpace
This will get the amount of _free space_ in human-readable format; type:
```java
  fm.getFreeSpace(fPath);
```
### getTotalSpace
This will get the amount of _total space_ in human-readable format; type:
```java
  fm.getTotalSpace(fPath);
```
### getUsableSpace
This will get the amount of _usable space_ in human-readable format; type:
```java
  fm.getUsableSpace(fPath);
```
### getCanFile / getCanPath
This will get _Canonical File_ or _Canonical Path_; type:
```java
  fm.getCanonicalFile(fPath);//Returns the CanonicalFile
fm.getCanonicalPath(fPath);//Returns the CanonicalPath
```
***
## Extras
These are extra methods you can use as well

### compare
This will compare two filepaths; type:
```java
  fm.compare(fPath,dPath);//Returns number of difference
```
### hashCode
Get files hashcode; type:
```java
  fm.hash(fPath);//Returns hashcode
```
### list
Returns a list of directories and/or files; type:
```java
  fm.list(dPath);//List files/directories
  fm.list(dPath,true);//List files only
```
### list w/ filter
Returns a list of directories and/or files based on filter; type:
```java
  fm.listFilter(dPath); //Returns filtered directories/files
  fm.listFilter(dPath, true); //Returns filtered files
```
### is
Check if the filepath _is_; type:
```java
  fm.is(fPath, "hidden");//Alloed items: "hidden", "absolute", "dir", "file", "exists"
```
### can
Check if the filepath _can_; type:
```java
  fm.can(fPath, "read");//Allowed items: "read", "write", or "execute"
```
### set
_Set_ the filepath permission; type:
```java
  fm.set(fPath, "read");//Allowed items: "read", "write", or "execute"
  fm.set(fPath, "read", false);//Allowed items: "read", "write", or "execute"
```
