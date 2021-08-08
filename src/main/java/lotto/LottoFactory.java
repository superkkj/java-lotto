package lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Lotto.COUNT_OF_NUMBERS;

public class LottoFactory {
    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static LottoFactory of() {
        return new LottoFactory(new RandomNumberGenerator());
    }

    public List<Lotto> create(Money money) {
        return IntStream.range(0, money.unit())
                .mapToObj(x -> {
                    List<LottoNumber> lottoNumbers = IntStream.range(0, COUNT_OF_NUMBERS)
                            .mapToObj( a -> LottoNumber.of(numberGenerator.generate()))
                            .collect(Collectors.toList());
                    return Lotto.of(lottoNumbers);
                })
                .collect(Collectors.toList());
    }
}
