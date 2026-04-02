package practice.ch06.framework;

public interface Product extends Cloneable {  
//public interface Product {  
    // 이렇게 Cloneable을 안 하면 MessageBox에 p = (Product)clone(); 부분에서 오류 발생
    public abstract void use(String s);
    public abstract Product createCopy();  // 복제 메서드
    // 인터페이스끼리는 상속 가능 -> Cloneable이라는 인터페이스 상속함
}
