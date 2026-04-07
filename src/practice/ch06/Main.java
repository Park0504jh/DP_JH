package practice.ch06;

import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;
import practice.ch06.MessageBox;

public class Main {
    public static void main(String[] args) {
        /* 
            MessageBox mbox1 = new MessageBox('*');
            // 원본(prototype)이 일을 함
            mbox1.use("Hello, world.");

            // 복제된 객체가 일을 함
            mbox1.createCopy().use("Hello, world.");
            // mbox1.Clone(); 이렇게 못함 - Clone 메서드는 자기만 호출 가능하기에, createCopy 만들어서 안에서 가져올 수 있게 해야 함


            UnderlinePen upen1 = new UnderlinePen('~');
            // 원본(prototype)이 일을 함
            upen1.use("Hello, world.");

            // 복제된 객체가 일을 함
            upen1.createCopy().use("Hello, world.");
        */

            // Manager을 이용하는 코드

            // 준비
            Manager manager = new Manager();
            MessageBox mbox1 = new MessageBox('*');
            MessageBox mbox2 = new MessageBox('/');
            UnderlinePen upen1 = new UnderlinePen('+');

            // 등록
            manager.register("star box", mbox1);
            manager.register("plus line", upen1);
            manager.register("slash box", mbox2);

            // 등록된 이름으로 복제품을 얻어서 사용
            Product p1 = manager.create("star box");
            p1.use("Hello, world.");

            Product p2 = manager.create("plus line");
            p2.use("Hello, world.");

            Product p3 = manager.create("slash box");
            p3.use("Hello, world.");

            

    }
}
