
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
    public static String player2[] = { "StrategyByGA", "StrategyTitForTat", "StrategyTitForTwoTats",
            "StrategyAlwaysCooperate", "StrategyAlwaysDefect", "StrategyRandom", "StrategyGrudger" };

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

        X.rawFitness = 0;

        for (int s = 0; s < player2.length; s++) {
            String[] arguments = { Double.toString(X.chromo.get(0)), Double.toString(X.chromo.get(1)),
                    Integer.toString(s), "-L", Integer.toString(Parameters.maxSteps) };

            X.rawFitness += RunIPD.main(arguments);
        }

    }

    // PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE
    // *********************************

    public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException {

        // TODO
        // System.out.println("doPrintGenes not yet implemented for
        // IteratedPrisonersDilemma");

        for (int i = 0; i < Parameters.numGenes; i++) {
            Hwrite.right(X.getGeneAlpha(i), 11, output);
        }
        output.write(" RawFitness");
        output.write("\n ");
        for (int i = 0; i < Parameters.numGenes; i++) {
            Hwrite.right(X.getPosIntGeneValue(i), 11, output);
        }
        Hwrite.right((int) X.rawFitness, 13, output);
        output.write("\n\n");

        return;
    }

    /*******************************************************************************
     * STATIC METHODS *
     *******************************************************************************/

} // End of OneMax.java ******************************************************
