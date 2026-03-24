package practice.ch03;

public class Main {
    public static void main(String[] args) {
        // CharDisplay d1 = new CharDisplay('H');  // '' 캐릭터 타입, " " 문자열 타입
        AbstractDisplay d1 = new CharDisplay('H');
        // 부모 타입으로 선언을 해도, 자식 클래스 호출 가능
        d1.display();

        // StringDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        d2.display();
    }
}
