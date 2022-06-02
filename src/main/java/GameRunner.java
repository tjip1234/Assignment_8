
import java.util.Random;

public class GameRunner {

	public static void main(String[] args) {
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		Random rand = new Random();

		boolean notAWinner;
		do {

			int returnCode = aGame.roll(rand.nextInt(5) + 1);
			if (returnCode == -1){
				notAWinner = new AnswerHandeling(aGame).Skip();
			}
			else if (rand.nextInt(9) == 7) {
				notAWinner = new AnswerHandeling(aGame).wrongAnswer();
			} else {
				notAWinner = new AnswerHandeling(aGame).wasCorrectlyAnswered();
			}

		} while (notAWinner);

	}
}
