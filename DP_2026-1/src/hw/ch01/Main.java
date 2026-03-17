package ch01.A1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240272, 이름: 박정현");


        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("클린코드"));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌"));
        bookShelf.appendBook(new Book("사피엔스"));
        bookShelf.appendBook(new Book("이펙티브 자바"));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해"));
        bookShelf.appendBook(new Book("레미제라블"));
        bookShelf.appendBook(new Book("총균쇠"));
        bookShelf.appendBook(new Book("리팩터링"));
        bookShelf.appendBook(new Book("로마인 이야기"));
        bookShelf.appendBook(new Book("어린왕자"));


        // 명시적으로 Iterator를 사용하는 방법 
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for문을 사용하는 방법
        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}

// client로부터 itorator을 얻어와 일관된 방식으로 책을 출력할 수 있다.
// 다이어그램은 패드에 그려서 올려도 됨
