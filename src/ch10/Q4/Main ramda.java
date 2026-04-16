package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서 (오름차순)
        list.sort((s1, s2) -> s1.compareTo(s2)); // 람다식
        System.out.println(list);
        
        
        // 사전순으로 큰 순서 (내림차순)
        list.sort((s1, s2) -> s2.compareTo(s1)); // 람다식
        System.out.println(list);
    }
}
