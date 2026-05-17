package hw.ch17;


public class Main {
    public static void main(String[] args) {
        // 1. 관찰 대상 객체 생성
        NumberGenerator generator = new EvenNumberGenerator(0, 30);
        
        // 2. 세 종류의 관찰자 객체 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new RangeObserver(); 
        
        // 3. 관찰 대상에 관찰자들을 등록 
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);
        
        // 4. 수 생성 및 통보 프로세스 시작
        generator.execute();
    }
}