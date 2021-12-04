package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberBoard {

    public static final int DIGIT = 3;

    private String number;

    public NumberBoard() {
        Set<Integer> set = new HashSet<>();
        number = "";
        while (set.size() < DIGIT) {
            addRandomNumber(set);
        }
    }

    private void addRandomNumber(Set<Integer> set) {
        int previousSize = set.size();
        int randomNumber = (int) (Math.random() * 9) + 1;
        set.add(randomNumber);
        if (previousSize < set.size()) {
            number += randomNumber;
        }
    }

    public Result calculateResult(String input) {
        int strike = calculateStrike(input);
        int ball = calculateBall(input);

        return new Result(strike, ball);
    }

    private int calculateStrike(String input) {
        int strike = 0;

        for (int i = 0; i < DIGIT; i++) {
            strike += isEqual(input.charAt(i), number.charAt(i));
        }

        return strike;
    }

    private int isEqual(char ch1, char ch2) {
        if (ch1 == ch2) {
            return 1;
        }

        return 0;
    }

    private int calculateBall(String input) {
        int ball = 0;

        for (int i = 0; i < DIGIT; i++) {
            ball += isBall(input, i);
        }

        return ball - calculateStrike(input);
    }

    private int isBall(String input, int digit) {
        int isBall = 0;

        for (int i = 0; i < DIGIT; i++) {
            isBall += isEqual(input.charAt(digit), number.charAt(i));
        }

        if (isBall > 0) {
            return 1;
        }

        return 0;
    }
}
