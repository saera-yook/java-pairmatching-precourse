package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public abstract class Crews {
    private final List<Crew> crews;

    protected Crews(final List<Crew> crews) {
        this.crews = crews;
    }

    public abstract Crews createSortedCrews(List<String> shuffledNames);

    public Map<Crew, Set<Crew>> createMatchingHistory() {
        Map<Crew, Set<Crew>> matchingHistory = new HashMap<>();
        crews.forEach(c -> matchingHistory.put(c, new HashSet<>()));
        return matchingHistory;
    }

    public List<Crew> group(int a, int b) {
        List<Crew> result = new ArrayList<>();
        result.add(crews.get(a));
        result.add(crews.get(b));
        return result;
    }

    protected Stream<Crew> findByName(List<String> names) {
        return names.stream()
                .map(n -> crews.stream().filter(c -> c.hasSameName(n)).findFirst().orElseThrow());
    }

}
