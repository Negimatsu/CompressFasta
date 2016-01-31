import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import Model.PrepareReadFile;
import Model.PrepareWriteFile;
import Model.ReadData;
import Model.Sequence;

public class Main {

	public static void main(String[] args) {
		PrepareReadFile prerd = new PrepareReadFile();
		String pathname = prerd.getPath();
		
		ReadData rd = new ReadData(pathname);
		LinkedHashMap<String, Sequence> dataFasta = null;
		
		dataFasta = rd.getdataFasta();
		

		PrepareWriteFile writeFile = new PrepareWriteFile("Test.ongkrab", dataFasta);
		System.out.println("COmplete");
			
	}

}
