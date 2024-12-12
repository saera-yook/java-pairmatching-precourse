package pairmatching.domain;

import java.util.List;
import java.util.stream.Stream;

public abstract class Crews {
    private final List<Crew> crews;

    protected Crews(final List<Crew> crews) {
        this.crews = crews;
    }

    protected Stream<Crew> findByName(List<String> names) {
        return names.stream()
                .map(n -> crews.stream().filter(c -> c.hasSameName(n)).findFirst().orElseThrow());
    }

    public abstract Crews createSortedCrews(List<String> shuffledNames);
}
