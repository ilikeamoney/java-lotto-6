package lotto;

import java.util.List;

public class Item {
    private static List<List<Integer>> challengeTicket;

    private static List<Integer> winnerTicket;

    private static Integer bonusNumber;

    // protected current instance
    private Item() {

    }

    public static void setChallengeTicket(List<List<Integer>> cTicket) {
        challengeTicket = cTicket;
    }

    public static void setWinnerTicket(List<Integer> wTicket) {
        winnerTicket = wTicket;
    }

    public static void setBonusNumber(Integer bNum) {
        bonusNumber = bNum;
    }

    public static List<List<Integer>> getChallengeTicket() {
        return challengeTicket;
    }

    public static List<Integer> getWinnerTicket() {
        return winnerTicket;
    }

    public static Integer getBonusNumber() {
        return bonusNumber;
    }

}
