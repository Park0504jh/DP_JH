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

/*
Print print
특징: Print라는 이름의 **리모컨(참조 변수)**을 준비합니다. 이 리모컨에는 Print 클래스에 정의된 버튼(printWeak, printStrong)만 있습니다.
장점: 만약 나중에 PrintBannerAdapter02 말고 더 성능이 좋은 NewPrintAdapter로 바꾸고 싶다면, 뒷부분만 살짝 수정하면 됩니다. 앞의 리모컨(Print print)을 사용하는 코드들은 하나도 고칠 필요가 없죠.

PrintBannerAdapter02 print
특징: Print에 있는 기능뿐만 아니라, 자식 클래스(PrintBannerAdapter02)에만 따로 추가한 특별한 기능(예: printYourName 등)까지 모두 사용할 수 있습니다.
단점: 나중에 다른 어댑터 클래스로 바꾸고 싶을 때, 이 변수를 사용하는 모든 코드를 일일이 찾아가서 타입을 수정해야 하므로 유연성이 떨어집니다.
*/

