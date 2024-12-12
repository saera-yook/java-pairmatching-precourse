package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BackendCrews extends Crews {

    public BackendCrews(final List<Crew> crews) {
        super(crews);
    }



    public BackendCrews createSortedCrews(List<String> shuffledNames) {
        return super.findByName(shuffledNames)
                .collect(Collectors.collectingAndThen(Collectors.toList(), BackendCrews::new));
    }
}
