package practice.ch04;

// IDCard와 main이 다른 패키지에 있기 때문에 import 필요
import practice.ch04.idcard.IDCard;
import practice.ch04.idcard.IDCardFactory;
import practice.ch04.framework.Product;

public class main {
    public static void main(String[] args) {
        // (1) IDCard를 직접 생성 (직접 new 해서 생성)
        // IDCard c1 = new IDCard("JH");
        // c1.use();


        // (2) 공장을 통해서 IDCard를 생성 (IDCardFactory 사용)
        IDCardFactory factory = new IDCardFactory();  
        Product c2 = factory.create("JH");  // factory에서 return된 건 product 타입이라 Product로 받아야 함 (IDCard로 받으면 에러)
        c2.use();

    }
}
