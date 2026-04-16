package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();
    // 자식들을 보관하는 List, directory
    // Entry : 부모 타입 (Directory와 File의 모두 담을 수 있음)

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {  // 모든 자식의 크기를 더해서 반환한다.
        int size = 0;
        for (Entry entry: directory) {  // 형식 - (원소 변수 : 컬렉션)
            size += entry.getSize();  // 재귀적 호출 
            // (꺼내온 애가 폴더이면, 그 폴더의 자식들의 크기를 더해서 반환한다.)
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {  // 이 디렉터리의 이전 경로
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);  // 이 폴더까지 포함한 경로 (이전 + 현재 폴더 이름) 을 넘겨준다.
        // 재귀적 호출 (꺼내온 애가 폴더이면, 그 폴더의 자식들의 이름을 출력한다.)
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
