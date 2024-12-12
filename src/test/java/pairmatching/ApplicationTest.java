package pairmatching;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pairmatching.Application;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 출력() {
        assertSimpleTest(() -> {
            run("1", "프론트엔드, 레벨1, 자동차경주");
            assertThat(output()).isEqualTo(
                    """
                    기능을 선택하세요.
                    1. 페어 매칭
                    2. 페어 조회
                    3. 페어 초기화
                    Q. 종료
                    
                    #############################################
                    과정: 백엔드 | 프론트엔드
                    미션:
                      - 레벨1: 자동차경주 | 로또 | 숫자야구게임
                      - 레벨2: 장바구니 | 결제 | 지하철노선도
                      - 레벨3:\s
                      - 레벨4: 성능개선 | 배포
                      - 레벨5:\s
                    ############################################
                    과정, 레벨, 미션을 선택하세요.
                    ex) 백엔드, 레벨1, 자동차경주
                    """.trim()
            );
        });
    }


    @Disabled
    @Test
    void 짝수_인원_페어_매칭() {
        assertShuffleTest(
            () -> {
                run("1", "백엔드, 레벨1, 자동차경주", "Q");
                assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
            },
            Arrays.asList("태웅", "백호", "치수", "태섭")
        );
    }
    @Disabled
    @Test
    void 없는_미션에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("1", "백엔드, 레벨1, 오징어게임");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
