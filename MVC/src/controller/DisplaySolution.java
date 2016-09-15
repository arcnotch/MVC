package controller;


import model.MyModel;


public class DisplaySolution implements Command {
	private MyModel model;
	
	public DisplaySolution(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.displaySolution(str[1]);
	}

}
