package lotto;

import static lotto.GameStatus.*;

/**
 * LottoValidate 클래스는 사용자의 입력을 검증함
 */

public class LottoValidate {
    public static void validateUserMoney(Integer money) {
        if (money == null) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
        }

        if (money < MIN_PRICE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위 부터 구매 가능합니다.");
        }

        if (money % MIN_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위 부터 구매 가능합니다.");
        }

        String str = String.valueOf(money);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < '0') {
                throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
            } else if (c > '9') {
                throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다.");
            }
        }
    }

    public static void validateWinnerTicket(String winnerNum, String bonusNum) {
        if (!winnerNum.contains(",")) {
            throw new IllegalArgumentException("[Error] 입력이 잘못되었습니다.");
        }

        if (bonusNum.length() > 1) {
            throw new IllegalArgumentException("[Error] 입력이 잘못되었습니다.");
        }
    }
}
