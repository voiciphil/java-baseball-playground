package baseball;

public class ResultView {

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("OUT");
            return;
        }

        if (strike == 0) {
            System.out.println(ball + "B");
            return;
        }

        if (ball == 0) {
            System.out.println(strike + "S");
            return;
        }

        System.out.println(strike + "S " + ball + "B");
    }
}
