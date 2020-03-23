package model;

import exception.BetFormatException;
import exception.BetRangeException;
import utils.StringUtils;

import java.util.Objects;

public class Bet {
    public static final double LOWER_BET_BOUND = 100;

    private final double bet;

    public Bet(String input) {
        validate(input);
        this.bet = Double.parseDouble(input);
    }

    private void validate(String input) {
        StringUtils.validateString(input);
        validateFormat(input);
        validateRange(input);
    }

    private void validateFormat(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new BetFormatException("베팅금액은 실수만 입력 가능합니다.");
        }
    }

    private void validateRange(String input) {
        if (Double.parseDouble(input) < LOWER_BET_BOUND) {
            throw new BetRangeException("베팅금액은 100원 이상부터 입력 가능합니다.");
        }
    }

    public double multiplyBet(double ratio) {
        return bet * ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet1 = (Bet) o;
        return Double.compare(bet1.bet, bet) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bet);
    }
}
