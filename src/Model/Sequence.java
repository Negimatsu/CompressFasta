package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Sequence {

	private String header;
	private String seq;
	private String seqBi;
	private int sizeSeq;
	private String headSeqString;
	private int addChar;
	private ArrayList<Integer> completeSeq;
	
	public Sequence() {
		setHeader(null);
		setSeq("");
		this.setSeqBi("");
		
	}
	
	public ArrayList<Integer> convertSequence(){
		
		convertToBinary();
		calculateAddChar();
		seqBi = headSeqString + seqBi;
		
		this.setCompleteSeq();
		convertSeqToASCII();
		System.out.println("Before size XXXX"+ seqBi.length()+"XXXX after size " + completeSeq.size());
		return completeSeq;
	}
	
	
	
	private void convertToBinary(){
		Mapping map = new Mapping();
		HashMap<String, String> mapping = map.getMap();
		
		for (Character ch : seq.toCharArray()){

			if (mapping.containsKey(ch.toString())){
				
				seqBi += mapping.get(ch.toString());
			}
		}
	}
	
	private void calculateAddChar(){
		addChar = 8 - seqBi.length()%8;
		if (seqBi.length()%4 == 0){
			addChar = 0;
		}
		
		headSeqString = "";
		System.out.print("Size of sequence "+ seqBi.length() );
		for (int i = 0; i < addChar; i++){
			headSeqString += "0";
		}
		System.out.println("   :  Add Header " + headSeqString.length());
	}
	
	private void convertSeqToASCII(){
		if (!checkSeqModeFour()){
			System.out.println(seqBi.length());
			System.out.println("Sequence "+ header + " can not mod 8.");
		}
		
		int seqBiSize = seqBi.length();
		int endIndex = 0;
		String rangSeqBi = "";
		
		for (int currentPoint = 0; currentPoint <= seqBiSize - 8 ;currentPoint += 8){
			endIndex = currentPoint + 8;
			rangSeqBi = seqBi.substring(currentPoint, endIndex);
			completeSeq.add(convertASCII(rangSeqBi));
		}

	}
	
	
	private int convertASCII(String binarySeq){
		if (binarySeq.length()%8 != 0){
			System.out.println("gene not equal 8 digit" + header);
		}
		
		//System.out.println(binarySeq);
		//byte byGene = (byte) Integer.parseUnsignedInt(binarySeq ,2);
		int byGene = Integer.parseUnsignedInt(binarySeq ,2);
		return byGene;
		
	}
	private boolean checkSeqModeFour(){
		return seqBi.length()%8 == 0 ? true : false;
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
		this.setSizeSeq(seq.length());
	}

	public String getSeqBi() {
		return seqBi;
	}

	private void setSeqBi(String seqBi) {
		this.seqBi = seqBi;
	}

	public int getSizeSeq() {
		return sizeSeq;
	}

	private void setSizeSeq(int sizeSeq) {
		this.sizeSeq = sizeSeq;
	}

	public ArrayList<Integer> getCompleteSeq() {
		return completeSeq;
	}

	public void setCompleteSeq() {
		this.completeSeq = new ArrayList<>();
	}
	
	
}
