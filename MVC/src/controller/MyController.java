package controller;

import model.MyModel;
import view.MyView;


import java.util.HashMap;


public class MyController implements Controller {
	private HashMap<String,Command> myHashMap;
	private MyModel myModel;
	private MyView myView;
		
	public HashMap<String, Command> getHashMap() {
		return myHashMap;
	}
	
	public MyModel getMyModel() {
		return myModel;
	}
	
	public MyView getMyView() {
		return myView;
	}
	
	public MyController(HashMap<String, Command> hashmap, MyModel mymodel, MyView myview) {
		super();
		this.myHashMap = hashmap;
		this.myModel = mymodel;
		this.myView = myview;		
	}
	
	@Override
	public void viewResults(String[] array) {
		for(String s : array)
			myView.printResults(s);
	}
	@Override
	public void viewResults(String str) {
		myView.printResults(str);
	}

	@Override
	public void viewResults(int[][] crossby) {
		myView.printResults(crossby);
	}
	
	
	
}