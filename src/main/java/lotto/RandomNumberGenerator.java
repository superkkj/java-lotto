package lotto;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(LottoNumber.MAX_RANGE ) + LottoNumber.MIN_RANGE; // 1~45
    }
}
