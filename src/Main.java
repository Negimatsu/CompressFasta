import java.io.BufferedReader;

import Model.PrepareReadFile;
import Model.ReadData;

public class Main {

	public static void main(String[] args) {
		PrepareReadFile prerd = new PrepareReadFile();
		String pathname = prerd.getPath();
		
		ReadData rd = new ReadData(pathname);
		
	}

}
