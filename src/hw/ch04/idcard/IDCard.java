package hw.ch04.idcard;

import hw.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;  // 시리얼 번호 추가
    private String issuedDate;  // 발급 날짜 추가

    // 생성자 수정 (시리얼 번호와 발급 날짜를 매개변수로 받도록)
    public IDCard(String owner, int serial, String issuedDate) {  
        System.out.println(owner + "(" + serial + ")의 카드를 " + issuedDate + "에 만듭니다.");  
        this.owner = owner;
        this.serial = serial;  
        this.issuedDate = issuedDate;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); 
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "(" + serial + ")] - 발급일: " + issuedDate;  // 출력되는 정보 추가
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }

    public String getIssuedDate() {  // getter 메서드 추가
        return issuedDate;
    }
}
