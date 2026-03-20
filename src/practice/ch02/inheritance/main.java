package practice.ch02.inheritance;

public class main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello");
        banner.showWithParen();
        banner.showWithAster();

        // 어댑터 이용
        System.out.println("어댑터 이용");
        Print print = new PrintBannerAdater01("Hello");  
        // 여기에 hello를 넣었기 때문에 adapter에 생성자를 받는 부분이 있어야 한다.
        print.printWeak();
        print.printStrong();

    }
}
