package lotto;

import lotto.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_RANGE-1, LottoNumber.MAX_RANGE+1})
    void 로또_번호는_1_45_사이를_벗어나면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자를_입력하면_로또번호가_생성된다() {
        // given
        int number = 15;

        // when
        LottoNumber lottoNumber = LottoNumber.of(number);

        // then
        assertThat(number).isEqualTo(lottoNumber.value());
    }
}
