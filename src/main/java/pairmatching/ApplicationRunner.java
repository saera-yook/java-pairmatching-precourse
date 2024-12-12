package pairmatching;

import pairmatching.domain.Functions;
import pairmatching.view.ConsoleInputView;

public class ApplicationRunner {
    public void run() {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        Functions.askFunctionChoice();
        String input = consoleInputView.readLine();
    }
}
