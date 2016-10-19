package gui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import algorithms.mazeGenarators.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenarators.Maze3d;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;


public class MazeDisplay extends Canvas {
	
	@SuppressWarnings("unused")
	private String mazeName;
	private int whichFloorAmI;
	private int[][] crossSection = { {0}, {0} };
	private Character character;
	final private Image imgGoal = new Image(null,"resources/images/apple.png") ;
	final private Image imgWinner = new Image(null,"resources/images/winner.gif");
//	final private Image imgUp = new Image(null, "resources/images/up.gif");
//	final private Image imgDown = new Image(null, "resources/images/down.gif");
	final private Image imgWall = new Image(null, "resources/images/wall.png");
//	final private Image imgBackwardInMaze = new Image (null, "resources/images/backwardInMaze.png");
	private boolean drawMeAHint;
	private Position hintPosition;
	private boolean winner;
	private Position goalPosition;
	private List<Point> downHint;
	private List<Point> upHint;
	private Maze3d maze;
	private MazeWindow mazeWindow;
	

	public MazeDisplay(Composite parent, int style,MazeWindow mazeWindow,Maze3d maze) {
		super(parent, style);
		this.maze = maze;
		this.mazeWindow = mazeWindow;
		character = new Character();
		if(character.getPos() != null)
			whichFloorAmI = character.getPos().getLevel();
		character.setPos(new Position(-1, -1, -1));
		
		drawMeAHint = false;
		winner = false;
		goalPosition = new Position(-1, -1, -1);
		upHint = new ArrayList<Point>();
		downHint = new ArrayList<Point>();

		// draw the maze
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				int z, y;
				int canvasWidth = getSize().x;
				int canvasHeight = getSize().y;
				int cellHeight = canvasHeight / crossSection[0].length;
				int cellWidth = canvasWidth / crossSection.length;
				

				e.gc.setForeground(new Color(null, 1, 255, 0));
				e.gc.setBackground(new Color(null, 0, 0, 0));
				whichFloorAmI = character.getPos().getLevel();
				
				for (int i = 0; i < crossSection.length; i++) {
					for (int j = 0; j < crossSection[i].length; j++) {
						y = i * cellHeight;
						z = j * cellWidth;

							// e.gc.fillRectangle(z, y, cellWidth,cellHeight);
							
							if(crossSection[i][j] == 0){ //Draw backward and forward signs
//								backwardOrForward = new Position(character.getPos().getLevel(),i, j);
//								if (possibleMoveFromPosition(backwardOrForward, "Backward")){
//									e.gc.drawImage(imgBackwardInMaze, 0, 0,imgBackwardInMaze.getBounds().width,imgBackwardInMaze.getBounds().height, z, y,cellWidth, cellHeight);
//								}
							}else
								e.gc.drawImage(imgWall, 0, 0,imgWall.getBounds().width,imgWall.getBounds().height, z, y,cellWidth, cellHeight);
						}
					}
				
				
				if(maze != null && mazeWindow.text != null){
					mazeWindow.text.append("Character position: " +character.getPos().toString()+"\n");
					mazeWindow.text.append("Current floor: "+Integer.toString(character.getPos().getLevel())+"\n");
					mazeWindow.text.append("floor: "+Integer.toString(character.getPos().getLevel())+"\n");
					mazeWindow.text.append("Goal Position floor: "+ Integer.toString(maze.getGoalPosition().getLevel())+"\n");
					mazeWindow.text.append("Start Position floor: "+ Integer.toString(maze.getGoalPosition().getLevel())+"\n");
			}
				
				
				
				if (drawMeAHint) {
					drawMeAHint = false;
					e.gc.drawImage(imgGoal, 0, 0, imgGoal.getBounds().width, imgGoal.getBounds().height, (cellWidth * hintPosition.getLevel()) + (cellWidth / 4), (cellHeight * hintPosition.getRow()) + (cellHeight / 4), cellWidth/2, cellHeight/2);
				}
				
				if(character.getPos().getLevel() >= 0 &&
						character.getPos().getLevel() == goalPosition.getLevel() && 
						character.getPos().getRow() == goalPosition.getRow() && 
						character.getPos().getColm() == goalPosition.getColm() ){
					winner = true;
				}
					
				
				if (!winner) {
					character.draw(cellWidth,cellHeight, e.gc);
					if(goalPosition.getLevel() == whichFloorAmI)
						e.gc.drawImage(imgGoal, 0, 0, imgGoal.getBounds().width, imgGoal.getBounds().height, cellWidth * goalPosition.getColm(), cellHeight * goalPosition.getRow(), cellWidth, cellHeight);
				} else
					e.gc.drawImage(imgWinner, 0, 0, imgWinner.getBounds().width, imgWinner.getBounds().height, cellWidth * goalPosition.getColm(), cellHeight * goalPosition.getRow(), cellWidth, cellHeight);
				forceFocus();
			}
			
			@SuppressWarnings("unused")
			private void paintUpDownHints(PaintEvent e, int i, int j, int cellWidth, int cellHeight) {
//				Point upDownHint = new Point(i, j);
//				if (upHint.contains(upDownHint) && downHint.contains(upDownHint))
//					e.gc.drawImage(imgBackwardInMaze, 0, 0, imgBackwardInMaze.getBounds().width, imgBackwardInMaze.getBounds().height, cellWidth * j, cellHeight * i, cellWidth, cellHeight);
//				else {
//					if (upHint.contains(upDownHint))
//						e.gc.drawImage(imgUp, 0, 0, imgUp.getBounds().width, imgUp.getBounds().height, cellWidth * j, cellHeight * i, cellWidth, cellHeight);
//					else if (downHint.contains(upDownHint))
//							e.gc.drawImage(imgDown, 0, 0, imgDown.getBounds().width, imgDown.getBounds().height, cellWidth * j, cellHeight * i, cellWidth, cellHeight);
//				}
			}
		});
	}
		
	public Position getMovePosition(Position pos, String direction){
		Position nextPos = new Position(pos);
		
		switch(direction){
			case "Up":
				if(maze.getValue(pos.getLevel()+1, pos.getRow(), pos.getColm()) == 0){
					nextPos.setLevel(pos.getLevel()+1);					
				}
				break;
			case "Down":
				if(maze.getValue(pos.getLevel()-1, pos.getRow(), pos.getColm()) == 0){
					nextPos.setLevel(pos.getLevel()-1);
				}
				break;
			case "Forward":
				if(maze.getValue(pos.getLevel(), pos.getRow()-1, pos.getColm()) == 0){
					nextPos.setRow(pos.getRow()-1);
				}
				break;
			case "Backward":
				if(maze.getValue(pos.getLevel(), pos.getRow()+1, pos.getColm()) == 0){
					nextPos.setRow(pos.getRow()+1);
				}
				break;
			case "Right":
				if(maze.getValue(pos.getLevel(), pos.getRow(), pos.getColm()+1) == 0){
					nextPos.setColm(pos.getColm()+1);
				}
				break;
			case "Left":
				if(maze.getValue(pos.getLevel(), pos.getRow(), pos.getColm()-1) == 0){
					nextPos.setColm(pos.getColm()-1);
				}
				break;
			default:
				nextPos = null;
				break;
		}
		
		return nextPos;
	}
	
	public boolean possibleMoveFromPosition(Position pos,String direction){
		
		if (maze!= null && getMovePosition(pos, direction) != null) {
			return true;
		}else
			return false;		
		
	}
	
	public boolean moveChracter(String direction) {
		
		if (possibleMoveFromPosition(character.getPos(), direction)) {
			Position nextPos = getMovePosition(character.getPos(), direction);
			int[][] crossSection = maze.getCrossSectionByZ(nextPos.getLevel());
			setCrossSection(crossSection, null, null);
			setCharacterPosition(nextPos);
			return true;			
		}else
			return false;
	}	
	
	/**
	 * setWinner
	 * @param winner, boolean
	 */

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	/**
	 *This method tell us where are we in the maze
	 * @param whichFloorAmI, int
	 */
	public void setWhichFloorAmI(int whichFloorAmI) {
		this.whichFloorAmI = whichFloorAmI;
	}

	/**
	 * paint the maze in crossSection [][]
	 * @param crossSection, crossSection
	 * @param upHint, List<Point>
	 * @param downHint, List<Point>
	 */
	public void setCrossSection(int[][] crossSection, List<Point> upHint, List<Point> downHint) {
		this.crossSection = crossSection;
		this.upHint = upHint;
		this.downHint = downHint;
		redrawMe();
	}

	/**
	 * set the character position then draw the maze
	 * @param pos, the position 
	 */
	public void setCharacterPosition(Position pos) {
		this.character.setPos(pos);
		redrawMe();
	}

	/**
	 * move the character
	 * @param pos, the position
	 */
	public void moveTheCharacter(Position pos) {
		this.character.setPos(pos);
		redrawMe();
	}
	/**
	 * setMazeName 
	 * @param String mazeName
	 */
	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}
	
	/**
	 * set goal position
	 * @param Position goalPosition
	 */
	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}
	
	/**
	 *This method draw a hint to the player
	 * @param PositionhintPos
	 */
	public void drawHint(Position hintPos) {
		this.drawMeAHint = true;
		this.hintPosition = hintPos;
		redrawMe();
	}
	
	/**
	 *This method readraw the canvas in runnable sync
	 */
	public void redrawMe() {
		getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				setEnabled(true);
				redraw();
			}
		});
	}

	public void showMessageBox(String str) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageBox msg = new MessageBox(new Shell(),
						SWT.ICON_INFORMATION);
				msg.setMessage(str);
				msg.open();
			}
		});
	}

	public void setMaze(Maze3d maze) {
		this.maze = maze;
	}
	
	

}