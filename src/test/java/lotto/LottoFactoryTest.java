package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    @Test
    void 받은_금액만큼_로또를_생성한다() {
        // given
         Money money = Money.of(3000);
         LottoFactory lottoFactory = LottoFactory.of();
        // when
        List<Lotto> lottos = lottoFactory.create(money);

        // then
        assertThat(lottos).hasSize(money.unit());
    }
}
