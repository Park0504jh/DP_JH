package hw.ch04.license;

import hw.ch04.framework.Product;

// 운전자명, 면허번호, 발급 날짜, 만료 날짜를 구현한 필드
public class LicenseCard extends Product {
    private String holder;
    private int licenseNumber;
    private String issuedDate;
    private String expiryDate;

    // 메서드
    public LicenseCard(String holder, int licenseNumber, String issuedDate, String expiryDate) {
        System.out.println(holder + "의 운전면허증을 " + licenseNumber + "번으로 만듭니다.");
        this.holder = holder;
        this.licenseNumber = licenseNumber;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public void use() {  // 운전면허증 사용 시 출력되는 메시지
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[LicenseCard:" + holder + "(" + licenseNumber + ")] - 유효기간: " + issuedDate + "~" + expiryDate;
    }
}