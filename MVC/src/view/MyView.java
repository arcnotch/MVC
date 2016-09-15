package view;


import java.util.HashMap;

import controller.Controller;
import controller.Command;


import java.io.PrintWriter;
import java.io.BufferedReader;


public class MyView implements View {

	Controller myController;
	CLI myCli;
	
	
	public MyView( HashMap<String,Command> hashmap, BufferedReader in, PrintWriter out) {
		super();
		this.myCli = new CLI(hashmap, in, out);
	}
	
	public Controller getMyController() {
		return myController;
	}

	public void setMyController(Controller controller) {
		this.myController = controller;
	}

	@Override
	public void start() {
		myCli.start();
	}

	@Override
	public void printResults(String str) {
		System.out.println("- "+str);
	}
	
	@Override
	public void printResults(int[][] crossby){
		for( int[] rows : crossby){
			for( int colms : rows)
				System.out.print(colms+" ");
			
			System.out.println();
		}
	}
}
