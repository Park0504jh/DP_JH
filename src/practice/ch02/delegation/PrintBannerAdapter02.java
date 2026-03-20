package practice.ch02.delegation;

public class PrintBannerAdapter02 extends Print {  
    // 추상 클래스는 implements가 아니라 extends로 상속받아야 한다
    // 자바에서는 다중 상속이 붋가능함 (부모가 둘 이상은 허용이 안됨) 
    // -> banner는 이미 다른 클래스의 자식이므로 상속받을 수 없다
    // -> delegation으로 해결하자 (위임)

    private Banner banner;  // Banner 클래스의 인스턴스를 참조하는 필드 

    public PrintBannerAdapter02(String text) {
        this.banner = new Banner(text);  // Banner 클래스의 인스턴스를 생성하여 필드에 할당
    }

    @Override
    public void printWeak() {
        banner.showWithParen();  // Banner 클래스의 메서드를 호출하여 기능 수행(위임)
    }

    @Override
    public void printStrong() {
        banner.showWithAster();  // Banner 클래스의 메서드를 호출하여 기능 수행(위임)
    }

    /* 문제 2-1 
    public void printYourName() {
        System.out.println("My name is PrintBannerAdapter02");
    } */

}