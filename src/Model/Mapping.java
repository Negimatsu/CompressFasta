package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapping {
	private String gene;
	private ArrayList<Boolean> binaryGene;
	private HashMap<String, ArrayList<Boolean>> map;

	public Mapping() {
		setMap();
	}

	public ArrayList<Boolean> getBinaryGene() {
		return binaryGene;
	}

	public void setBinaryGene(ArrayList<Boolean> binaryGene) {
		this.binaryGene = binaryGene;
	}

	public HashMap<String, ArrayList<Boolean>> getMap() {
		return map;
	}

	public void setMap() {
		this.map = new HashMap<>();
		ArrayList<Boolean> tmp = new ArrayList<>();
		tmp.add(false);
		tmp.add(false);
		map.put("A", tmp);
		
		tmp = new ArrayList<>();
		tmp.add(false);
		tmp.add(true);
		map.put("T", tmp);
		
		tmp = new ArrayList<>();
		tmp.add(true);
		tmp.add(false);
		map.put("C", tmp);
		
		tmp = new ArrayList<>();
		tmp.add(true);
		tmp.add(true);
		map.put("G", tmp);
		
	}

}
