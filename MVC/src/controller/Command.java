package controller;


public interface Command {
	/**
	 * executes users command of choice with suitable parameters that the user need to provide      
	 * @param str is the users command as an array of strings
	 */
	public void doCommand(String[] str);
}
