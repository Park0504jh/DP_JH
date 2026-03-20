package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240272, 이름: 박정현");


        // 책 데이터 수정
        BookShelf bookShelf = new BookShelf(10);
        bookShelf.appendBook(new Book("클린코드", "기술", 2008, 30000));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000));
        bookShelf.appendBook(new Book("사피엔스", "역사", 2011, 18000));
        bookShelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해","기술", 2015, 20000));
        bookShelf.appendBook(new Book("레미제라블", "소설", 1862, 12000));
        bookShelf.appendBook(new Book("총균쇠", "역사", 1997, 22000));
        bookShelf.appendBook(new Book("리팩터링", "기술", 2018, 34000));
        bookShelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000));
        bookShelf.appendBook(new Book("어린왕자", "소설", 1943, 9000));


        // 장르 필터 Iterator 실행 코드
        /* 
        System.out.println("=== 소설 장르 ===");
        Iterator<Book> genreIt = bookShelf.iteratorByGenre("소설");
        while (genreIt.hasNext()) {
            Book b = genreIt.next();
            System.out.printf("제목: %s / 장르: %s / 출판연도: %d / 가격: %.0f원%n",
                    b.getName(), b.getGenre(), b.getYear(), b.getPrice());
        }
*/
        // 출판연도 역순 Iterator 실행 코드
        
        System.out.println("\n=== 출판연도 역순 ===");
        Iterator<Book> yearIt = bookShelf.iteratorByYear("소설");
        while (yearIt.hasNext()) {
            Book b = yearIt.next();
            System.out.printf("제목: %s / 장르: %s / 출판연도: %d / 가격: %.0f원%n",
                    b.getName(), b.getGenre(), b.getYear(), b.getPrice());
        } 

/* 
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
        */
    }
}
