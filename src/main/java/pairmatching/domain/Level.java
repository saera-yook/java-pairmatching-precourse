package pairmatching.domain;

import static pairmatching.domain.Mission.BASEBALL;
import static pairmatching.domain.Mission.BASKET;
import static pairmatching.domain.Mission.DISTRIBUTION;
import static pairmatching.domain.Mission.LOTTO;
import static pairmatching.domain.Mission.PAYMENT;
import static pairmatching.domain.Mission.RACING;
import static pairmatching.domain.Mission.REFACTORING;
import static pairmatching.domain.Mission.SUBWAY;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(RACING, LOTTO, BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(BASKET, PAYMENT, SUBWAY)),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList(REFACTORING, DISTRIBUTION)),
    LEVEL5("레벨5", Arrays.asList());

    private final String name;
    private final List<Mission> missions;

    Level(String name, final List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static void printMissions() {
        System.out.println("미션:");
        Arrays.stream(values()).map(l -> "  - " + l.name + ": " + l.makeMissionMessage()).forEach(System.out::println);
    }

    private String makeMissionMessage() {
        return this.missions.stream().map(Mission::getName).collect(Collectors.joining(" | "));
    }
}
