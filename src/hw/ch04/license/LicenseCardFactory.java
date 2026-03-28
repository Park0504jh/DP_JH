package hw.ch04.license;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseCardFactory extends Factory {
    private int licenseCounter = 100;  // 100부터 시작하는 면허번호 카운터
    private String baseDate;  // 발급 기준 날짜

    // 생성자 메서드
    public LicenseCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }
    
    @Override
    protected Product createProduct(String holder) {   // LicenseCard 생성 
        // 1. "2026-03-20"에서 앞 4자리 "2026"만 추출
        String yearStr = baseDate.substring(0, 4); 
    
        // 2. 문자열을 숫자로 변환하여 5를 더함
        int year = Integer.parseInt(yearStr);
        int expiryYear = year + 5;
    
        // 3. 다시 나머지 날짜("-03-20")와 합침
        // "2031" + "-03-20" => "2031-03-20"
        String expiryDate = expiryYear + baseDate.substring(4);
    
        return new LicenseCard(holder, licenseCounter++, baseDate, expiryDate);
        // holder: 운전자 이름, licenseCounter++: 면허 번호. 1씩 증가, baseDate: 발급 날짜, expiryDate: 만료 날짜

    }

    @Override
    protected void registerProduct(Product product) {  // 등록 메시지 출력
        System.out.println(product + "을 등록했습니다.");
    }
}