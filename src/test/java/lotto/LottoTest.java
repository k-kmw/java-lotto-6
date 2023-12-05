package lotto;

import lotto.model.BonusNum;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 주어지면 당첨 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("lottoMatchTestInput")
    void lottoMatchTest(Lotto lotto, Result expected) {
        // given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNum(7));

        // when
        Result result = lotto.match(winningLotto);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> lottoMatchTestInput() {
        return Stream.of(Arguments.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), Result.FIRST,
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), Result.SECOND,
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), Result.THIRD,
                new Lotto(List.of(1, 2, 3, 4, 7, 8)), Result.FOURTH,
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), Result.FOURTH,
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), Result.FIFTH,
                new Lotto(List.of(1, 2, 3, 8, 9, 10)), Result.FIFTH,
                new Lotto(List.of(1, 2, 7, 8, 9, 10)), Result.OTHER,
                new Lotto(List.of(1, 2, 8, 9, 10, 11)), Result.OTHER,
                new Lotto(List.of(1, 44, 43, 42, 41 ,40)), Result.OTHER,
                new Lotto(List.of(45, 44, 43, 42, 41 ,40)), Result.OTHER
        ));
    }
}