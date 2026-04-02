package practice.ch05.ex;

public class Main extends Thread {
    public static void main(String[] args) {

        // 스레드 객체 생성
        Main t1 = new Main("Thread-A");  // "Thread-A" 처럼 이름을 주고 싶으면 생성자를 만들어야 함
        Main t2 = new Main("Thread-B");

        // 스레드에 시작하라 지시
        t1.start();  // 스레드가 해야 할 일은 작성한 run() 메소드가 자동으로 실행됨
        t2.start();

    }

    // 스레드가 해야 할 일
    @Override
    public void run() {
        Singleton s = Singleton.getInstance();
        System.out.println(getName() + ": " + s);  // 스레드 이름과 싱글턴 인스턴스의 주소값 출력
    }

    public Main(String name) {
        super(name);  // 부모인 Thread의 생성자를 호출해서 생성자 이름 설정
    }
}
