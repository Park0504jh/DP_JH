package hw.ch02;

public class Main {
    public static void main(String[] args) {
        KoreanOutlet koreanOutlet = new KoreanOutlet();

        Charger charger = new KoreanOutletAdapter(koreanOutlet);  // 어댑터 생성

        Smartphone smartphone = new Smartphone(charger);  // Smartphone에 전달
        smartphone.charge();  // charge() 호출
    }
}
