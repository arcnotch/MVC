package controller;

import model.MyModel;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


public class LoadMaze implements Command {
	private MyModel model;
	
	public LoadMaze(MyModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] str) {
		try {
			model.loadM3d(new FileInputStream(str[1]), str[2]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
