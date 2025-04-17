package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.GameStatus.*;

/**
 * 로또 머신 클래스의 역활은 우승자 티켓과 도전자 티켓 셋팅하고 Item 클래스에 셋팅
 */

public class LottoMachine implements Machine {

    private static Machine machine;

    private List<List<Integer>> challengeTickets;

    private Lotto winnerTickets;

    @Override
    public void operating() {
        init();
        setItem();
    }

    private void init() {
        // set challenge ticket
        PrintGameState.inputTotalBuyTicketPrice();
        Integer money = Integer.valueOf(Console.readLine());
        setChallengeTickets(money);

        // set winner number
        PrintGameState.inputWinNumber();
        String winnerNum = Console.readLine();

        // set bonus number
        PrintGameState.inputBonusNumber();
        String bonusNum = Console.readLine();

        setWinnerTickets(winnerNum, bonusNum);
    }

    private void setItem() {
        // set Item
        Item.setChallengeTicket(challengeTickets);
        Item.setWinnerTicket(winnerTickets.getNumbers());
        Item.setBonusNumber(winnerTickets.getBonusNumber());
    }

    public void setChallengeTickets(Integer money) {
        // is not a happened than setItem();
        LottoValidate.validateUserMoney(money);

        challengeTickets = new ArrayList<>();
        while (money > 0) {
            challengeTickets.add(getLottoNumbers());
            money /= MIN_PRICE.getValue();
        }
    }


    public void setWinnerTickets(String winnerNum, String bonusNum) {
        LottoValidate.validateWinnerTicket(winnerNum, bonusNum);

        String[] n = winnerNum.split(",");
        List<Integer> wNum = new ArrayList<>();
        Integer bNum = Integer.parseInt(bonusNum);

        for (int i = 0; i < n.length; i++) {
            wNum.add(Integer.valueOf(n[i]));
        }

        // is not a happened than setItem();
        winnerTickets = Lotto.getInstance(wNum);
        winnerTickets.setBonusNumber(bNum);
    }

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Machine getMachine() {
        if (machine == null) {
            machine = new LottoMachine();
        }

        return machine;
    }
}
