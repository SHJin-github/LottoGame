package LottoGame2.Service;

import LottoGame2.LottoEnum.LottoConfig;
import LottoGame2.LottoEnum.WinningPrize;
import LottoGame2.domain.LottoNumbers;
import LottoGame2.domain.LottoTicket;
import LottoGame2.domain.LottoResult;

import java.util.List;

public class LottoService {

    private final LottoNumberGenerator numberGenerator;

    public LottoService(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoTicket buyTickets(int money) {
        int result = money % LottoConfig.TICKET_PRICE.getValue();
        if (result != 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.");
        }
        int ticketCount = money / LottoConfig.TICKET_PRICE.getValue();
        List<LottoNumbers> tickets = numberGenerator.generateLottoTickets(ticketCount);
        return new LottoTicket(tickets);
    }

    public LottoResult checkResults(LottoTicket ticket, LottoNumbers winningNumbers, int bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoNumbers lotto : ticket.getTickets()) {
            WinningPrize prize = calculatePrize(lotto, winningNumbers, bonusNumber);
            lottoResult.addResult(prize);
        }
        return lottoResult;
    }

    private WinningPrize calculatePrize(LottoNumbers ticket, LottoNumbers winningNumbers, int bonusNumber) {
        int matchCount = (int) ticket.getNumbers().stream().filter(winningNumbers.getNumbers()::contains).count();
        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
        return WinningPrize.valueOf(matchCount, bonusMatch);
    }
}
