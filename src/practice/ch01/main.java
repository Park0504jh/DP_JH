package practice.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // 책 테스트
        Book book = new Book(name: "Java Programming");
        System.out.println("Book name: "+ book.getName());

        // 책장 테스트
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book(name: "Java Programming"));  // 첵 데이터 추가
        bookShelf.appendBook(new Book(name: "Design Patterns"));
        bookShelf.appendBook(new Book(name: "Effective Java"));

        // 책장에 있는 책 출력

        // 방법1 : 클라이언트가 책꽃이에 직접 접근하여 책을 가져오는 방법
        for (int i=0; 1 < bookShelf.getLength(); i++) {
            System.out.println ("Book" + (i+1) + ":" + bookShelf.getBookAt(i).getName());
        }

        // 방법2 : Iterator를 통해서 책꽃이의 책을 가져오는 방법
        // itorator을 얻어옴
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            System.out.println("Book: " + it.next().getName()); // it.next()는 다음 책을 가져오는 메소드
        }

        // 방법3 : 확장 for문을 통해서 책꽃이의 책을 가져오는 방법
        for (Book b : bookShelf) {  // 형식: for (요소타입 변수명 : 컬렉션) { ... }
            System.out.println("Book: " + b.getName());
        }
    }
    }