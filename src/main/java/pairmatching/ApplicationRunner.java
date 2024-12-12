package pairmatching;

import static pairmatching.domain.Functions.MATCHING;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Functions;
import pairmatching.domain.Level;
import pairmatching.view.ConsoleInputView;
import pairmatching.view.ConsoleOutputView;
import pairmatching.view.ResourceFileReader;

public class ApplicationRunner {
    private static final String BACKEND_FILE_PATH_NAME = "./src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_PATH_NAME = "./src/main/resources/frontend-crew.md";

    private final ConsoleInputView consoleInputView = new ConsoleInputView();
    private final ConsoleOutputView consoleOutputView = new ConsoleOutputView();

    public void run() {
        Functions.askFunctionChoice();
        String inputChoice = consoleInputView.readLine();

        if (MATCHING.equals(Functions.findBy(inputChoice))) {
            printCoursesAndMissions();
            matchPair();
        }
    }

    private void matchPair() {
        consoleOutputView.println("과정, 레벨, 미션을 선택하세요.");
        consoleOutputView.println("ex) 백엔드, 레벨1, 자동차경주");
        String input = consoleInputView.readLine();

    }

    private void printCoursesAndMissions() {
        consoleOutputView.println();
        consoleOutputView.println("#############################################");
        Course.printCourses();
        Level.printMissions();
        consoleOutputView.println("############################################");
    }
}
