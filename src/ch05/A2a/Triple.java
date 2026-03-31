package ch05.A2a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    private static Map<String,Triple> map = new HashMap<>();  // Triple 객체 3개를 저장할 Map
    static {  // static 블록은 클래스가 처음 로드될 때 한 번 실행되는 블록입니다.
        // names = 스트링 배열
        String[] names = { "ALPHA", "BETA", "GAMMA" };
        // stram() = names 배열의 요소들을 하나씩 꺼내서 stream으로 만들어 줌 
        // forEach() = stream으로 만들어진 요소들을 하나씩 꺼내서 람다식에 전달하여 실행/처리
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s)));
        // <키,값> 쌍으로 Triple 객체를 생성하여 map에 저장
    }

    private String name;

    private Triple(String name) {
        System.out.println("The instance " + name + " is created.");
        this.name = name;
    }

    public static Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
