package hw.ch01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class YearDescIterator implements Iterator<Book> {
    private List<Book> sorted;
    private int index;

    public YearDescIterator(BookShelf bookShelf, String genre) {  // Bookshelf와 genre 파라미터
        sorted = new ArrayList<>();
        for (int i = 0; i < bookShelf.getLength(); i++) {
            Book b = bookShelf.getBookAt(i);
            if (b.getGenre().equals(genre)) {  // 장르를 필터링할 수 있도록 추가
                sorted.add(b);
            }
        }
        sorted.sort(Comparator.comparingInt(Book::getYear).reversed());
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < sorted.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) throw new NoSuchElementException();
        return sorted.get(index++);
    }
}