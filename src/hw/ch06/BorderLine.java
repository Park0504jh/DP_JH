package hw.ch06;

import hw.ch06.framework.Product;

public class BorderLine implements Product{
    private char borderChar;

    // 경계 문자를 인자로 받음 
    public BorderLine(char borderChar) {
        this.borderChar = borderChar;
    }

    @Override
    public void use(String s) {
        int len = s.length(); // 텍스트 길이에 맞춤 

        // 위쪽 라인 출력 
        for (int i = 0; i < len; i++) {
            System.out.print(borderChar);
        }
        System.out.println();

        // 본문 출력 
        System.out.println(s);

        // 아래쪽 라인 출력 
        for (int i = 0; i < len; i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

    // createCopy() 메소드 구현 (clone() 활용) 
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}