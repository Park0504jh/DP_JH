package ch03.A4;

public interface AbstractDisplay {  // interface로 정의
    public void open();
    public void print();
    public void close();

    public default void display() {  // default 키워드로 display() 메소드 구현
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
