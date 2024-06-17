package LottoGame2.domain;

import java.util.List;

public class LottoTicket {
    private final List<LottoNumbers> tickets;

    public LottoTicket(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    public void printTickets() {
        System.out.println("구매한 로또 번호:");
        for (LottoNumbers ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}
