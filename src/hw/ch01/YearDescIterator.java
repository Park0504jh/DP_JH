package hw.ch01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class YearDescIterator implements Iterator<Book> {
    private List<Book> sorted;
    private int        index;

    public YearDescIterator(BookShelf bookShelf) {
        sorted = new ArrayList<>();
        for (int i = 0; i < bookShelf.getLength(); i++) {
            sorted.add(bookShelf.getBookAt(i));
        }
        // 출판연도 내림차순 정렬 (최신 → 오래된 순)
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