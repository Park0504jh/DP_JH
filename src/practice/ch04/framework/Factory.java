package practice.ch04.framework;

public abstract class Factory {
    // 템플릿 메소드 
    // 제품 생산하는 방식을 정의하는 메소드
    public final Product create(String owner) {  // 생산 호출 
        Product p = createProduct(owner);  // 실제 제품 생산
        // product로 받기 때문에 자식이 idcard나 이 외... 로 만들어져도 문제 없음 
        // (부모 타입은 자식 객체 참조 가능)
        registerProduct(p);  // 생산된 제품을 등록
        return p;
    }

    // 팩토리 메소드 - 서브 클래스에서 구체적인 제품을 생성하는 메소드(추상)
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
