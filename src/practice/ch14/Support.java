package practice.ch14;

public abstract class Support {
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳 (support는 부모 타입 -> 모든 종류의 해결자들을 가리킬 수 있다)

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next;  // 인자로 들어온 뒷사람을 반환함
    }

    // 트러블 해결 절차를 결정한다
    public void support(Trouble trouble) {
        if (resolve(trouble)) {  // 내가 해결을 시도
            done(trouble);  // 성공하면 done() 메소드로 해결했다고 출력
        } else if (next != null) {  // 내가 해결 못 하고, 뒷사람이 있으면
            next.support(trouble);  // 뒷사람한테 떠넘김
        } else {  // 내가 해결 못 하고, 뒷사람도 없으면
            fail(trouble);  // 해결 실패라고 출력
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble);  // 자식들이 해결 방법을 구현(결정)

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
