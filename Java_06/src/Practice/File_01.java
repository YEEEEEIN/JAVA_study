package Practice; // FileOutputStream

import java.io.FileOutputStream;
import java.io.IOException;

public class File_01 {

	public static void main(String[] args) throws IOException {
		FileOutputStream output = new FileOutputStream("C:\\Users\\예인\\Desktop\\dd\\out.txt");
		for (int i = 1; i < 11; i++) {
			String data = "Line #" + i + "\n";
			output.write(data.getBytes());
		}
		output.close();

	}

}
