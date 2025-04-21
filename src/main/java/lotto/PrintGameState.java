package lotto;

import java.util.Map;

public class PrintGameState {

    private static final String[] grade = {"E", "D", "C", "B", "A"};

    public static void inputTotalBuyTicketPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(Map<String, Integer> lottoDrawingResult, Map<String, Integer> lottoPrizeMoney, Map<String, String> strPrizeMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int cnt = 3;
        for (int i = 0; i < grade.length; i++) {
            String key = grade[i];
            System.out.println(cnt + "개 일치 (" + strPrizeMoney.get(key) + ")원 - " + lottoDrawingResult.get(key) + "개");
            cnt += 1;
        }

        printAverage(lottoDrawingResult, lottoPrizeMoney);
    }

    private static void printAverage(Map<String, Integer> lottoDrawingResult, Map<String, Integer> lottoPrizeMoney) {
        int useMoney = Lotto.getUseMoney();
        int total = 0;

        for (int i = 0; i < grade.length; i++) {
            String key = grade[i];
            total += lottoPrizeMoney.get(key) * lottoDrawingResult.get(key);
        }

        double avg = (double) (100 * total) / useMoney;
        System.out.printf("총 수익률은 %.1f%%입니다.", avg);
    }
}
