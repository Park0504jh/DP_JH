package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        entry.setParent(this);  // 자식 엔트리에게 부모(현재 디렉토리)를 설정
        return this;
    }


    
    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();

        // 1. 디렉토리 자신의 이름에 키워드가 있는지 검사
        if (getName().contains(keyword)) {
            result.add(this);
        }

        // 2. 재귀 구조로 자식 엔트리들을 탐색
        for (Entry entry : directory) {
            // 3. 각 자식의 search()를 호출하여 결과를 받아옴
            List<Entry> childResult = entry.search(keyword);
            
            // 4. 자식들이 찾아온 결과 리스트를 현재 결과 리스트에 병합 (addAll)
            result.addAll(childResult);
        }

        return result;
    }


}
