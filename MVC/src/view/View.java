package view;

public interface View {
	/**
	 * start method presents the interface menu to the user      
	 */
	void start();
	
	/**
	 * printResults method presents the result by string  
	 * @param  str is a string parameter to print as result
	 */
	void printResults(String str);
	
	/**
	 * printResults method presents the result by d2 array  
	 * @param  crossby is a 2d int array parameter to print as result 
	 */
	void printResults(int[][] crossby);
}
