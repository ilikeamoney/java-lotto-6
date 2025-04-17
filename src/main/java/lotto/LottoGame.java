package lotto;

import java.util.List;

public class LottoGame implements Game{
    private final Machine machine = LottoMachine.getMachine();

    // TODO 로또 티켓 당첨 확인하기
    @Override
    public void play() {
        try {
            init();
            List<List<Integer>> cTicket = Item.getChallengeTicket();
            List<Integer> wTicket = Item.getWinnerTicket();
            Integer bNum = Item.getBonusNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void test() {

    }

    private void init() {
        machine.operating();
    }
}
