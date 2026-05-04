package hw.ch11;

// search 결과인 List를 사용하기 위해 임포트 추가
import java.util.List;

public abstract class Entry {
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        printList("");
    }



    public abstract List<Entry> search(String keyword);



    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    public String getFullName() {
        StringBuilder fullname = new StringBuilder(); 
        Entry entry = this;
        do {
            fullname.insert(0, entry.getName());  
            fullname.insert(0, "/");  
            entry = entry.parent;  
        } while (entry != null); 
        return fullname.toString();
    }
}
