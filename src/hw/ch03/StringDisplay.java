package hw.ch03;

public class StringDisplay extends AbstractDisplay {
    private String string;  
    private int width;      

    public StringDisplay(String string) {
        this(string, 5);
    }

    // StringDisplay도 repeatCount를 받을 수 있도록 생성자 추가
    public StringDisplay(String string, int repeatCount) { 
        super(repeatCount);
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }
    
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
