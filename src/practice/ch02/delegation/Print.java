package practice.ch02.delegation;

// 클라이언트가 원하는 인터페이스 (추상 클래스) - 01에서는 인터페이스라 상속이 가능했지만, 02에서는 추상이라 안됨 -> 위임
public abstract class Print {
    public abstract void printWeak();
    public abstract void printStrong();
}
