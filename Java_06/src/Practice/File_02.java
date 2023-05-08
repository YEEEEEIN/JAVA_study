package Practice; // FileInputStream

import java.io.FileInputStream;
import java.io.IOException;

public class File_02 {

	public static void main(String[] args) throws IOException {
		byte[] content = new byte[1000];
		FileInputStream input = new FileInputStream("C:\\Users\\예인\\Desktop\\dd\\out.txt");
		
		
		input.read(content);
		String allLine = new String(content);
		System.out.println(allLine);
		
		input.close();
	}

}
