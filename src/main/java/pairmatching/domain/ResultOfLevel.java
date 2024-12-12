package pairmatching.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultOfLevel {
    private final Course course;
    private final Level level;
    private final EnumMap<Mission, List<List<Crew>>> resultOfMission;
    private final Map<Crew, Set<Crew>> matchingHistory;

    public ResultOfLevel(final Course course, final Level level, final Map<Crew, Set<Crew>> matchingHistory) {
        this.course = course;
        this.level = level;
        Map<Mission, List<List<Crew>>> resultOfMission = new HashMap<>();
        level.getMissions().forEach(m -> resultOfMission.put(m, null));
        this.resultOfMission = new EnumMap<>(resultOfMission);
        this.matchingHistory = matchingHistory;
    }

    public void matchOf(Mission mission, Crews crews) {
        if (resultOfMission.get(mission) == null) {
            List<List<Crew>> matchResults = new ArrayList<>();
            for (int i = 0; i < matchingHistory.size(); i += 2) {

                List<Crew> matchedCrews = matchCrews(crews, i, i + 1);
                while (hasBeenMatched(matchedCrews)) {
                    matchedCrews = matchCrews(crews, i, i + 2);
                }
               // matchResults.add();
            }
            if (matchResults.getLast().size() == 1) {
                matchResults.removeLast();
         //       matchResults.getLast().add(crews.getLast());
            }
        }
    }

    private List<Crew> matchCrews(Crews crews, int a, int b) {
        return crews.group(a, b);
    }

    private boolean hasBeenMatched(List<Crew> crews) {
        return !matchingHistory.get(crews.getFirst()).add(crews.getLast());
    }
}
