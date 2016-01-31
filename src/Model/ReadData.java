package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ReadData {

	private BufferedReader buffRead;
	private String pathname;
	private File tmpFile;
	private LinkedHashMap<String, Sequence> dataFasta;
	
	
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
			
			int flag = 0;  // 0 initial, 1 add seq, 2 add Data to map.
			dataFasta = new LinkedHashMap<>();
			String headerSeq = null;
			String seqStr = "";
			Sequence seq = new Sequence();
			
			while ((line = buffRead.readLine()) != null)
			{	
				
				if (line.charAt(0) == '>' && headerSeq == null){
					headerSeq = line;
					flag = 1;
				}else if (line.charAt(0) == '>' && headerSeq != null && !seqStr.equals("")){
					flag = 2;
				}
				
				switch (flag) {
					
				case 1:
					String replaceLine = line.replaceAll("[\\t\\n\\r]+"," ");
					seqStr += replaceLine;
					flag = 1;
					break;
					
				case 2:
					seq.setHeader(headerSeq);
					seq.setSeq(seqStr);
					dataFasta.put(headerSeq, seq);
					
					headerSeq = line;
					
					System.out.println("add sequence to map" + headerSeq + "\nseq is" + seqStr);
					headerSeq = null;
					seqStr = "";
					flag = 1;
					break;
					
				default:
					break;
					
				}
				
				//System.out.println(line);
			}
			if ( !(headerSeq == null && seqStr.equals(""))){
				seq.setHeader(headerSeq);
				seq.setSeq(seqStr);
				dataFasta.put(headerSeq, seq);
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
	
	public LinkedHashMap<String, Sequence> getdataFasta(){
		return dataFasta;
	}
	
}
