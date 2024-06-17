package LottoGame2.domain;

import LottoGame2.LottoEnum.WinningPrize;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<WinningPrize, Integer> prizeCount;
    private int totalPrize;

    public LottoResult() {
        this.prizeCount = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            prizeCount.put(prize, 0);
        }
        this.totalPrize = 0;
    }

    public void addResult(WinningPrize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
        totalPrize += prize.getWinningPrizeMoney();
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (WinningPrize prize : WinningPrize.values()) {
            if (prize != WinningPrize.NONE) {
                System.out.println(prize.getRank() + ": " + prizeCount.get(prize) + "개");
            }
        }
        System.out.println("총 당첨 금액: " + totalPrize + "원");
    }
}
