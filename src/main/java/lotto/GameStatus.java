package lotto;

public enum GameStatus {
    MIN_PRICE(1000);

    int value;

    GameStatus(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
