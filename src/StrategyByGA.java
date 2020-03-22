
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

    // 0 = defect, 1 = cooperate

    public StrategyByGA(double ProbabilityOfCooperatingGivenCooperation,
            double ProbabilityOfCooperatingGivenDefection) {

        name = "Strategy Developed by the Genetic Algorithm";
        opponentLastMove = 1;
        proCoopGivCoop = ProbabilityOfCooperatingGivenCooperation;
        proCoopGivDef = ProbabilityOfCooperatingGivenDefection;
    } /* StrategyByGA */

    public int nextMove() {
        // Default p to ProbabilityOfCooperatingGivenCooperation
        double p = proCoopGivCoop;

        // If opponentLastMove == defect
        if (opponentLastMove == 0) {
            // Change p to be ProbabilityOfCooperatingGivenDefection
            p = proCoopGivDef;
        }

        // Decision given on random chance
        if (p > Search.r.nextDouble()) {
            return 1;
        } else {
            return 0;
        }

    } /* nextMove */
} /* class StrategyByGA */