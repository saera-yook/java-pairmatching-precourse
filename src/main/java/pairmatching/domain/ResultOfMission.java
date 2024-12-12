package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultOfMission {
    private final Mission mission;
    private final Crews crews;

    public ResultOfMission(final Mission mission, final Crews crews) {
        this.mission = mission;
        this.crews = crews;
    }

}
