package hw.ch03;

public class NumberDisplay extends AbstractDisplay {
    private int number;

    public NumberDisplay(int number, int repeatCount) {
        // 부모 클래스의 생성자를 호출하여 반복 횟수를 설정
        super(repeatCount);
        // number에 값을 할당
        this.number = number;
    }

    @Override
    public void open() {
        // "<<Number>>"를 한 줄에 출력
        System.out.println("<<Number>>");
    }

    @Override
    public void print() {
        // 숫자를 한 줄에 하나씩, number의 값만큼 출력
        System.out.println(number);
    }

    @Override
    public void close() {
        // "<<Number>>"를 한 줄에 출력
        System.out.println("<<Number>>");
    }
}
