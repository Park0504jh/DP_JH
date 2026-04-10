package hw.ch06;

import hw.ch06.framework.Manager;
import hw.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 준비 
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        BorderLine bline = new BorderLine('=');

        // 등록 
        manager.register("underline", upen);
        manager.register("message", mbox);
        manager.register("border", bline);

        // 생성과 사용: Test 1 
        System.out.println("===== Test 1: Underline Pen =====");
        Product p1 = manager.create("underline");
        p1.use("Welcome");

        // Test 2 
        System.out.println("\n===== Test 2: MessageBox =====");
        Product p2 = manager.create("message");
        p2.use("Welcome");

        // Test 3: BorderLine 
        System.out.println("\n===== Test 3: BorderLine =====");
        Product p3 = manager.create("border");
        p3.use("Welcome");

        // 복사 검증 
        System.out.println("\n===== Clone Test =====");
        Product p3_copy = manager.create("border");
        if (p3 != p3_copy) { // 서로 다른 인스턴스인지 확인
            System.out.println("✓ 정상적으로 복사됨 (서로 다른 인스턴스)");
        } else {
            System.out.println("X 복사 실패");
        }
    }
}