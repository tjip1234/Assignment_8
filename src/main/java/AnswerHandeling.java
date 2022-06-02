public class AnswerHandeling {
    Game game;
    AnswerHandeling(Game game){
        this.game = game;
    }
    public boolean wasCorrectlyAnswered() {
        System.out.println("Answer was correct!!!!");
        game.players.get(game.currentPlayer).purse++;
        System.out.println(game.players.get(game.currentPlayer).name
                + " now has "
                + game.players.get(game.currentPlayer).purse
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        return winner;
    }

    private boolean didPlayerWin() {
        return game.players.get(game.currentPlayer).purse < 6;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(game.players.get(game.currentPlayer).name + " was sent to the penalty box");
        game.players.get(game.currentPlayer).inPenaltyBox = true;

        return true;
    }
    public boolean Skip(){
        return true;
    }

}
