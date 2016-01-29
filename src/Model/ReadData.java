package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {

	private BufferedReader buffRead;
	private String pathname;
	private File tmpFile;
	
	
	public ReadData(String pathname) {
		this.pathname = pathname;
		tmpFile = new File(pathname);
		readFile();
	}
	
	private void readFile(){	
		
		FileReader fileReader = null;
		String line = null;
		try {
			fileReader = new FileReader(tmpFile);
			buffRead = new BufferedReader(fileReader);
			
			while ((line = buffRead.readLine()) != null)
			{				
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(this.pathname + "File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
