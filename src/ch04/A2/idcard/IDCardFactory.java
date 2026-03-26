package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100;  // 시리얼 번호 초기값
    // 정수 기본 데이터 타입
    private final Map<Integer, String> database = new HashMap<>(); // 시리얼-이름 쌍 관리
    // 정수 객체 데이터 타입

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
        // 시리얼 번호를 증가시키면서 IDCard 생성
    }

    @Override
    protected void registerProduct(Product product) {
        if (product instanceof IDCard) {
            IDCard idCard = (IDCard) product;
            database.put(idCard.getSerial(), idCard.getOwner());
            // serial을 키로, owner를 값으로 저장
        }
        System.out.println(product + "을 등록했습니다.");
    }

    // 등록된 카드 시리얼-소유자 쌍을 읽기 전용으로 반환
    public Map<Integer, String> getDatabase() {
        return Collections.unmodifiableMap(database);
    }
}
