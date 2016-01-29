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

	public PrepareReadFile() {	
		setPath();	
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

	
	public String getPath() {
		return path;
	}

}
