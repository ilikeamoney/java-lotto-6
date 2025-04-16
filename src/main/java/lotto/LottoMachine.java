package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.GameStatus.*;

/**
 * 로또 머신 클래스의 역활은 우승자 티켓과 도전자 티켓 셋팅하고 그걸 반환하는거 까지
 */

public class LottoMachine implements Machine {

    private static Machine machine;

    private List<List<Integer>> challengeTickets;

    private Lotto winnerTickets;

    @Override
    public void operating() {
        setItems();
    }

    private void setItems() {
        // set challenge ticket
        PrintGameState.inputTotalBuyTicketPrice();
        Integer money = Integer.valueOf(Console.readLine());

        boolean c = LottoValidate.validateUserMoney(money);
        if (!c) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위 부터 구매 가능합니다.");
        }
        setChallengeTickets(money);

        // set winner ticket
        PrintGameState.inputWinNumber();
        String str = Console.readLine();
        setWinnerTickets(str);
    }

    public void setChallengeTickets(Integer money) {
        while (money > 0) {
            challengeTickets.add(getLottoNumbers());
            money /= MIN_PRICE.getValue();
        }
    }


    public void setWinnerTickets(String str) {
        if (!str.contains(",")) {
            throw new IllegalArgumentException("[Error] 입력이 잘못되었습니다.");
        }
        String[] n = str.split(",");
        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n.length; i++) {
            number.add(Integer.valueOf(n[i]));
        }

        winnerTickets = Lotto.getInstance(number);
    }

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public List<Integer> getWinnerTickets() {
        return winnerTickets.getNumbers();
    }

    public List<List<Integer>> getChallengeTickets() {
        return challengeTickets;
    }

    public static Machine getMachine() {
        if (machine == null) {
            machine = new LottoMachine();
        }

        return machine;
    }
}
