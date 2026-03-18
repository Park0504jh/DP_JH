package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenreIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private String    targetGenre;  // 장르 필터링을 위한 필드 추가
    private int       index;

    public GenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf   = bookShelf;
        this.targetGenre = genre;  // 장르 필터링을 위한 필드 추가
        this.index       = 0;
        advanceToNext(); // 장르가 일치하는 책이 나올 때까지 전진하게 하는 메서드 호출
    }

    // 현재 index부터 장르가 일치하는 위치까지 전진
    private void advanceToNext() {
        while (index < bookShelf.getLength() &&
        !bookShelf.getBookAt(index).getGenre().equals(targetGenre)) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        if (!hasNext()) throw new NoSuchElementException();
        Book book = bookShelf.getBookAt(index);
        index++;
        advanceToNext(); // 다음 일치 위치로 미리 이동
        return book;
    }
}