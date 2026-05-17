package hw.ch17;

public class EvenNumberGenerator extends NumberGenerator {
    private int number; // 현재 생성된 수
    private int end;    // 종료값 (이 값은 포함하지 않음)

    public EvenNumberGenerator(int start, int end) {
        // 시작값이 짝수이도록
        if (start % 2 != 0) {
            throw new IllegalArgumentException("시작값은 반드시 짝수여야 합니다.");
        }
        this.number = start;
        this.end = end;
    }

    // 현재 값을 외부(Observer)에서 취득할 수 있도록 상속
    @Override
    public int getNumber() {
        return number;
    }

    // 루프를 돌며 짝수를 생성하고 통보
    @Override
    public void execute() {
        // 현재 수가 end 미만인 동안 반복 수행
        while (number < end) {
            // 현재 등록된 모든 관찰자에게 값이 변경되었음을 알림
            notifyObservers();
            // 증가폭은 항상 2로 고정하여 짝수만 생성되도록 함
            number += 2;
        }
    }
}