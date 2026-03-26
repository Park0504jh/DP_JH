package ch04.A2;

import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;
import ch04.A2.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        IDCardFactory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heungmin Son");
        Product card3 = factory.create("Kane");

        card1.use();
        card2.use();
        card3.use();

        System.out.println("---등록된 시리얼-소유자 쌍---");
        factory.getDatabase().forEach((serial, owner) ->
            System.out.println("Serial=" + serial + ", Owner=" + owner));

        int lookupSerial = 100;
        String owner = factory.getDatabase().get(lookupSerial);
        if (owner != null) {
            System.out.println("Serial " + lookupSerial + "의 오너는 " + owner + "입니다.");
        } else {
            System.out.println("Serial " + lookupSerial + "에 해당하는 오너가 없습니다.");
        }
    }
}
