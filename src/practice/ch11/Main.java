package practice.ch11;

public class Main {
    public static void main(String[] args) {
        // 디렉터리 트리를 만든다

        Entry root = new Directory("root");  // 업캐스팅(자동으로 일어나므로 신경쓸 필요 없음)
        // 부모 타입으로 선언하면 자식 사용 가능
        // 근데 이러면 Entry에 add() 메소드가 없어서 add() 메소드를 사용할 수 없다.
        // -> 형변환! 
        ((Directory) root).add(bin);  // 다운캐스팅(명시적으로 해야 한다)
        // . 이 타입 캐스팅보다 우선 순위가 높다
        // 그러므로 괄호로 묶어줘야 한다


        // Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin);
        root.add(tmp); 
        root.add(usr);

        // 파일 생성 및 추가
        bin.add(new File("vi", 10000));
        bin.add(new File("latex", 20000));

        // 디렉터리 리스트 출력
        root.printList();
    }
}
