
import java.io.*;
import java.util.*;
import java.text.*;

public class IteratedPrisonersDilemma extends FitnessFunction {

    /*******************************************************************************
     * INSTANCE VARIABLES *
     *******************************************************************************/

    /*******************************************************************************
     * STATIC VARIABLES *
     *******************************************************************************/

    /*******************************************************************************
     * CONSTRUCTORS *
     *******************************************************************************/

    public IteratedPrisonersDilemma() {
        name = "IteratedPrisonersDilemma Problem";
    }

    /*******************************************************************************
     * MEMBER METHODS *
     *******************************************************************************/

    // COMPUTE A CHROMOSOME'S RAW FITNESS *************************************

    public void doRawFitness(Chromo X) {
        // TODO
        System.out.println("doRawFitness not yet implemented for IteratedPrisonersDilemma");

        // X.rawFitness = 0;
        // for (int z = 0; z < Parameters.numGenes * Parameters.geneSize; z++) {
        // if (X.chromo.charAt(z) == '1')
        // X.rawFitness += 1;
        // }

    }

    // PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE
    // *********************************

    public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException {

        // TODO
        System.out.println("doPrintGenes not yet implemented for IteratedPrisonersDilemma");

        // for (int i = 0; i < Parameters.numGenes; i++) {
        // Hwrite.right(X.getGeneAlpha(i), 11, output);
        // }
        // output.write(" RawFitness");
        // output.write("\n ");
        // for (int i = 0; i < Parameters.numGenes; i++) {
        // Hwrite.right(X.getPosIntGeneValue(i), 11, output);
        // }
        // Hwrite.right((int) X.rawFitness, 13, output);
        // output.write("\n\n");

        return;
    }

    /*******************************************************************************
     * STATIC METHODS *
     *******************************************************************************/

} // End of OneMax.java ******************************************************
