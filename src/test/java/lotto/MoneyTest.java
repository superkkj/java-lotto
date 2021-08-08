package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {12, 466, 32135, 323, 245})
    void 단위가_1000이_아니면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> Money.of(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 10000})
    void 단위가_1000이면_생성을_성공한다(int value) {
        Money money = Money.of(value);

        assertThat(money.value()).isEqualTo(value);
    }

    @Test
    void 논리적_동치성은_value가_일치하면_된다() {
        assertThat(Money.of(1000)).isEqualTo(Money.of(1000));
    }

    @Test
    void 단위만큼_갯수를_반환한다() {
         Money money = Money.of(3000);

        assertThat(money.unit()).isEqualTo(3);
    }
}
