package boot;


import java.util.HashMap;


import view.*;
import controller.*;
import model.MyModel;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;


public class Run {

	public static void main(String[] args) throws IOException
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("Welcome to the java project of:");
		System.out.println("Valery Khirin, ID:317974467");
		System.out.println("Yarden Yerushalmi, ID:204326292");
		System.out.println("----------------------------------------------------------\n\n");
		
		PrintWriter printer = new PrintWriter(System.out);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Command> hashMap = new HashMap<String,Command>();
		MyModel mymod = new MyModel();
		
		hashMap.put("dir", new Dir(mymod));
		hashMap.put("generate3DMaze", new Generate3DMaze(mymod));
		hashMap.put("display", new Display(mymod));
		hashMap.put("displayCrossSection", new DisplayCrossSectionBy(mymod));
		hashMap.put("saveMaze", new SaveMaze(mymod));
		hashMap.put("loadMaze", new LoadMaze(mymod));
		hashMap.put("solve", new Solve(mymod));
		hashMap.put("displaySolution", new DisplaySolution(mymod));
		hashMap.put("exit", new Exit(mymod));
		
		MyView myview = new MyView(hashMap, reader, printer);
		MyController controller = new MyController(hashMap, mymod, myview);
		mymod.setControl(controller);
		myview.setMyController(controller);
		controller.getMyView().start();
		
	}
}


