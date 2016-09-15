package controller;


import model.MyModel;


public class DisplayCrossSectionBy implements Command {
	private MyModel model;
	
	public DisplayCrossSectionBy(MyModel model) {
		this.model = model;
	}

	@Override
	public void doCommand(String[] str) {
		model.getCrossBY(str[3], Integer.parseInt(str[2]), str[1].charAt(0));
	}

}
