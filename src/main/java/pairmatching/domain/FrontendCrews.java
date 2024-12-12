package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class FrontendCrews extends Crews {

    public FrontendCrews(final List<Crew> crews) {
        super(crews);
    }

    @Override
    public FrontendCrews createSortedCrews(final List<String> shuffledNames) {
        return super.findByName(shuffledNames)
                .collect(Collectors.collectingAndThen(Collectors.toList(), FrontendCrews::new));
    }
}
