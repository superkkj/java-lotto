package lotto;

import java.util.List;

public class Lotto {
    public static final int COUNT_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != COUNT_OF_NUMBERS){
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto = " + lottoNumbers;
    }
}
