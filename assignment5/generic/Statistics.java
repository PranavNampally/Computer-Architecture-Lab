package generic;

import java.io.PrintWriter;

public class Statistics {
	
	// TODO add your statistics here
	static int numberOfInstructions;
	static int numberOfCycles;
	static int numberOfStalls=0;
	static int numberOfWrongBranches=0;
	

	public static void printStatistics(String statFile)
	{
		try
		{
			PrintWriter writer = new PrintWriter(statFile);
			
			writer.println("Number of instructions executed = " + numberOfInstructions);
			writer.println("Number of cycles taken = " + numberOfCycles);
			writer.println("Number of Stalls = " + numberOfStalls);
			writer.println("Number of Wrong Branches taken = " + numberOfWrongBranches);
			
			// TODO add code here to print statistics in the output file
			
			writer.close();
		}
		catch(Exception e)
		{
			Misc.printErrorAndExit(e.getMessage());
		}
	}
	
	// TODO write functions to update statistics
	public static void setNumberOfInstructions(int numberOfInstructions) {
		Statistics.numberOfInstructions = numberOfInstructions;
	}

	public static void setNumberOfCycles(int numberOfCycles) {
		Statistics.numberOfCycles = numberOfCycles;
	}
	public static void setNumberOfStalls(int numberOfStalls) {
		Statistics.numberOfStalls= numberOfStalls;
	}
	public static void setNumberOfWrongBranches(int numberOfWrongBranches) {
		Statistics.numberOfWrongBranches= numberOfWrongBranches;
	}
	public static int getNumberOfCycles(){
		return numberOfCycles;
	}
	public static int getNumberOfInstructions(){
		return numberOfInstructions;
	}
	public static int getNumberOfStalls(){
		return numberOfStalls;
	}
	public static int getNumberOfWrongBranches(){
		return numberOfWrongBranches;
	}
}
