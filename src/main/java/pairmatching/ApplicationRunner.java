package pairmatching;

import static pairmatching.domain.Course.BACKEND;
import static pairmatching.domain.Course.FRONTEND;
import static pairmatching.domain.Functions.MATCHING;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.BackendCrews;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.FrontendCrews;
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
        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> backendCrewNames = resourceFileReader.readLines(BACKEND_FILE_PATH_NAME);
        List<String> frontendCrewNames = resourceFileReader.readLines(FRONTEND_FILE_PATH_NAME);
        BackendCrews backendCrews = backendCrewNames.stream().map(n -> new Crew(BACKEND, n))
                .collect(Collectors.collectingAndThen(Collectors.toList(), BackendCrews::new));
        FrontendCrews frontendCrews = frontendCrewNames.stream().map(n -> new Crew(FRONTEND, n))
                .collect(Collectors.collectingAndThen(Collectors.toList(), FrontendCrews::new));
        Functions.askFunctionChoice();
        String inputChoice = consoleInputView.readLine();
        if (MATCHING.equals(Functions.findBy(inputChoice))) {
            printCoursesAndMissions();
            matchPair();
        }

        List<String> shuffledNames = Randoms.shuffle(frontendCrewNames);
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
