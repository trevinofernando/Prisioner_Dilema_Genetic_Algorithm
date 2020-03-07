/**
 * Class containing the tit-for-tat strategy.
 * 
 * @author 081028AW
 */
public class StrategyTitForTat extends Strategy {
   /**
    * Encoding for tit-for-tat strategy.
    */

   // 0 = defect, 1 = cooperate

   public StrategyTitForTat() {
      name = "Tit for Tat";
      opponentLastMove = 1;
   } /* StrategyTitForTat */

   public int nextMove() {
      return opponentLastMove;
   } /* nextMove */

} /* class StrategyTitForTat */
