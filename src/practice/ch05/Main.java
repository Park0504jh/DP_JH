package practice.ch05;

public class Main {
    public static void main(String[] args) {
        //Singleton s1 = new Singleton();  // 컴파일 에러: Singleton() has private access in Singleton
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        if (s2 == s3) {
            System.out.println("s2와 s3는 같은 Singleton 객체입니다.");
        } else {
            System.out.println("s2와 s3는 다른 Singleton 객체입니다.");
        }

        System.out.println("s2의 값: " + s2);
        System.out.println("s3의 값: " + s3);

        // Singletone2 사용하기
        Singletone2 s4 = Singletone2.INSTANCE;  // Singletone2 객체 얻기
        s4.hello();  // Singletone2 객체의 메소드 호출
    }
}
