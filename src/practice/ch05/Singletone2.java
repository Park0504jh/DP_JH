package practice.ch05;

public enum Singletone2 {
    // 상수
    INSTANCE; // 클래스 로드 시 싱글톤 객체를 하나 만들어 둠
    // private static Singleton singleton = new Singleton(); 를 자동으로 만들어 줌

    // 메소드
    public void hello() {
        System.out.println("싱글톤 객체에 hello() 메소드가 호출되었습니다.");
    }
}
