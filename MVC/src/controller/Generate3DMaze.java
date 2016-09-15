package controller;


import model.MyModel;


public class Generate3DMaze implements Command {
	private MyModel model;
	
	public Generate3DMaze(MyModel model) {
		this.model = model;
	}
	
	@Override
	public void doCommand(String[] str) {
		model.generateM3d(str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), str[5]);
	}

}
