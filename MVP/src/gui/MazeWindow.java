package gui;

import io.MyDecompressorInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import presenter.Properties;
import view.View;
import algorithms.mazeGenarators.Maze3d;
import algorithms.mazeGenarators.Position;

public class MazeWindow extends BasicWindow implements View {

//	private MazeDisplay mazeDisplay;
//	private Properties prop;
//	public Text text = null;
//	
//	@Override
//	protected void initWidgets() {
//		GridLayout gridLayout = new GridLayout(2, false);
//		shell.setLayout(gridLayout);		
//		
//		Composite btnGroup = new Composite(shell, SWT.BORDER);
//		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
//		btnGroup.setLayout(rowLayout);
//		
//		Button btnGenerateMaze = new Button(btnGroup, SWT.PUSH);
//		btnGenerateMaze.setText("Generate maze");	
//		
//		btnGenerateMaze.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent arg0) {
//				showGenerateMazeOptions();
//				
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				
//			}
//		});
//		
//		Button btnShowMaze = new Button(btnGroup, SWT.PUSH);
//		btnShowMaze.setText("Show maze");	
//		
//		btnShowMaze.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent arg0) {
//				showMaze();
//				
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				
//			}
//		});
//		
//		Button btnSolveMaze = new Button(btnGroup, SWT.PUSH);
//		btnSolveMaze.setText("Solve maze");
//		
//		mazeDisplay = new MazeDisplay(shell, SWT.DOUBLE_BUFFERED, this, null);
//		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//
//	}
//
//	protected void showGenerateMazeOptions() {
//		Shell shell = new Shell();
//		shell.setText("Generate Maze");
//		shell.setSize(300, 200);
//		
//		GridLayout layout = new GridLayout(2, false);
//		shell.setLayout(layout);
//		
//		Label lblLevels = new Label(shell, SWT.NONE);
//		lblLevels.setText("Levels: ");
//		Text txtLevels = new Text(shell, SWT.BORDER);
//		
//		Label lblRows = new Label(shell, SWT.NONE);
//		lblRows.setText("Rows: ");
//		Text txtRows = new Text(shell, SWT.BORDER);
//		
//		Label lblCols = new Label(shell, SWT.NONE);
//		lblCols.setText("Cols: ");
//		Text txtCols = new Text(shell, SWT.BORDER);
//		
//		Button btnGenerate = new Button(shell, SWT.PUSH);
//		btnGenerate.setText("Generate");
//		btnGenerate.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent arg0) {
//				setChanged();
//				notifyObservers("get_algo");
//				setChanged();
//				notifyObservers("generate_3d_maze aaa "+ txtLevels.getText() +" " + txtRows.getText() + " " + txtCols.getText()+" Growing");
//				shell.close();
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				
//			}
//		});
//		
////		mazeDisplay = new MazeDisplay(shell, SWT.FILL);
//		shell.open();	
//	}
//
//	public void notifyMazeIsReady(String name) {
//		display.syncExec(new Runnable() {
//			
//			@Override
//			public void run() {
//				MessageBox msg = new MessageBox(shell);
//				msg.setMessage("Maze " + name + " is ready");
//				msg.open();	
//				
//				setChanged();
//				notifyObservers("display_maze " + name);
//			}
//		});			
//	}
//
//	public void showMaze(){
//		notifyMazeIsReady("aaa");
//	}
//	
//	public void displayMaze(Maze3d maze) {
//		int[][] mazeData = maze.getCrossSectionByZ(maze.getStartPosition().getLevel());
//		mazeDisplay.setCrossSection(mazeData, null, null);
//	}
//
//	@Override
//	public void start() {
//		run();		
//	}
//
//	@Override
//	public void display(String msg) {
//		// TODO Auto-generated method stub
//		
//	}
//
	
	
	
	
	private MazeDisplay mazeDisplay;
	private Properties properties;
	public Text text = null;
	final private Image imgBackground = new Image(null, "resources/images/bg.jpg");
	
	public MazeWindow(Properties p) {
		this.properties = p;
	}
	
	@Override
	public void setProperties(Properties prop) {
		properties = prop;
	}
	
	@Override
	@SuppressWarnings("unused")
	protected void initWidgets() {
	
		
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);				
		shell.setText("Maze3d Game");
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(imgBackground);
		shell.setSize(800, 600);
		
		//Initialize the menu bar
//		MazeMenu menu = new MazeMenu(this);
//		
//		// Open in center of screen
//		Rectangle bounds = display.getPrimaryMonitor().getBounds();
//		Rectangle rect = shell.getBounds();
//		int x = bounds.x + (bounds.width - rect.width) / 2;
//		int y = bounds.y + (bounds.height - rect.height) / 2;
//		shell.setLocation(x, y);
//
//		// handle with the RED X
//		shell.addListener(SWT.Close, new Listener() {
//			@Override
//			public void handleEvent(Event arg0) {
//				exit();
//			}
//		});
		
		Composite btnGroup = new Composite(shell, SWT.BORDER);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		btnGroup.setLayout(rowLayout);
		
		//comments = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		//comments.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Button btnGenerateMaze = new Button(btnGroup, SWT.PUSH);

		btnGenerateMaze.setText("Generate maze");	
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				showGenerateMazeOptions();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		Button btnSolveMaze = new Button(btnGroup, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");
		
		
		Button btnDisplayMaze = new Button(btnGroup, SWT.PUSH);
		btnDisplayMaze.setText("Display maze");	
		
		btnDisplayMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				showMaze("tal123");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		//Set layout to maze display
		mazeDisplay = new MazeDisplay(shell, SWT.NONE,this,null);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		mazeDisplay.setFocus();
	}

	protected void showGenerateMazeOptions() {
		
		
		Shell generateWindowShell = new Shell(display, SWT.TITLE | SWT.CLOSE);
		generateWindowShell.setText("Generate maze window");
		generateWindowShell.setLayout(new GridLayout(2, false));
		generateWindowShell.setSize(215, 215);
		generateWindowShell.setBackgroundImage(new Image(null, "resources/images/backgroundSmall.png"));
		generateWindowShell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		// Open in center of screen
		Rectangle bounds = display.getPrimaryMonitor().getBounds();
		Rectangle rect = generateWindowShell.getBounds();
		int x = bounds.x + (bounds.width - rect.width) / 2;
		int y = bounds.y + (bounds.height - rect.height) / 2;
		generateWindowShell.setLocation(x, y);
		
		Label lblHead = new Label(generateWindowShell, SWT.BOLD);
		FontData fontData = lblHead.getFont().getFontData()[0];
		Font font = new Font(display, new FontData(fontData.getName(), fontData.getHeight()+1, SWT.BOLD));
		lblHead.setFont(font);
		lblHead.setText("Enter maze dimensions");
		lblHead.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));
		
		Label lblFloors = new Label(generateWindowShell, SWT.NONE);
		lblFloors.setText("Floors: ");
		Text txtFloors = new Text(generateWindowShell, SWT.BORDER);
		txtFloors.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtFloors.setText("5");
		
		Label lblRows = new Label(generateWindowShell, SWT.NONE);
		lblRows.setText("Rows: ");
		Text txtRows = new Text(generateWindowShell, SWT.BORDER);
		txtRows.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtRows.setText("5");
		
		Label lblCols = new Label(generateWindowShell, SWT.NONE);
		lblCols.setText("Columns: ");
		Text txtCols = new Text(generateWindowShell, SWT.BORDER);
		txtCols.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtCols.setText("5");
		
		Button btnStartGame = new Button(generateWindowShell, SWT.PUSH);
		btnStartGame.setText("Play!");
		btnStartGame.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		btnStartGame.addSelectionListener(new SelectionListener() {

			/**
			 * take all the floors, cols, rows and make them from Text Box 
			 * 
			 * @param SelectionEvent
			 */
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("generate_3d_maze" + " tal123 " + txtFloors.getText() + " " + txtRows.getText() + " " + txtCols.getText() + " a");
				generateWindowShell.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) { }
			
		});

		generateWindowShell.open();

		mazeDisplay.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String direction = null;
				switch (e.keyCode) {
				case SWT.ARROW_RIGHT:
					direction = "Right";
					break;
				case SWT.ARROW_LEFT:
					direction = "Left";
					break;
				case SWT.ARROW_UP:
					direction = "Forward";
					break;
				case SWT.ARROW_DOWN:
					direction = "Backward";
					break;
				case SWT.PAGE_DOWN:
					direction = "Down";
					break;
				case SWT.PAGE_UP:
					direction = "Up";
					break;
				default:
					break;
				}
				if (direction != null) {
					mazeDisplay.moveChracter(direction);
					mazeDisplay.redrawMe();
				}
			}
		});
	}

	@Override
	public void notifyMazeIsReady(String name) {

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				setChanged();
				notifyObservers("display_maze " + name);
			}
		});
	
	
	}

	public void showMessageBox(String str) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageBox msg = new MessageBox(shell, SWT.ICON_INFORMATION);
				msg.setMessage(str);
				msg.open();
			}
		});
	}
	

	@Override
	public void start() {
		run();		
	}

	public void showDirPath(String dirArray) {
		// TODO Auto-generated method stub
		
	}

	public void showError(String message) {
		showMessageBox(message);
		
	}


	public void showDisplayCrossSectionBy(String crossMazeBySection) {
		// TODO Auto-generated method stub
		
	}

	public void showSaveMaze(String str) {
		// TODO Auto-generated method stub
		
	}

	public void showLoadMaze(String str) {
		// TODO Auto-generated method stub
		
	}

	public void showSolve(String message) {
		// TODO Auto-generated method stub
		
	}

	public void showDisplaySolution(String sol) {
		// TODO Auto-generated method stub
		
	}

	public void printMenu(String menu) {
		// TODO Auto-generated method stub
		
	}

	public void showMaze(String mazeByteArrString) {
		
		setChanged();
		notifyObservers("save_maze " + "tal123 tal123");
		
		MyDecompressorInputStream in = null;
		try {
			in = new MyDecompressorInputStream( new FileInputStream("tal123") );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int size = 0;
		
		try {
			size = in.getSize();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		byte b[] = new byte[size];
		
		try {
			in.read(b);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Maze3d maze3d=new Maze3d(b);
//		byte[] byteArr = mazeByteArrString.getBytes(StandardCharsets.UTF_8);
		// Convert maze from byeArray
//		Maze3d maze3d = new Maze3d(byteArr);
		mazeDisplay.setMaze(maze3d);
		mazeDisplay.setCharacterPosition(maze3d.getStartPosition());
		int[][] crossSection = maze3d.getCrossSectionByZ(maze3d.getStartPosition().getLevel());
		mazeDisplay.setCrossSection(crossSection, null, null);
		mazeDisplay.setGoalPosition(maze3d.getGoalPosition());
		mazeDisplay.setMazeName("tal123");

	}

	@Override
	public void display(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
