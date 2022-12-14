package org.example.lambda.advance;

public class Book {
    enum Genre {HISTORY, BIBLE, COMICS, ESSAY}

    private int price; // 가격
    private Genre genre; // 장르

    public Book(int price, Genre genre) {
        this.price = price;
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", genre=" + genre +
                '}';
    }
}
