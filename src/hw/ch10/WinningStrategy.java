package hw.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;  // 난수를 발생시키는 객체
    private boolean won = false;  // 없애도 항상 false로 초기화 된다
    private Hand prevHand;  // 이전에 낸 손

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        // Random rnadom (이건 초기화되지 않음)
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
