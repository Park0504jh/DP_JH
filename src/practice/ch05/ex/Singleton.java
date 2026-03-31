package practice.ch05.ex;

// 다른 방법의 싱글톤 패턴
public class Singleton {
    private static Singleton singleton = null;  
    // null을 넣음

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown();  // 인스턴스가 생성될 때 시간을 지연시킴
    }

    // getInstance가 호출될 때, 싱글톤이 null이면 인스턴스 하나 생성해서 return
    public static Singleton getInstance() {
        if (singleton == null) {  // 처음 호출되는지 검사
            singleton = new Singleton();
        }
        return singleton;  
        // 처음 호출이 아니면, 위에 singleton = new Singleton(); 실행되지 않고 return만 반복
        // 즉, 새로 인스턴스 생성하지 않음
    }

    private void slowdown() {
        try {
            Thread.sleep(1000);  // Thread.sleep = CPU를 내놓고 쉼 (1000 = 1초)
        } catch (InterruptedException e) {
        }
    }
}
