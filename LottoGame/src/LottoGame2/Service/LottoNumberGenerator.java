package LottoGame2.Service;

import LottoGame2.LottoEnum.LottoConfig;
import LottoGame2.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<LottoNumbers> generateLottoTickets(int count) {
        List<LottoNumbers> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoNumbers(generateRandomNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LottoConfig.NUMBER_RANGE.getValue(); i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, LottoConfig.WINNING_NUMBERS_COUNT.getValue());
    }
}
