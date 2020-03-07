/**
 * Class containing the always-cooperate strategy.
 * 
 * @author 081028AW
 */
public class StrategyAlwaysCooperate extends Strategy {
   /**
    * Encoding for a strategy.
    */

   // 0 = defect, 1 = cooperate

   public StrategyAlwaysCooperate() {
      name = "Always cooperate";
   } /* StrategyAlwaysCooperate */

   public int nextMove() {
      return 1;
   } /* nextMove */
} /* class StrategyAlwaysCooperate */
