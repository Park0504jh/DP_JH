package practice.ch06;

import practice.ch06.MessageBox;

public class Main {
    public static void main(String[] args) {
            MessageBox mbox1 = new MessageBox('*');
            mbox1.use("Hello, world.");

            mbox1.createCopy().use("Hello, world.");
            // mbox1.Clone(); 이렇게 못함 - Clone 메서드는 자기만 호출 가능하기에, createCopy 만들어서 안에서 가져올 수 있게 해야 함
    }
}
