
/******************************************************************************
*  A Teaching GA					  Developed by Hal Stringer & Annie Wu, UCF
*  Version 2, January 18, 2004
*******************************************************************************/

import java.io.*;
import java.util.*;
import java.text.*;

public class Parameters {

	/*******************************************************************************
	 * INSTANCE VARIABLES *
	 *******************************************************************************/

	public static String expID;
	public static String problemType;

	public static String dataInputFileName;

	public static int numRuns;
	public static int generations;
	public static int popSize;

	public static int genCap;
	public static int fitCap;

	public static String minORmax;
	public static int selectType;
	public static int scaleType;

	public static int xoverType;
	public static double xoverRate;
	public static int mutationType;
	public static double mutationRate;

	public static long seed;
	public static int numGenes;
	public static int geneSize;

	/*******************************************************************************
	 * CONSTRUCTORS *
	 *******************************************************************************/

	public Parameters(String parmfilename) throws java.io.IOException {

		String readLine;
		BufferedReader parmInput = new BufferedReader(new FileReader(parmfilename));

		expID = parmInput.readLine().substring(30);// Experiment ID
		problemType = parmInput.readLine().substring(30);

		dataInputFileName = parmInput.readLine().substring(30);

		numRuns = Integer.parseInt(parmInput.readLine().substring(30).trim());
		generations = Integer.parseInt(parmInput.readLine().substring(30).trim());// per run
		popSize = Integer.parseInt(parmInput.readLine().substring(30).trim());

		selectType = Integer.parseInt(parmInput.readLine().substring(30).trim());
		// 1 = Proportional Selection
		// 2 = Tournament Selection
		// 3 = Random Selection
		// 4 = Rank Selection

		scaleType = Integer.parseInt(parmInput.readLine().substring(30).trim());// Fitness Scaling Type
		// 0 = Scale for Maximization (no change to raw fitness)
		// 1 = Scale for Minimization (reciprocal of raw fitness)
		// 2 = Rank for Maximization
		// 3 = Rank for Minimization

		xoverType = Integer.parseInt(parmInput.readLine().substring(30).trim());
		// 1 = Single Point Crossover
		// 2 = Two Point Crossover
		// 3 = Uniform Crossover

		xoverRate = Double.parseDouble(parmInput.readLine().substring(30).trim()); // from 0 to 1, Use "0" to turn off
																					// crossover

		mutationType = Integer.parseInt(parmInput.readLine().substring(30).trim());// 1 = Flip Bit

		mutationRate = Double.parseDouble(parmInput.readLine().substring(30).trim());// from 0 to 1, Use "0" to turn off
																						// mutation

		seed = Long.parseLong(parmInput.readLine().substring(30).trim());

		numGenes = Integer.parseInt(parmInput.readLine().substring(30).trim());// in each chromosome.

		geneSize = Integer.parseInt(parmInput.readLine().substring(30).trim());
		// is the number of bits in each gene. Number of Genes times Size
		// gives the number of bits in each chromosome.

		parmInput.close();

		if (scaleType == 0 || scaleType == 2)
			minORmax = "max";
		else
			minORmax = "min";

	}

	/*******************************************************************************
	 * MEMBER METHODS *
	 *******************************************************************************/

	/*******************************************************************************
	 * STATIC METHODS *
	 *******************************************************************************/

	public static void outputParameters(FileWriter output) throws java.io.IOException {

		output.write("Experiment ID                :  " + expID + "\n");
		output.write("Problem Type                 :  " + problemType + "\n");

		output.write("Data Input File Name         :  " + dataInputFileName + "\n");

		output.write("Number of Runs               :  " + numRuns + "\n");
		output.write("Generations per Run          :  " + generations + "\n");
		output.write("Population Size              :  " + popSize + "\n");

		output.write("Selection Method             :  " + selectType + "\n");
		output.write("Fitness Scaling Type         :  " + scaleType + "\n");
		output.write("Min or Max Fitness           :  " + minORmax + "\n");

		output.write("Crossover Type               :  " + xoverType + "\n");
		output.write("Crossover Rate               :  " + xoverRate + "\n");
		output.write("Mutation Type                :  " + mutationType + "\n");
		output.write("Mutation Rate                :  " + mutationRate + "\n");

		output.write("Random Number Seed           :  " + seed + "\n");
		output.write("Number of Genes/Points       :  " + numGenes + "\n");
		output.write("Size of Genes                :  " + geneSize + "\n");

		output.write("\n\n");

	}
} // End of Parameters.java **************************************************