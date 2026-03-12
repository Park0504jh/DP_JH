package practice.ch01;

import java.util.Iterator;  // java.util 패키지의 Iterator 인터페이스를 사용하기 위해 import
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;  // 책꽃이 객체를 참조하는 변수 (책꽃이의 책들을 순회하기 위해 필요)
    private int index;  // 현재 순회 중인 책의 인덱스를 나타내는 변수 

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;  // 생성자에서 책꽃이 객체를 받아서 초기화
        this.index = 0;  // 순회 시작 시 인덱스는 0으로 초기화 (첫 번째 책부터 시작)
    }

    @Override  // 부모가 가지고 있는 메소드를 자식 클래스에서 재정의할 때 사용 (부모쪽에 있는 걸 구현한 거다~)
    public boolean hasNext() {  // 책꽃이에서 꺼내올 다음 책이 있는지 확인하는 메소드
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {  // 책꽃이에서 다음 책을 꺼내오는 메소드
        if (!hasNext()) {
            throw new NoSuchElementException();  // 더 이상 꺼내올 책이 없을 때 예외를 던짐
        }
        Book book = bookShelf.getBookAt(index);  // 책꽃이에서 현재 위치의 책을 가져옴
        index++;
        return book;
    }
}

// hasNext와 next 메소드를 구현하여 책꽃이의 책들을 순회할 수 있도록 함 
// (둘이 함께 사용됨. 반드시 둘 다 구현해야 함)
