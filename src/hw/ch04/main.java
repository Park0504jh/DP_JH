package hw.ch04;

// IDCard와 main이 다른 패키지에 있기 때문에 import 필요
import hw.ch04.framework.Factory;
import hw.ch04.idcard.IDCardFactory;
import hw.ch04.framework.Product;
import hw.ch04.license.LicenseCardFactory;  // 라이센스 카드 팩토리 추가

public class main {
    public static void main(String[] args) {

        // [3-1] Step 1 테스트: IDCard 정보 확장
        System.out.println("=== IDCard 테스트 ===");
        Factory factory1 = new IDCardFactory("2026-01-15");
        Product card1 = factory1.create("Kim Youngjin");
        Product card2 = factory1.create("Son Heungmin");
        card1.use();
        card2.use();

        System.out.println();

        // [3-2] Step 2 테스트: 새로운 카드 타입
        //System.out.println("=== LicenseCard 테스트 ===");
        //Factory factory2 = new LicenseCardFactory("2026-03-20");
        //Product license1 = factory2.create("Park Jisung");
        //Product license2 = factory2.create("Lee Min-jae");
        //license1.use();
        //license2.use();
    }
}
