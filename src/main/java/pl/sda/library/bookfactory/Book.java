package pl.sda.library.bookfactory;

import pl.sda.library.authorfactory.Author;

import java.util.Objects;

public class Book {
    private Author author;
    private String title;
    private boolean isAvailable = true;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void handInBook() {
        isAvailable = true;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isAvailable == book.isAvailable &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

}
