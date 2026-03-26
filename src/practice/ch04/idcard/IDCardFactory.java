package practice.ch04.idcard;

import practice.ch04.framework.Factory;  
import practice.ch04.framework.Product;  

public class IDCardFactory extends Factory {
    @Override
    // 부모 타입은 자식 객체를 참조할 수 있음
    //  때문에 return 타입이 Product여도 괜찮음 
    // (Factory의 createProduct() 메서드가 Product 타입을 반환하도록 선언되어 있기 때문)
    // 그러나 부모 객체는 자식 타입이 참조할 수 없다
    protected IDCard createProduct(String owner) {  // 실제 신분증 생성해서 return
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {  // 실제 신분증 등록해서 print
        System.out.println(product + "을 등록했습니다.");
        // product.toString()이 자동으로 호출됨 (생략된 것)
    }
}
