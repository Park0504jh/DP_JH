package ch04.A2.idcard;

import ch04.A2.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;  // 시리얼 추가

    IDCard(String owner, int serial) {
        // 부모의 인자 없는 생성자 호출함 
        // super(); // 생략 가능
        // 인자 있는 생성자를 호출하고 싶으면,
        // super("x", "y"); 이렇게 명시해줘야 함 (첫 문장에. 나중에 하면 안됨.)
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;  // 시리얼 번호까지 받도록
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "(" + serial + ")]";  // 시리얼 추가
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
