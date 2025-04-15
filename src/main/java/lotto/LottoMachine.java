package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.GameStatus.*;

public class LottoMachine implements Machine {

    private List<List<Integer>> challengeTickets;

    private Lotto winnerTickets;

    @Override
    public void operating() {

    }

    private void setItems() {
        PrintGameState.inputTotalBuyTicketPrice();
        Integer money = Integer.valueOf(Console.readLine());

        boolean c = LottoValidate.validateUserMoney(money);

        if (!c) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위 부터 구매 가능합니다.");
        }

        setChallengeTickets(money);
    }

    public void setChallengeTickets(Integer money) {
        while (money > 0) {
            challengeTickets.add(getLottoNumbers());
            money /= MIN_PRICE.getValue();
        }
    }

    //TODO winner ticket challenge ticket 구현하기
    public void setWinnerTickets(String str) {


    }

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
