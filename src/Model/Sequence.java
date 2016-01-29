package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Sequence {

	private String header;
	private String seq;
	private ArrayList<Boolean> seqBi;
	
	public Sequence() {
		setHeader(null);
		setSeq(null);
		seqBi = new ArrayList<>();
		
	}
	
	public void convertToBinary(){
		Mapping map = new Mapping();
		HashMap<String, ArrayList<Boolean>> mapping = map.getMap();
		
		for (Character ch : seq.toCharArray()){
			if (ch.equals('\n') ){
				continue;
			}
			seqBi.addAll(mapping.get(ch));
		}
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public ArrayList<Boolean> getSeqBi() {
		return seqBi;
	}

	private void setSeqBi(ArrayList<Boolean> seqBi) {
		this.seqBi = seqBi;
	}
	
	
	
	
}
