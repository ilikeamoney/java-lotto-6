package lotto;

public class PrintGameState {

    public static void inputTotalBuyTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult() {

    }

    public static void printAverage() {

    }

    public static void printLottoNumberErrorState() {
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void printInputNumberErrorState() {
        System.out.println("[ERROR] 로또는 천원 단위 부터 구매 가능합니다.");
    }

}
