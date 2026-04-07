package practice.ch06.framework;

import java.util.HashMap;
import java.util.Map;

// Product를 등록하고, 필요할 때마다 복제해서 제공하는 클래스
public class Manager {
    // Product: 부모 타입 (에서 생성/구현한 객체를 모두 관리하겠다(underlinePen, MassageBox))
    private Map<String,Product> showcase = new HashMap<>();  // (key, value) 쌍으로 제공하는 HashMap

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);  // key:name, value: prototype 넣기
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);  // key 입력하여 value 꺼내오기
        return p.createCopy();  // 복제해서 반환 (원본 반환하지 x)
    }
}
