package model;


import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;


public interface Model
{
	/** 
	 * goes to path "dir" and opens all the files there
	 * @param dir is the path to the files 
	 */
	public void dir(File dir);
	/**
	 * returns 2D maze cut at the index and by 
	 * @param name is the name of the 3D maze
	 * @param index is the number of level/row/column of the 3D maze
	 * @param by is the parameter(z/y/x) we want to cut by
	 */
	public void getCrossBY(String name, int index, char by);
	/**
	 * generates 3D maze by the sizes
	 * @param name is the name of the 3D maze we want to generate
	 * @param lev is the size of the levels
	 * @param row is the size of the rows
	 * @param col is the size of the columns
	 * @param alg is the preferable algorithms for building the maze(simple/growing tree)
	 */
	public void generateM3d(String name, int lev, int row, int col, String alg);
	/**
	 * displays the 3D maze 
	 * @param name is the name of the 3D maze we want to display
	 */
	public void display(String name);
	/**
	 * saves the 3D maze to file
	 * @param name is the name of 3D maze we want to save
	 * @param fout is the file we want to save in
	 */
	public void saveM3d(FileOutputStream fout, String name);
	/**
	 * loads the 3D maze from file
	 * @param fin is the file we want to load from
	 * @param name is the name of the 3d maze we want to load
	 */
	public void loadM3d(FileInputStream fin, String name);
	/**
	 * solves the maze by the algorithm that user chose
	 * @param name is the name of the 3D maze we want to solve
	 * @param alg is the algorithm that the 3D maze has to be solved by
	 */
	public void solveM3d(String name, String alg);
	/**
	 * displays the solution of the 3D maze
	 * @param name is the name of the 3D maze that its solution we want do display
	 */
	public void displaySolution(String name);
	/**
	 * exits from program
	 */
	public void exit();
}
