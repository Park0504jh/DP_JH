package practice.ch02.delegation;

public class main {
    public static void main(String[] args) {
        Print print = new PrintBannerAdapter02("Hello");  
        // 부모타입 참조변수 print가 자식타입 PrintBannerAdapter02의 인스턴스를 참조할 수 있다 
        // PrintBannerAdapter02 print = new PrintBannerAdapter02("Hello");  
        // 부모타입 불러오지 않고 자식타입으로 바로 참조변수 선언해도 된다  
        print.printWeak();
        print.printStrong();

        // ((PrintBannerAdapter02) print).printYourName();  // 형 변환(타입캐스팅)
    }
}
