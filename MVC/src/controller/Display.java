package controller;


import model.MyModel;


public class Display implements Command {
	private MyModel model;
	
	public Display(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.display(str[1]);
	}

}
