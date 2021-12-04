package baseball;

public class BaseballGame {

    public static final NumberBoard numberBoard = new NumberBoard();

    public static void main(String[] args) {
        while (true) {
            String input = InputView.getInput();
            Result result = numberBoard.calculateResult(input);
            ResultView.printResult(result);

            if (result.isSuccess()) {
                break;
            }
        }
    }
}
