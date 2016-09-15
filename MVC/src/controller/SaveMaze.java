package controller;


import model.MyModel;


import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class SaveMaze implements Command {
	private MyModel model;
	
	public SaveMaze(MyModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] str) {
		try {
			model.saveM3d(new FileOutputStream (str[2]), str[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
