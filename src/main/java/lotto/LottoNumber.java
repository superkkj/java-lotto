package lotto;

public class LottoNumber {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    private final int value;

    private LottoNumber(int number) {
        validateNumberRange(number);
        this.value = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
