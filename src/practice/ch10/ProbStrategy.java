package practice.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0; // 이전에 냈던 패
    private int currentHandValue = 0; // 직전에 냈던 패
    private int[][] history = {  // [][] = 2차원 배열, int = 정수이다
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };  // 초기값 1로 설정하여, 모든 패를 낼 확률이 같도록 한다

    public ProbStrategy(int seed) {
        random = new Random(seed);  // 난수 생성
    }

    @Override
    public Hand nextHand() {  // 전략의 핵심
        int bet = random.nextInt(getSum(currentHandValue));  // 교안에서는 이 값이 15 (0~14)로 나옴
        int handvalue = 0;  // 이번에 낼 손의 값
        if (bet < history[currentHandValue][0]) {  // 첫 번째 영역 (0~3)
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {  // 두 번째 영역 (4~7)
            handvalue = 1;
        } else {  // 세 번째 영역 (8~14)
            handvalue = 2;
        }
        prevHandValue = currentHandValue;  // 이전에 낸 패의 값은 prev에
        currentHandValue = handvalue;  // 이번에 낼 패의 값은 current에
        return Hand.getHand(handvalue);
    }

    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {  // 행 번호는 고정, 열 번호가 0, 1, 2로 바뀜 -> 그 행의 값을 모두 더하는 식
            sum += history[handvalue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {  // 이번의 승패에 따라, 다음에 낼 패의 확률을 조정하는 메소드 (hostory 배열의 값을 조정하는 메소드)
        if (win) {  // 이겼으면
            history[prevHandValue][currentHandValue]++;  // 해당 패의 값을 1 증가시킨다 (이겼으니까, 다음에도 낼 확률을 높이는 것)
        } else {  // 졌으면
            history[prevHandValue][(currentHandValue + 1) % 3]++;  // 나머지 패의 값을 1 증가시킨다 (졌으니까, 다음에는 다른 패를 낼 확률을 높이는 것)
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
