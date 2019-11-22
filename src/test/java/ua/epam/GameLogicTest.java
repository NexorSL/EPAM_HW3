package ua.epam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameLogicTest {
    GameLogic gameLogic = new GameLogic();
    @Test
    public void testPlayerswitchAnswer(){
        boolean result = gameLogic.playerAnswerSwitch(Elements.Rock);
        assertEquals(result, true);
        result = gameLogic.playerAnswerSwitch(Elements.Paper);
        assertEquals(result, true);
        result = gameLogic.playerAnswerSwitch(Elements.Scissors);
        assertEquals(result, true);
    }
}
