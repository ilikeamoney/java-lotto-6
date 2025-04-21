package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoGame implements Game{
    private final Machine machine = LottoMachine.getMachine();

    private final LotteryDrawing lotteryDrawing = LotteryDrawing.getInstance();

    private static LottoGame instance;

    private LottoGame() {

    }

    // TODO 로또 티켓 당첨 확인하기
    @Override
    public void play() {
        try {
            init();
            List<List<Integer>> cTicket = Item.getChallengeTicket();
            List<Integer> wTicket = Item.getWinnerTicket();
            Integer bNum = Item.getBonusNumber();

            lotteryDrawing.lottoDrawing(cTicket, wTicket, bNum);

            Map<String, Integer> lottoDrawingResult = lotteryDrawing.getLottoDrawingResult();
            Map<String, Integer> lottoPrizeMoney = lotteryDrawing.getLottoPrizeMoney();
            Map<String, String> strPrizeMoney = lotteryDrawing.getStrPrizeMoney();

            PrintGameState.printLottoResult(lottoDrawingResult, lottoPrizeMoney, strPrizeMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void test() {
        int[][] cArr = {
                {8, 21, 23, 41, 42, 43},
                {3, 5, 11, 16, 32, 38},
                {7, 11, 16, 35, 36, 44},
                {1, 8, 11, 31, 41, 42},
                {13, 14, 16, 38, 42, 45},
                {7, 11, 30, 40, 42, 43},
                {2, 13, 22, 32, 38, 45},
                {1, 3, 5, 14, 22, 45},
        };
        int[] wArr = {1, 2, 3, 4, 5, 6};
        int bNum = 7;
        Lotto.setUseMoney(8000);
        List<List<Integer>> cTicket = new ArrayList<>();
        List<Integer> wTicket = new ArrayList<>();

        for (int i = 0; i < cArr.length; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < cArr[i].length; j++) {
                a.add(cArr[i][j]);
            }
            cTicket.add(a);
        }

        for (int i = 0; i < wArr.length; i++) {
            wTicket.add(wArr[i]);
        }

        lotteryDrawing.lottoDrawing(cTicket, wTicket, bNum);

        Map<String, Integer> lottoDrawingResult = lotteryDrawing.getLottoDrawingResult();
        Map<String, Integer> lottoPrizeMoney = lotteryDrawing.getLottoPrizeMoney();
        Map<String, String> strPrizeMoney = lotteryDrawing.getStrPrizeMoney();

        PrintGameState.printLottoResult(lottoDrawingResult, lottoPrizeMoney, strPrizeMoney);
    }

    private void init() {
        machine.operating();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new LottoGame();
            return instance;
        }

        return instance;
    }
}
