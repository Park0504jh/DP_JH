package practice.ch02.inheritance;

// 클라이언트가 원하는 인터페이스를 구현한 클래스
public class PrintBannerAdater01 extends Banner implements Print {
// (1) 인자 없는 생성자는 자동으로 생성됨
// (2) 생성자는 상속되지 않음
// 때문에 PrintBannerAdapter01 에 생성자가 없으며, 
// 이를 해결하기 위해 Banner의 생성자를 호출하는 생성자를 만들어야 한다.

    public PrintBannerAdater01(String string) {
        super(string);  // Banner의 생성자 호출 
        // super()는 부모 클래스의 생성자를 호출하는 키워드
        // banner에서 부모 생성자를 호출하여 이곳에서 받은 string을 부모 클래스에 전달한다.
    }

    @Override
    public void printWeak() {
        showWithParen();  // banner.showWithParen() -> this.showWithParen() -> showWithParen()
    }

    @Override
    public void printStrong() {
        showWithAster();  
    }
}
