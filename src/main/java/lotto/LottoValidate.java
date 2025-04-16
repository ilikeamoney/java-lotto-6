package lotto;

import static lotto.GameStatus.*;

/**
 * LottoValidate 클래스는 사용자의 입력을 검증함
 */

public class LottoValidate {
    public static boolean validateUserMoney(Integer money) {
        if (money == null) {
            return false;
        }

        if (money < MIN_PRICE.getValue()) {
            return false;
        }

        if (money % MIN_PRICE.getValue() != 0) {
            return false;
        }

        String str = String.valueOf(money);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < '0') {
                return false;
            } else if (c > '9') {
                return false;
            }
        }

        return true;
    }

}
