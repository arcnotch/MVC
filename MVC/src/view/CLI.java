package view;


import java.util.Scanner;
import java.util.HashMap;


import controller.Command;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;


public class CLI{
	private HashMap<String,Command> myHashMap;
	
	BufferedReader myIn;
	PrintWriter myOut;

	public CLI(HashMap<String,Command> hashmap, BufferedReader in, PrintWriter out) {
		super();
		this.myHashMap = new HashMap<String,Command>();
		this.myIn = in;
		this.myOut = out;
		
		this.myHashMap.putAll(hashmap);
	}
	
	/**
	 * presents the interface menu to the user      
	 */
	public void start(){
		new Thread(new Runnable(){
			
			@Override
			public void run()
			{
				int index = 0;
				
				Scanner myScanner;
				String[] userschoice = new String[100];
				
				do{
					System.out.println("Please enter your command (separate parameters with spaces):");
					System.out.println("1) Dir: dir <path>");
					System.out.println("2) Generate 3D Maze: generate3DMaze <name> <levels> <rows> <columns> <Simple/Growing tree>");
					System.out.println("3) Display: display <name>");
					System.out.println("4) Display Cross Section By: displayCrossSection <cross (X/Y/Z)> <index> <name>");
					System.out.println("5) Save Maze: saveMaze <name> <file name>");
					System.out.println("6) Load Maze: loadMaze <file name> <name> ");
					System.out.println("7) Solve: solve <name> <BFS/DFS>");
					System.out.println("8) DisplaySolution: display_solution <name>");
					System.out.println("9) Exit: exit");
					
					/*
					dir c:\
					generate3DMaze testMVC 10 10 10 Growing
					generate3DMaze testMVC2 10 10 10 Simple
					display testMVC
					displayCrossSection x 6 testMVC
					saveMaze testMVC C:\Users\Yarden\Desktop\MVC\testMVC 
					loadMaze C:\Users\Yarden\Desktop\MVC\testMVC testMVC
					solve testMVC BFS
					solve testMVC DFS
					displaySolution testMVC
					displaySolution testMVC2
					 */
					
					try{
						myScanner = new Scanner(myIn.readLine());
						myScanner.useDelimiter(" ");
						
						while(myScanner.hasNext())
						{
							userschoice[index] = myScanner.next();
							index++;
						}
						
						if(myHashMap.containsKey(userschoice[0]))
					    {
							myHashMap.get(userschoice[0]).doCommand(userschoice);
					    }
					}catch(IOException e)
					{
						myOut.println("Invalid Command");
					}
					
					index=0;
					
				}while(!userschoice[0].equals("exit"));
			 
			}
		}).start();
	}
}
