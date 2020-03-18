/**
 * Class containing the Grudger strategy.
 * 
 * @author Fernando Trevino Ramirez
 */
public class StrategyGrudger extends Strategy {
    /**
     * Encoding for Grudger strategy.
     */

    boolean betrayalFlag = false;

    // 0 = defect, 1 = cooperate

    public StrategyGrudger() {
        name = "Grudger";
        opponentLastMove = 1;
    } /* StrategyGrudger */

    public int nextMove() {
        if (opponentLastMove == 0) {
            betrayalFlag = true;
        }
        if (betrayalFlag) {
            return 0;
        } else {
            return 1;
        }
    } /* nextMove */

} /* class StrategyGrudger */