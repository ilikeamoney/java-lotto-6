package lotto;

import java.util.List;

/**
 * 로또 클래스의 역활은 우승자 티켓 검증과 생성 (보너스)
 */

public class Lotto {

    public static Lotto instance;

    private final List<Integer> numbers;

    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 입력이 잘못되었습니다.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            } else if (numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto getInstance(List<Integer> numbers) {
        if (instance == null) {
            instance = new Lotto(numbers);
        }

        return instance;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        if (bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        } else if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        this.bonusNumber = bonusNumber;
    }
}
