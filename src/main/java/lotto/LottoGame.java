package lotto;

public class LottoGame implements Game{

    private final Machine machine = LottoMachine.getMachine();

    @Override
    public void play() {

    }

    @Override
    public void test() {

    }

    private void init() {
        machine.operating();
    }
}
