package LottoGame2.domain;

import LottoGame2.LottoEnum.LottoConfig;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidCount(numbers) || hasDuplicates(numbers) || !isValidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 1 && num <= LottoConfig.NUMBER_RANGE.getValue());
    }

    private boolean isValidCount(List<Integer> numbers) {
        return numbers.size() != LottoConfig.WINNING_NUMBERS_COUNT.getValue();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
