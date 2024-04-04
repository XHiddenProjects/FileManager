package FileManagerTest;


import java.io.File;
import FileManager.*;
public class FileManagerTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		File fpath = fm.toFile("demo/test.html");
		File dpath = fm.toFile("Desktop\\demo");
		fm.add(dpath,true);
		fm.add(fpath);
		String userIn = fm.usePrompt("Enter Text");
		fm.write(fpath, userIn);
		System.out.println(fm.read(fpath));

		if(fm.remove(dpath,true)) {
			System.out.println("Successfully deleted");
		}else {
			System.out.println("Failed");
		}
	}
}
