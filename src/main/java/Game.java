import java.util.ArrayList;


//large class
//switch statements
//divergent change
//dead code
//Data Clumps
public class Game {
	ArrayList<Player> players = new ArrayList<>();
	Questions questions;
	Category category;
	int currentPlayer = 0;


	public Game() {
		questions = new Questions(50);
		category = new Category();
	}

	public String add(String playerName) {
		if (players.size() >= 6 )
			throw new RuntimeException("Maximum amount of players reached");
		if (playerName == null)
			throw new IllegalArgumentException("player name is null");

		players.add(new Player(playerName));
		System.out.println(playerName + " was added");
		System.out.println("They are player number " + players.size());
		return playerName;
	}
	public int roll(int roll) {
		if (roll > 6 || roll < 1)
			throw new IllegalArgumentException("Illegal dice roll");
		IncreasePlayer();
		System.out.println(players.get(currentPlayer).name + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (players.get(currentPlayer).inPenaltyBox) {
			if (roll % 2 == 0) {
				System.out.println(players.get(currentPlayer).name + " is not getting out of the penalty box");
				return -1;
			}
		}
		IncreasePlace(roll);
		System.out.println(players.get(currentPlayer).name
				+ "'s new location is "
				+ players.get(currentPlayer).place);
		System.out.println("The category is " + category.currentCategory(players.get(currentPlayer).place));
		questions.askQuestion(category.currentCategory(players.get(currentPlayer).place));
		return 0;
	}
	private void IncreasePlayer(){
		currentPlayer++;
		if (currentPlayer == players.size())
			currentPlayer = 0;
	}
	private void IncreasePlace(int roll){
		players.get(currentPlayer).place = players.get(currentPlayer).place + roll;
		if (players.get(currentPlayer).place > 11)
			players.get(currentPlayer).place = players.get(currentPlayer).place - 12;
	}
}
