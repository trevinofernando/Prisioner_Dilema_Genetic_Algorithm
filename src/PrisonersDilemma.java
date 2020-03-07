/**
 * Class containing the Prisoner's Dilemma (PD).
 * 
 * @author 081028AW
 */
public class PrisonersDilemma extends Object {
   /**
    * Prisoner's Dilemma program.
    */
   Strategy player1;
   Strategy player2;

   int T = 7;
   int R = 5;
   int P = 3;
   int S = 1;

   int player1Payoff;
   int player2Payoff;

   int player1Move;
   int player2Move;

   public PrisonersDilemma(Strategy p1, Strategy p2) {
      this.player1 = p1;
      this.player2 = p2;
   } /* PrisonersDilemma */

   public int playPD() {
      // 0 = defect, 1 = cooperate
      player1Move = player1.nextMove();
      player2Move = player2.nextMove();

      player1.saveMyMove(player1Move);
      player2.saveMyMove(player2Move);
      player1.saveOpponentMove(player2Move);
      player2.saveOpponentMove(player1Move);

      if (player1Move == 0 && player2Move == 0) {
         player1Payoff = P;
         player2Payoff = P;
      } else if (player1Move == 0 && player2Move == 1) {
         player1Payoff = T;
         player2Payoff = S;
      } else if (player1Move == 1 && player2Move == 0) {
         player1Payoff = S;
         player2Payoff = T;
      } else if (player1Move == 1 && player2Move == 1) {
         player1Payoff = R;
         player2Payoff = R;
      }
      return 0;
   } /* playPD */

   public int getPlayer1Move() {
      return player1Move;
   }

   public int getPlayer2Move() {
      return player2Move;
   }

   public int getPlayer1Payoff() {
      return player1Payoff;
   }

   public int getPlayer2Payoff() {
      return player2Payoff;
   }

} /* class PrisonersDilemmd */
