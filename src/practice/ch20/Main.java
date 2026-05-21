package practice.ch20;

public class Main {
    public static void main(String[] args) {
        BigChar char1 = new BigChar('1');
        char1.print();

        // BigCharFactory를 이용
        BigCharFactory factory = BigCharFactory.getInstance();
        BigChar char2 = factory.getBigChar('2');
        char2.print();
    }
}