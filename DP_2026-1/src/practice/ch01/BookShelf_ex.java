package practice.ch01;

import java.util.ArrayList;  // 인터페이스
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books;

    // 사전에 배열 선언할 필요 없이 ArrayList로 바로 생성

    public BookShelf(int initialsize) {  // maxsize 대신 initialsize로 변경 (ArrayList는 크기 제한X)
        this.books = new ArrayList<>(initialsize);  // 크기가 자동으로 늘어나는 ArrayList 생성 
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
