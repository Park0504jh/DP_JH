package hw.ch11;

// [수정] 검색 결과를 리스트로 반환하기 위해 임포트 추가
import java.util.ArrayList;
import java.util.List;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);

    }


    @Override
    public List<Entry> search(String keyword) {
        List<Entry> result = new ArrayList<>();
        
        // 1. 자신의 이름에 키워드가 포함되어 있는지 확인
        if (getName().contains(keyword)) {
            // 2. 포함되어 있다면 결과 리스트에 자기 자신(this)을 추가
            result.add(this);
        }
        
        // 3. 결과 리스트 반환 (포함 안 되면 빈 리스트 반환)
        return result;
        

    }
}
