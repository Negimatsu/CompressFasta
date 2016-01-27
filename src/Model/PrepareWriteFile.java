package Model;

import java.io.*;
import java.util.*;

public class PrepareWriteFile {
	private final int ITERATIONS = 5;
	private final double MEG = (Math.pow(1024, 2));
	private final int RECORD_COUNT = 4000000;
	private final String RECORD = "Help I am trapped in a fortune cookie factory\n";
	private final int RECSIZE = RECORD.getBytes().length;
	
	
	public PrepareWriteFile() throws IOException {
	    
		List<String> records = new ArrayList<String>(RECORD_COUNT);
	    int size = 0;
	    for (int i = 0; i < RECORD_COUNT; i++) {
	        records.add(RECORD);
	        size += RECSIZE;
	    }
	    System.out.println(records.size() + " 'records'");
	    System.out.println(size / MEG + " MB");

	    for (int i = 0; i < ITERATIONS; i++) {
	        System.out.println("\nIteration " + i);

	        writeRaw(records);
	        writeBuffered(records, 8192);
	        writeBuffered(records, (int) MEG);
	        writeBuffered(records, 4 * (int) MEG);
	    }
	}
	
	
	
	
	private void writeRaw(List<String> records) throws IOException {
		File file = File.createTempFile("foo", ".txt");
		try {
			FileWriter writer = new FileWriter(file);
			System.out.print("Writing raw... ");
			write(records, writer);
		} finally {
			// comment this out if you want to inspect the files afterward
			file.delete();
		}
	}

	private void writeBuffered(List<String> records, int bufSize) throws IOException {
		File file = File.createTempFile("foo", ".txt");
		try {
			FileWriter writer = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(writer, bufSize);

			System.out.print("Writing buffered (buffer size: " + bufSize + ")... ");
			write(records, bufferedWriter);
		} finally {
			// comment this out if you want to inspect the files afterward
			file.delete();
		}
	}

	private void write(List<String> records, Writer writer) throws IOException {
		long start = System.currentTimeMillis();
		for (String record: records) {
			writer.write(record);
		}
		writer.flush();
		writer.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f + " seconds");
	}
}
