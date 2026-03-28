package hw.ch03;

public class CharDisplay extends AbstractDisplay {
    private char ch; 


    public CharDisplay(char ch) {
        this(ch, 5);
    }

    // CharDisplay도 repeatCount를 받을 수 있도록 생성자 추가
    public CharDisplay(char ch, int repeatCount) {  
        super(repeatCount);
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
