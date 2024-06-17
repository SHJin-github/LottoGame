package LottoGame2.LottoEnum;

public enum LottoConfig {

    NUMBER_RANGE(45),
    TICKET_PRICE(1000),
    WINNING_NUMBERS_COUNT(6),
    BONUS_NUMBERS_COUNT(1);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
