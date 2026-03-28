package hw.ch04.idcard;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class IDCardFactory extends Factory {
    private int serialCounter = 100; // 시리얼 번호 시작값
    private String baseDate;
    
    // 생성자 추가
    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
        protected IDCard createProduct(String owner) { 
            return new IDCard(owner, serialCounter++, baseDate);
        }

    @Override
    protected void registerProduct(Product product) {  
        System.out.println(product + "을 등록했습니다.");
    }
}
