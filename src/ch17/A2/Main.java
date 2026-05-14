package ch17.A2;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();

        // 관찰자 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new FrameObserver();  // 새로운 관찰자 추가
 
        // 관찰자 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);

        // 수를 생성한다
        generator.execute();
    }
}
