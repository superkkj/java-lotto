package lotto;

public class Money {
    public static final int MONEY_UNIT= 1000;
    private final int value;

    public Money(int value) {
        if (value % MONEY_UNIT != 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public int value() {
        return value;
    }

    public int unit() {
        return this.value / MONEY_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
