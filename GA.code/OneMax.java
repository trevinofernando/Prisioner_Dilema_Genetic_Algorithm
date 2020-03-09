/******************************************************************************
*  A Teaching GA					  Developed by Hal Stringer & Annie Wu, UCF
*  Version 2, January 18, 2004
*******************************************************************************/

import java.io.*;
import java.util.*;
import java.text.*;

public class OneMax extends FitnessFunction{

/*******************************************************************************
*                            INSTANCE VARIABLES                                *
*******************************************************************************/


/*******************************************************************************
*                            STATIC VARIABLES                                  *
*******************************************************************************/


/*******************************************************************************
*                              CONSTRUCTORS                                    *
*******************************************************************************/

	public OneMax(){
		name = "OneMax Problem";
	}

/*******************************************************************************
*                                MEMBER METHODS                                *
*******************************************************************************/

//  COMPUTE A CHROMOSOME'S RAW FITNESS *************************************

	public void doRawFitness(Chromo X){

		X.rawFitness = 0;
		for (int z=0; z<Parameters.numGenes * Parameters.geneSize; z++){
			if (X.chromo.charAt(z) == '1') X.rawFitness += 1;
		}
	}

//  PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE *********************************

	public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException{

		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getGeneAlpha(i),11,output);
		}
		output.write("   RawFitness");
		output.write("\n        ");
		for (int i=0; i<Parameters.numGenes; i++){
			Hwrite.right(X.getPosIntGeneValue(i),11,output);
		}
		Hwrite.right((int) X.rawFitness,13,output);
		output.write("\n\n");
		return;
	}

/*******************************************************************************
*                             STATIC METHODS                                   *
*******************************************************************************/

}   // End of OneMax.java ******************************************************

