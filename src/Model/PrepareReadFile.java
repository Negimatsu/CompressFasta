package Model;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PrepareReadFile extends Component {
	private String path;
	private String typeText;
	private String tmpFile;

	/**
	 * 
	 * @param type 1 is pre folder, 2 is post folder and 3 is Text File. 
	 */
	public PrepareReadFile() {
	
		setPath();
		File tmpFile = new File(path);
	}


	public void setPath(String path){

		this.path = path;
	}

	public void setPath(){
		File selectedFfile = null;
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setDialogTitle("Select " + typeText);
		//fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int result = fileChooser.showSaveDialog(this);	
		if (result == JFileChooser.APPROVE_OPTION) {

			selectedFfile = fileChooser.getSelectedFile();

			System.out.println("Selected file: " + selectedFfile.getAbsolutePath());
		}

		this.path = selectedFfile.getAbsolutePath();
	}	
		
		
	public BufferedReader readFile(){	
		
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(tmpFile);
			
		} catch (FileNotFoundException e) {
			System.err.println(this.path + "File not found");
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
		
		return new BufferedReader(fileReader);
	}
	
	

	
	public String getPath() {
		return path;
	}

}
