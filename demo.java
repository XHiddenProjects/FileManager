package FileManagerTest;


import java.io.File;
import FileManager.*;
public class FileManagerTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		File fpath = fm.toFile("demo/test.html");
		File dpath = fm.toFile("demo");
		fm.add(dpath,true);
		fm.add(fpath);
		fm.write(fpath, "Test this out");
		System.out.println(fm.read(fpath));
		if(fm.remove(dpath,true)) {
			System.out.println("Successfully deleted");
		}
	}
}
