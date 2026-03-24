package practice.ch03;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    // 큰 틀(흐름, 구조)을 제공함 
    // (추상적으로만 제공 - open, print 몇 번... 이런 것만 알려줌)
    // open, print, close의 구체적인 구현은 하위 클래스에 맡김 
    // = template method 패턴
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
