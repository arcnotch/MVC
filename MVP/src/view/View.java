package view;

import algorithms.mazeGenarators.Maze3d;
import presenter.Properties;

public interface View {
	void display(String msg);	
	void start();	
	void displayMaze(Maze3d maze);
	void setProperties(Properties properties);
	void notifyMazeIsReady(String name);
}
