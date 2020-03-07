/**
 * Class containing the random strategy.
 * 
 * @author 081028AW
 */

public class StrategyRandom extends Strategy {
   /**
    * Encoding for a strategy.
    */
   // 0 = defect, 1 = cooperate

   public StrategyRandom() {
      name = "Random";
   } /* StrategyRandom */

   public int nextMove() {
      if (Math.random() < 0.5)
         return 1;
      return 0;
   } /* nextMove */
} /* class StrategyRandom */
