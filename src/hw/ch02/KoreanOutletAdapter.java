package hw.ch02;


// 어댑터는 KoreanOutlet을 상속받으면서, Charger 인터페이스도 구현하여, 클라이언트가 원하는 인터페이스를 제공한다.
public class KoreanOutletAdapter implements Charger{

    private KoreanOutlet koreanOutlet;  // 어댑터는 KoreanOutlet을 가지고 있다. (위임용 필드)

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }
    
    @Override
    public int charge() {
        return koreanOutlet.provide();  
        // Charger 인터페이스의 charge() 메서드는 KoreanOutlet의 provide() 메서드를 호출하여 220V AC를 제공한다.
    }

}