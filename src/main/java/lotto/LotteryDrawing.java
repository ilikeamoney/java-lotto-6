package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryDrawing {

    private static LotteryDrawing instance;

    private Map<String, Integer> lottoDrawingResult;

    private Map<String, Integer> lottoPrizeMoney;

    private Map<String, String> strPrizeMoney;

    private LotteryDrawing() {

    }

    public static LotteryDrawing getInstance() {
        if (instance == null) {
            instance = new LotteryDrawing();
            return instance;
        }
        return instance;
    }


    public void lottoDrawing(List<List<Integer>> challengeTicket, List<Integer> winnerTicket, Integer bonusNum) {
        setLottoGrade();

        for (int i = 0; i < challengeTicket.size(); i++) {
            List<Integer> userTicket = challengeTicket.get(i);
            int cnt = checkLotto(userTicket, winnerTicket);

            if (cnt > 2) {
                checkPrize(cnt, userTicket, bonusNum);
            }
        }

    }

    private int checkLotto(List<Integer> userTicket, List<Integer> winnerTicket) {
        int cnt = 0;
        for (int i = 0; i < winnerTicket.size(); i++) {
            for (int j = 0; j < userTicket.size(); j++) {
                if (winnerTicket.get(i).equals(userTicket.get(j))) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    private void checkPrize(Integer cnt, List<Integer> userTicket, Integer bonusNum) {
        String grade = "E";

        switch(cnt) {
            case 6:
                grade = "A";
                break;
            case 5:
                if(checkBonusNum(userTicket, bonusNum)) {
                    grade = "B";
                    break;
                }
                grade = "C";
                break;
            case 4:
                grade = "D";
                break;
        }

        // 자바 8이상에서는 이렇게 굳이 꺼내지 않고 MAP에서 업데이트 가능
        lottoDrawingResult.merge(grade, 1, Integer::sum);
    }

    private boolean checkBonusNum(List<Integer> userTicket, Integer bonusNum) {
        for (int i = 0; i < userTicket.size(); i++) {
            if (userTicket.get(i).equals(bonusNum)) {
                return true;
            }
        }
        return false;
    }

    private void setLottoGrade() {
        lottoDrawingResult = new HashMap<>();
        lottoPrizeMoney = new HashMap<>();
        strPrizeMoney = new HashMap<>();

        lottoDrawingResult.put("A", 0);
        lottoDrawingResult.put("B", 0);
        lottoDrawingResult.put("C", 0);
        lottoDrawingResult.put("D", 0);
        lottoDrawingResult.put("E", 0);

        lottoPrizeMoney.put("A", 2000000000);
        lottoPrizeMoney.put("B", 30000000);
        lottoPrizeMoney.put("C", 1500000);
        lottoPrizeMoney.put("D", 50000);
        lottoPrizeMoney.put("E", 5000);

        strPrizeMoney.put("A", "2,000,000,000");
        strPrizeMoney.put("B", "30,000,000");
        strPrizeMoney.put("C", "1,500,000");
        strPrizeMoney.put("D", "50,000");
        strPrizeMoney.put("E", "5,000");
    }

    public Map<String, Integer> getLottoDrawingResult() {
        return lottoDrawingResult;
    }

    public Map<String, Integer> getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }

    public Map<String, String> getStrPrizeMoney() {
        return strPrizeMoney;
    }
}
