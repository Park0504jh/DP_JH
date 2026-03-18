package practice.ch01;

import java.util.Iterator;

// iterable은 항상 자동으로 import 되어있어 따로 할 필요 없음
public class BookShelf implements Iterable<Book> { 
// public class BookShelf {  
    // 책꽃이가 책을 가지고 있다. 책꽃이 속성으로 책 있음 
    // (책 여러 개라 배열로 관리)
    private Book[] books;  // 배열 선언(생성은 밑에서)
    private int last = 0;
    // 책의 마지막 위치 (아직 책이 안 꽃혀 있으니 0)

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];  // 배열 생성
    }

    public Book getBookAt(int index) {  
        // get = 책을 가져오는 메소드
        return books[index];
    }

    public void appendBook(Book book) { 
        // append = 책을 추가하는 메소드
        this.books[last] = book;  
        // 마지막 위치에 책 넣기
        last++;
        // 마지막 위치 +1 해야 다음 위치에 책 꽃힘
    }

    public int getLength() {  // 현재 책의 개수를 반환하는 메소드
        return last;
    }

    @Override
    public Iterator<Book> iterator() {  // 자기 자신(현재 책꽃이)의 iterator를 생성해서 반환하는 메소드
        return new BookShelfIterator(this);  // this = 현재 책꽃이 객체 자신을 가리킴 (BookShelfIterator의 생성자에서 필요)
    }
}
