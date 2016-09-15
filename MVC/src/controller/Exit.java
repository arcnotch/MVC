package controller;


import model.MyModel;


public class Exit implements Command {
	private MyModel model;
	
	public Exit(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.exit();
	}

}
