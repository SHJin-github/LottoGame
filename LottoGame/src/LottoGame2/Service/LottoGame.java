package LottoGame2.Service;

import LottoGame2.LottoEnum.LottoConfig;
import LottoGame2.domain.LottoNumbers;
import LottoGame2.domain.LottoTicket;
import LottoGame2.domain.LottoResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private final LottoService lottoService;
    private final LottoNumberGenerator numberGenerator;

    public LottoGame() {
        this.numberGenerator = new LottoNumberGenerator();
        this.lottoService = new LottoService(numberGenerator);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("로또 구입 금액을 입력해 주세요:");
            int money = Integer.parseInt(scanner.nextLine());

            LottoTicket ticket = lottoService.buyTickets(money);

            System.out.println("당첨 번호를 입력해 주세요 (공백으로 구분된 6개 숫자):");
            List<Integer> winningNumbers = readNumbers(scanner);
            LottoNumbers winningLotto = new LottoNumbers(winningNumbers);

            System.out.println("보너스 번호를 입력해 주세요:");
            int bonusNumber = Integer.parseInt(scanner.nextLine());

            ticket.printTickets();
            LottoResult lottoResult = lottoService.checkResults(ticket, winningLotto, bonusNumber);
            lottoResult.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Integer> readNumbers(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        if (input.length != LottoConfig.WINNING_NUMBERS_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 개수입니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.start();
    }
}
