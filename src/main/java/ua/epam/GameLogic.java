package ua.epam;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private static final String PLEASE_CHOOSE_ONE_OF_ROCK_0_PAPER_1_SCISSORS_2 = "Please Choose one of\nRock - 0\nPaper - 1\nScissors - 2";
    private static final String YOU_MUST_CHOOSE_ONE_OF_THE_ANSWERS = "You must choose one of the answers";
    private static final String YOUR_CHOICE_IS_WRONG = "Your choice is wrong";
    private static final String WIN = "Win";
    private static final String DRAW = "Draw";
    private static final String YOU_LOSE = "You lose";
    private static final String PLAYER_CHOOSE = "Player choose ";
    private static final String COMP_CHOOSE = "comp choose ";
    private Scanner in = new Scanner(System.in);
    private Random random = new Random();
    private Elements playerChoice;
    private Elements compChoice;

    public Elements getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Elements playerChoice) {
        this.playerChoice = playerChoice;
    }

    public Elements getCompChoice() {
        return compChoice;
    }

    public void setCompChoice(Elements compChoice) {
        this.compChoice = compChoice;
    }
    public Elements playerChooseOneOf() {
        boolean isChoose = false;
        while (!isChoose) {
            System.out.println(PLEASE_CHOOSE_ONE_OF_ROCK_0_PAPER_1_SCISSORS_2);
            try {
                setPlayerChoice(Elements.values()[in.nextInt()]);
                playerAnswerSwitch(getPlayerChoice());
                isChoose = true;
            } catch (InputMismatchException e) {
                System.out.println(YOU_MUST_CHOOSE_ONE_OF_THE_ANSWERS);
            }
            if (!isChoose) {
                System.out.println(YOUR_CHOICE_IS_WRONG);
            }
        }
        return getPlayerChoice();
    }

    public boolean playerAnswerSwitch(Elements value) {
        switch (value) {
            case Rock:
                setPlayerChoice(Elements.Rock);
                break;
            case Paper:
                setPlayerChoice(Elements.Paper);
                break;
            case Scissors:
                setPlayerChoice(Elements.Scissors);
                break;
            default:
                return false;
        }
        return true;
    }

    public Elements compChooseOneOf() {
        setCompChoice(Elements.values()[random.nextInt(3)]);
        return getCompChoice();
    }

    public void resultGame(Elements player, Elements comp) {
        if (player == Elements.Rock && comp == Elements.Scissors) {
            printResult(WIN);
        } else if (player == Elements.Paper && comp == Elements.Rock) {
            printResult(WIN);
        } else if (player == Elements.Scissors && comp == Elements.Paper) {
            printResult(WIN);
        } else if (player == comp) {
            printResult(DRAW);
        } else {
            printResult(YOU_LOSE);
        }
    }

    public void printResult(String result) {
        System.out.println(PLAYER_CHOOSE + getPlayerChoice().getName());
        System.out.println(COMP_CHOOSE + getCompChoice().getName());
        System.out.println(result);
    }

    public void startGame() {
        playerChooseOneOf();
        compChooseOneOf();
        resultGame(getPlayerChoice(), getCompChoice());
    }

}
