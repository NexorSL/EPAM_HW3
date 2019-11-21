package ua.epam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameRunner {

    private static final String DO_YOU_WANT_AGAIN_YES_1_NO_0 = "\nDo you want again?\nYes - 1\nNo - 0";
    private static final String ENTER_1_OR_0 = "Enter 1 or 0";

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        gameLogic.startGame();
        Scanner in = new Scanner(System.in);
        boolean again = false;
        int i = 1;
        while (!again){
            System.out.println(DO_YOU_WANT_AGAIN_YES_1_NO_0);
            try {
                i = in.nextInt();
            } catch (InputMismatchException e){
                System.out.println(ENTER_1_OR_0);
            }
            switch (i){
                case 1:
                    gameLogic.startGame();
                    break;
                case 0:
                    again = true;
                    break;
                default :
                    System.out.println(ENTER_1_OR_0);
            }
        }
    }
}
