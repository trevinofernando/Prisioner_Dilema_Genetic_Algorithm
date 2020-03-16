/**
 * Class containing iterated Prisoner's Dilemma (IPD).
 * 
 * @author 081028AW
 */
public class IteratedPD extends Object {
   /**
    * Iterated Prisoner's Dilemma.
    */

   int maxSteps;

   PrisonersDilemma pd;
   Strategy p1, p2;
   int p1Score;
   int p2Score;

   public IteratedPD(Strategy player1, Strategy player2) {
      this.p1 = player1;
      this.p2 = player2;

      pd = new PrisonersDilemma(p1, p2);
      p1Score = 0;
      p2Score = 0;

      if (RunIPD.debugModeOn) {
         System.out.printf(" Player 1 is %s, Player 2 is %s\n", p1.getName(), p2.getName());
      }
   } /* IteratedPD */

   public void runSteps(int maxSteps) {
      int i;

      for (i = 0; i < maxSteps; i++) {
         pd.playPD();
         p1Score += pd.getPlayer1Payoff();
         p2Score += pd.getPlayer2Payoff();

         if (RunIPD.debugModeOn) {
            System.out.printf(" t %3d   P1 move %d payoff %d (%3d)   P2 move %d payoff %d (%3d)\n", i,
                  pd.getPlayer1Move(), pd.getPlayer1Payoff(), p1Score, pd.getPlayer2Move(), pd.getPlayer2Payoff(),
                  p2Score);
         }

         /*
          * System.out.printf(" Iteration %d\n", i);
          * System.out.printf("      Player1 move %d,   Player2 move %d\n",
          * pd.getPlayer1Move(), pd.getPlayer2Move());
          * System.out.printf("      Player1 payoff %d, Player2 payoff %d\n",
          * pd.getPlayer1Payoff(), pd.getPlayer2Payoff());
          * System.out.printf("      Player1 sum %d,    Player2 sum %d\n", p1Score,
          * p2Score); System.out.printf("      Player1 OLM %d,    Player2 OLM %d\n",
          * p1.getOpponentLastMove(), p2.getOpponentLastMove() );
          */
      } /* for i */
   }

   public int player1Score() {
      return p1Score;
   }

   public int player2Score() {
      return p2Score;
   }

} /* class IteratedPD */
