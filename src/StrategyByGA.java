
/**
 * Class containing the strategy developed by the Genetic Algorithm.
 * 
 * @author Fernando Trevino Ramirez
 */
import java.util.*;

public class StrategyByGA extends Strategy {
    /**
     * Encoding for a strategy.
     */
    double proCoopGivCoop;
    double proCoopGivDef;
    Random r = new Random();

    // 0 = defect, 1 = cooperate

    public StrategyByGA(double ProbabilityOfCooperatingGivenCooperatation,
            double ProbabilityOfCooperatingGivenDefectiontion) {

        name = "Strategy Developed by the Genetic Algorithm";
        r.setSeed(75982);
        opponentLastMove = 1;
        proCoopGivCoop = ProbabilityOfCooperatingGivenCooperatation;
        proCoopGivDef = ProbabilityOfCooperatingGivenDefectiontion;
    } /* StrategyByGA */

    public int nextMove() {
        // Default p to ProbabilityOfCooperatingGivenCooperatation
        double p = proCoopGivCoop;

        // If opponentLastMove == defect
        if (opponentLastMove == 0) {
            // Change p to be ProbabilityOfCooperatingGivenDefectiontion
            p = proCoopGivDef;
        }

        // Decision given on random chance
        if (p > r.nextDouble()) {
            return 1;
        } else {
            return 0;
        }

    } /* nextMove */
} /* class StrategyByGA */