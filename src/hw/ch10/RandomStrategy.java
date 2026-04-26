package hw.ch10;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(boolean win) {
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));  // random하게 0~2까지의 숫자 중 하나를 반환
    }
}
