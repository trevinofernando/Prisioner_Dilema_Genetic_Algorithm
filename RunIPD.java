/**
 * General class containing main program to run the iterated Prisoner's Dilemma
 * (IPD).
 * 
 * @author 081028AW
 */
public class RunIPD extends Object {
   /**
    * Main program to start IPD program.
    */

   public static void main(String args[]) {
      int i;
      int maxSteps = 0;

      Strategy player1, player2;
      IteratedPD ipd;

      for (i = 0; i < args.length; i++) {
         /* check parameters */
         if (args[i].equals("-l") || args[i].equals("-L")) {
            maxSteps = Integer.parseInt(args[i + 1]);
            System.out.println(" Max steps = " + maxSteps);
         } /* if */
      } /* for i */

      player1 = new StrategyTitForTwoTats();
      player2 = new StrategyTitForTat();
      ipd = new IteratedPD(player1, player2);

      ipd.runSteps(maxSteps);

      System.out.printf(" Player 1 score = %d\n", ipd.player1Score());
      System.out.printf(" Player 2 score = %d\n", ipd.player2Score());

   } /* main */
} /* class RunIPD */
