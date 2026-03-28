package hw.ch03;

public abstract class AbstractDisplay {
    private int repeatCount;

    public AbstractDisplay() {
        this(5);  // 기본값 5
    }

    public AbstractDisplay(int repeatCount) {  // repeatCount - 반복 횟수를 지정할 수 있도록 생성자 추가
        this.repeatCount = repeatCount;
    }

    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < repeatCount; i++) {
            print();
        }
        close();
    }
}
