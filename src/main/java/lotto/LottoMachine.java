package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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
        String strMoney = Console.readLine();
        setChallengeTickets(strMoney);

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

    public void setChallengeTickets(String str) {
        // is not a happened than setItem();
        int money = LottoValidate.validateUserMoney(str);
        Lotto.setUseMoney(money);

        challengeTickets = new ArrayList<>();
        while (money > 0) {
            List<Integer> lottoNumbers = getLottoNumbers();
            sortBefore(lottoNumbers);
            challengeTickets.add(lottoNumbers);
            money -= MIN_PRICE.getValue();
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

    // bubble
    private void sortBefore(List<Integer> lottoNumber) {
        for (int i = 0; i < lottoNumber.size(); i++) {
            for (int j = 0; j < lottoNumber.size() - 1; j++) {
                if (lottoNumber.get(j) > lottoNumber.get(j + 1)) {
                    int temp = lottoNumber.get(j);
                    lottoNumber.set(j, lottoNumber.get(j + 1));
                    lottoNumber.set(j + 1, temp);
                }
            }
        }
    }

    // select
    private void sortAfter(List<Integer> lottoNumber) {
        for (int i = 1; i < lottoNumber.size(); i++) {
            int key = lottoNumber.get(i);
            int j = i - 1;

            while (j >= 0 && lottoNumber.get(j) > key) {
                lottoNumber.set(j + 1, lottoNumber.get(j));
                j--;
            }
            lottoNumber.set(j + 1, key);
        }
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
