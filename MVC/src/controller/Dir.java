package controller;


import model.MyModel;
import java.io.File;



public class Dir implements Command {
	private MyModel model;
	
	
	public Dir(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.dir(new File(str[1]));
	}

}
