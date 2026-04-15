package practice.ch05;

// 싱글톤 패턴 적용하기
public class Singleton {
    // (3) Singleton 객체를 미리 하나 만들어 둠
    private static Singleton singleton = new Singleton();
    // 반드시 static으로 선언하여 클래스가 메모리에 올라갈 때 singleton 객체도 함께 만들어지도록 함
    // 클래스가 로딩될 때 singleton 객체가 만들어짐

    // (1) 생성자를 private으로 선언하여 외부에서 객체 생성을 못하도록 막는다.
    private Singleton() {
        System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어갈 수 있는 메소드를 정의함
    public static Singleton getInstance() {  // static 메소드로 선언하여 클래스 이름으로 호출할 수 있도록 함
        return singleton;
    }
}


// 이 세가지 방식으로 싱글톤 패턴을 구현할 수 있다. 

// 만약 static이 없다면, 누군가 new Singleton()을 할 때마다 객체가 계속 생기겠죠?
// static을 쓰면 프로그램이 시작되자마자 단 하나의 인스턴스를 미리 만들어 안전하게 보관할 수 있습니다.
// static 필드에 미리 만들어둔 객체는 누가 불러도 항상 똑같은 그 객체입니다.
// static: "객체마다 만들지 말고, 이 클래스에서 공통으로 딱 하나만 관리하자!"라는 선언입니다.
// 한 번 실행되는 이유: 클래스는 메모리에 한 번만 로드되는데, 
// static은 그 '클래스 로딩' 시점에 함께 태어나기 때문입니다.