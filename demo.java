package FileManager;
import java.io.File;
public class FileManagerTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		File fpath = fm.toFile("test.html");
		File dpath = fm.toFile("demo");
		fm.add(dpath,true);
		fm.add(fpath);
		fm.write(fpath, "Test this out");
		System.out.println(fm.read(fpath));
		fm.delete(dpath);
	}
}
