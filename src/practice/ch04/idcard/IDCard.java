package practice.ch04.idcard;

import practice.ch04.framework.Product;  
// 어떤 패키지에 있는 Product 클래스를 상속받는지 명확히 해야 함.

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {  // public으로 선언하여 다른 패키지에서도 접근 가능하도록 함
        System.out.println(owner + "의 카드를 만듭니다.");  // 문자열 + 문자열
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); 
        // System.out.println(this.toString() + "을 사용합니다."); 
        // 객체(this) + 문자열 => toString()이 자동으로 호출됨
    }

    @Override
    // Object 클래스의 toString() 메서드 오버라이드
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
