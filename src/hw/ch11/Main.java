package hw.ch11;

public class Main {
    public static void main(String[] args) {
    // 1. 디렉토리 생성
    Directory root = new Directory("root");
    Directory bin = new Directory("bin");
    Directory usr = new Directory("usr");
    Directory lib = new Directory("lib");
    Directory home = new Directory("home");
    Directory alice = new Directory("alice");

    // 2. 트리 구조 조립
    root.add(bin);
    root.add(usr);
    root.add(home);

    bin.add(new File("bash", 120));
    bin.add(new File("gcc.exe", 200));

    usr.add(new File("readme.txt", 5));
    usr.add(lib);
    lib.add(new File("libc.so", 800));
    lib.add(new File("libm.so", 150));

    home.add(alice);
    alice.add(new File("note.txt", 10));
    alice.add(new File("lib_memo.txt", 8));
    alice.add(new File("lib_memo.tmp", 20));

    // 3. 과제 요구사항에 따른 검색 테스트
    System.out.println("===== 전체 트리 =====");
    root.printList();

    String[] keywords = {"lib", "exe", "tmp"};
    for (String kw : keywords) {
        System.out.println("\n===== \"" + kw + "\" 검색 결과 =====");
        for (Entry e : root.search(kw)) {
            System.out.println(e.getFullName());
        }
    }
}
}
