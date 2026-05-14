package practice.ch17;

// 관찰자
public class DigitObserver implements Observer {
    @Override
    // 구체적으로 어떤 NumberGenerator가 통지하는지 모름
    // 그저 NumberGenerator 중 하나가 통지하고 있다는 사실만 알고 있음
    // getNumber() 메소드로 상태를 얻어가기만 할 수 있음
    public void update(NumberGenerator generator) {  // 통지받을 때 호출되는 메소드
        System.out.println("DigitObserver:" + generator.getNumber()); // 현재 상태를 얻어가는 메소드
        try {
            Thread.sleep(100);  // 0.1초 대기
        } catch (InterruptedException e) {
        }
    }
}
