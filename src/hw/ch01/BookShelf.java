package hw.ch01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books;

    public BookShelf(int initialsize) {
        this.books = new ArrayList<>(initialsize);
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

    // 장르별, 연도별 정보를 얻어오도록 설계 된 두 종류의 iterator을 얻어 오는 메소드 추가
    public Iterator<Book> iteratorByGenre(String genre) {
        return new GenreIterator(this, genre);
    }

    public Iterator<Book> iteratorByYear(String genre) {  
        return new YearDescIterator(this, genre);
    }
}
