package Model;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadData {

	private BufferedReader buffRead;
	
	
	public ReadData(BufferedReader buff) {
		this.buffRead = buff;
	}
	
	public void readData(BufferedReader buffRead){
		String line = null;
		
		try {
			while ((line = buffRead.readLine()) != null)
			{				
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (buffRead != null) {
				try {
					buffRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	
	}
}
