package ch11.A2;

public abstract class Entry {
    private Entry parent;

    // 부모를 설정한다
    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    // 이름을 가져온다 
    public abstract String getName();

    // 크기를 가져온다 
    public abstract int getSize();

    // 목록을 표시한다 
    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여 목록을 표시한다
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }

    // 전체 경로를 가져온다 
    public String getFullName() {
        StringBuilder fullname = new StringBuilder();  // 전체 경로 변수 fullname
        Entry entry = this;
        do {
            fullname.insert(0, entry.getName());  // 0번 인덱스에 현재 엔트리의 이름을 삽입
            fullname.insert(0, "/");  // 0번 인덱스에 "/"를 삽입하여 경로 구분자 추가
            entry = entry.parent;  // 부모로 이동 (트리의 윗 방향으로 이동)
        } while (entry != null);  // 루트 디렉터리에 도달할 때까지 반복
        return fullname.toString();
    }
}
