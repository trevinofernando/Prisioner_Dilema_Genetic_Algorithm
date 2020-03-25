
/**
 * Class containing the strategy developed by the Genetic Algorithm.
 * 
 * @author Fernando Trevino Ramirez
 */
import java.util.*;

public class StrategyFernandoYaclaudes extends Strategy {
    /**
     * Encoding for a strategy.
     */
    Random r = new Random();
    double ProbabilityOfCooperatingGivenCooperation = 0.95;
    double ProbabilityOfCooperatingGivenDefection = 0.15;

    // 0 = defect, 1 = cooperate

    public StrategyFernandoYaclaudes() {
        name = "Strategy Developed by Fernando and Yaclaudes";
        opponentLastMove = 1;
        r.setSeed(75982);
    } /* StrategyFernandoYaclaudes */

    public int nextMove() {
        // Default p to Probability Of Cooperating Given Cooperation
        double p = ProbabilityOfCooperatingGivenCooperation;

        // If opponentLastMove == defect
        if (opponentLastMove == 0) {
            // Change p to be Probability Of Cooperating Given Defection
            p = ProbabilityOfCooperatingGivenDefection;
        }

        // Decision given on random chance
        if (p > r.nextDouble()) {
            return 1;
        } else {
            return 0;
        }

    } /* nextMove */
} /* class StrategyFernandoYaclaudes */