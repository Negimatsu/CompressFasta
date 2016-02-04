package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapping {
	private String gene;
	private ArrayList<Boolean> binaryGene;
	private HashMap<String, String> map;

	public Mapping() {
		setMap();
	}

	public ArrayList<Boolean> getBinaryGene() {
		return binaryGene;
	}

	private void setBinaryGene(ArrayList<Boolean> binaryGene) {
		this.binaryGene = binaryGene;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap() {
		this.map = new HashMap<>();
		map.put("A", "00");
		map.put("T", "01");
		map.put("C", "10");
		map.put("G", "11");
		
	}

}
