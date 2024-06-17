package LottoGame2.LottoEnum;

public enum WinningPrize {

    FIRST(6, false, 2000000000, "1등"),
    SECOND(5, true, 30000000, "2등"),
    THIRD(5, false, 1500000, "3등"),
    FOURTH(4, false, 50000, "4등"),
    FIFTH(3, false, 5000, "5등"),
    NONE(0, false, 0, "꽝");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String rank;

    WinningPrize(int matchCount, boolean matchBonus, int prizeMoney, String rank) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getWinningPrizeMoney() {
        return prizeMoney;
    }

    public String getRank() {
        return rank;
    }

    public static WinningPrize valueOf(int matchCount, boolean matchBonus) {
        for (WinningPrize prize : values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == matchBonus) {
                return prize;
            }
        }
        if (matchCount >= 3) {
            return WinningPrize.values()[6 - matchCount];
        }
        return NONE;
    }
}
