package hw.ch10;

public class CyclicStrategy implements Strategy {
    private int lastHandValue = -1;

    @Override
    public Hand nextHand() {
        // (이전 값 + 1)을 3으로 나눈 나머지를 사용하여 0 -> 1 -> 2 순환 구현
        lastHandValue = (lastHandValue + 1) % 3;
        return Hand.getHand(lastHandValue);
    }

    @Override
    public void study(boolean win) {

    }
}