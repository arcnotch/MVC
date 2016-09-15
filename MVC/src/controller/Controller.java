package controller;


public interface Controller {
	/**
	 * viewResults method presents the result by array of strings  
	 * @param  array is a strings array to print as result
	 */
	void viewResults(String[] array);
	/**
	 * viewResults method presents the result by string  
	 * @param  str is a string parameter to print as result
	 */
	void viewResults(String str);
	/**
	 * viewResults method presents the result by d2 array  
	 * @param  crossby is a 2d int array parameter to print as result
	 */
	void viewResults(int[][] crossby);
}
