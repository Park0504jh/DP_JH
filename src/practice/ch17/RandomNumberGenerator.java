package practice.ch17;

import java.util.Random;

// 구체적으로 자신을 누가 관찰하고 있는지 모름
// 그저 Observer 중 하나가 자신을 관찰하고 있다는 사실만 알고 있음
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);  // 0부터 49까지의 난수 생성
            notifyObservers();  // 관찰자(Observers)들에게 통지한다
        }
    }
}
