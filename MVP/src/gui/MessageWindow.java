package gui;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

import presenter.Properties;
import algorithms.mazeGenarators.Maze3d;

public class MessageWindow extends BasicWindow
{

	public MessageWindow(String title, int width, int height) {
//		super(title, width, height);
	}

	@Override
	protected void initWidgets() {
		shell.setLayout(new GridLayout(1,true));
	}
			
	public void display(String x) {
		Text text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		text.setText(x);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub
		
	}
}

