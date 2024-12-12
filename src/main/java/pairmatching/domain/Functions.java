package pairmatching.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Functions {
    MATCHING("1", "페어 매칭"),
    INQUIRY("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String code;
    private final String description;

    Functions(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public static void askFunctionChoice() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(values()).map(f -> f.code + ". "+ f.description).forEach(System.out::println);
    }

    public static Functions findBy(final String inputCode) {
        return Arrays.stream(values()).filter(f -> Objects.equals(f.code, inputCode)).findFirst().orElseThrow();
    }
}