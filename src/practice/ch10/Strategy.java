package practice.ch10;

public interface Strategy {
    public abstract Hand nextHand();  // 다음에 내밀 손을 얻기 위해 호출하는 메소드
    public abstract void study(boolean win);
}
