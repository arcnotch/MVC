package boot;

import gui.MazeWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.MyModel;
import presenter.LoaderProperties;
import presenter.Presenter;
import presenter.Properties;
import view.AbstractView;
import view.MyView;
import view.View;

public class Run {

	public static void main(String[] args) {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Properties prop = LoaderProperties.getInstance().getProperties();
		MyModel model = new MyModel();

		AbstractView view = null;
		
		if(prop.getIsGUI() == 1){
			view = new MazeWindow(prop);
		}else{
			view = new MyView(in, out);
		}
		
		
		Presenter presenter = new Presenter(model, view);
		
		
		model.addObserver(presenter);
		view.addObserver(presenter);
				
		view.start();
	}
}
