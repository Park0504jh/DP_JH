package hw.ch01;

public class Book {
    private String name;

    // 요구사항 : 필드 추가
    private String genre;
    private int year;
    private double price;

    // 기존 Book 생성자 유지 (Main.java 수정 없이 컴파일 가능하도록)
    public Book(String name) {
        this.name = name;
        this.genre = "";
        this.year  = 0;
        this.price = 0.0;
    }

    // 새 필드를 받는 생성자 오버로딩 생성자 추가
    public Book(String name, String genre, int year, double price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    // getter 구현 (setter 은 만들지 않음)
    public String getName() { 
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }

}