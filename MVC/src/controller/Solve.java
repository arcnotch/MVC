package controller;


import model.MyModel;


public class Solve implements Command {
	private MyModel model;
	
	public Solve(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.solveM3d(str[1], str[2]);
	}

}
