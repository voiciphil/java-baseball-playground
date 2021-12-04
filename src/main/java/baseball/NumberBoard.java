package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberBoard {

    private static final int DIGIT = 3;

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
}
