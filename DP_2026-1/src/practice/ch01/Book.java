package practice.ch01;

public class Book {
    private String name;  //책의 이름 속성으로 선언

    public Book(String name) {
        this.name = name;  //자기속성 속 name에 name을 인자로 넣음
    }

    public String getName() {
        return name;
    }
}
