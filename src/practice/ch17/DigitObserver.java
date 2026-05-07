package practice.ch17;

// 관찰자
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {  // 통지받을 때 호출되는 메소드
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);  // 0.1초 대기
        } catch (InterruptedException e) {
        }
    }
}
