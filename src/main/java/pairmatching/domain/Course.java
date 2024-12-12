package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static void printCourses() {
        System.out.println("과정: " + BACKEND.name + " | " + FRONTEND.name);
    }

    public static boolean isBackend(String name) {
        return BACKEND.name.equals(name);
    }
}
