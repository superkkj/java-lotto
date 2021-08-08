package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Lotto.COUNT_OF_NUMBERS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7})
    void 로또는_번호가_6개가_아니면_예외가_발생한다(int countOfNumbers) {
        // given
        List<LottoNumber> lottoNumbers = IntStream.range(10, 10 + countOfNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        // when & then
        assertThatThrownBy(() -> Lotto.of(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호는_6개면_성공된다() {
        // given
        List<LottoNumber> lottoNumbers = IntStream.range(10, 10 + COUNT_OF_NUMBERS)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());

        Lotto lotto = Lotto.of(lottoNumbers);
    }
}
