package hw.ch20;

public class Main {

    // ANSI 색상 코드 정의
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);

        // 각 문자에 대응하는 색상 배열 생성
        String[] colors = {
                RED,       // 1
                BLUE,      // 2
                GREEN,     // 1
                MAGENTA,   // 2
                CYAN,      // 1
                YELLOW,    // 2
                BLUE       // 3
        };

        // 색상 배열을 전달하여 출력
        bs.print(colors);
    }
}