import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void testPlayerCount(){
        Game game = new Game();
        assertEquals(game.add("hello"),"hello");
        assertEquals(game.add("*&&^$%"),"*&&^$%");
        assertEquals(game.add(" ")," ");
        assertEquals(game.players.size(), 3);
        game.roll(2);
    }
    @Test
    void testRolling(){
        Game game = new Game();
        game.add("1");
        //test for not even and not penaltybox
        int a = game.players.get(game.currentPlayer).place;
        game.roll(1);
        assertNotEquals(a,game.players.get(game.currentPlayer).place);
        //test for even and not penaltybox
        a = game.players.get(game.currentPlayer).place;
        game.roll(2);
        assertNotEquals(a,game.players.get(game.currentPlayer).place);
        //test for even and penaltybox
        a = game.players.get(game.currentPlayer).place;
        game.players.get(game.currentPlayer).inPenaltyBox = true;
        game.roll(2);
        assertEquals(a,game.players.get(game.currentPlayer).place);
        //test for not even and penaltybox
        a = game.players.get(game.currentPlayer).place;
        game.players.get(game.currentPlayer).inPenaltyBox = true;
        game.roll(1);
        assertNotEquals(a,game.players.get(game.currentPlayer).place);
    }
    @Test
    void testCategory(){
        //testing category change
        Game game = new Game();
        game.add("1");
        game.players.get(0).place = 0;
        assertEquals(game.category.currentCategory(game.players.get(0).place), "Pop");
        game.players.get(0).place = 1;
        assertEquals(game.category.currentCategory(game.players.get(0).place), "Science");
        game.players.get(0).place = 2;
        assertEquals(game.category.currentCategory(game.players.get(0).place), "Sports");
        game.players.get(0).place = 3;
        assertEquals(game.category.currentCategory(game.players.get(0).place), "Rock");
        //testing question
        String expected = "Rock";
        String actual = game.questions.askQuestion(game.category.currentCategory(game.players.get(0).place));
        assertTrue(actual.contains(expected));
        //testing exception
        game.players.get(0).place = 33;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.category.currentCategory(game.players.get(0).place);
        });
        String expectedMessage = "Not valid place";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void answer(){
        Game game = new Game();
        game.add("1");
        AnswerHandeling answer = new AnswerHandeling(game);
        assertEquals(answer.wrongAnswer(), true);
        assertEquals(answer.Skip(), true);
        for (int i = 0; i < 5; i++) {
            assertEquals(answer.wasCorrectlyAnswered(), true);
        }
        assertEquals(answer.wasCorrectlyAnswered(), false);
    }

}
