package ch06.A1a.framework;

// abstract(추상으로 바뀜)
public abstract class Product implements Cloneable {
    public abstract void use(String s);

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
