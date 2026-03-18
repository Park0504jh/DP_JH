package practice.ch02.inheritance;

// 클라이언트가 원하는 인터페이스를 구현한 클래스
public class PrintBannerAdater01 extends Banner implements Print {
// extends Banner = Banner 클래스의 모든 기능을 상속받는다.
    @Override
    public void printWeak() {
        showWithParen();  // 항상 객체.메소드() 형태로 호출해야 한다.
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
