/**
 * Class containing the always-cooperate strategy.
 * 
 * @author 081028AW
 */
public class StrategyAlwaysDefect extends Strategy {
   /**
    * Encoding for a strategy.
    */

   // 0 = defect, 1 = cooperate

   public StrategyAlwaysDefect() {
      name = "Always defect";
   } /* StrategyAlwaysDefect */

   public int nextMove() {
      return 0;
   } /* nextMove */
} /* class StrategyAlwaysDefect */
