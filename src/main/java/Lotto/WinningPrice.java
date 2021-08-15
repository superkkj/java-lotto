package Lotto;

import java.util.Arrays;


public enum WinningPrice {

    NOT_WINNINGS(0, 0),
    THREE_WINNINGS(3, 5_000),
    FOUR_WINNINGS(4, 50_000),
    FIVE_WINNINGS(5, 1_500_000),
    FIVE_WINNINGS_BOBUS(5, 30_000_000),
    SIX_WINNINGS(6, 2_000_000_000);

    public final int match;
    public final int price;


    WinningPrice(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public static WinningPrice getWinnings(int numberOfMatch, boolean matchBonus) {

        if (numberOfMatch == 5) {
            return findBonusWinnings(matchBonus);
        }

        return Arrays.stream(values())
                .filter(winningPrice -> winningPrice.match == numberOfMatch)
                .findFirst()
                .orElse(NOT_WINNINGS);
    }

    public static WinningPrice findBonusWinnings(boolean matchBonus) {
        if (matchBonus){
            return WinningPrice.FIVE_WINNINGS_BOBUS;

        }

        return WinningPrice.FIVE_WINNINGS;
    }
}
