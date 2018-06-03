package pl.sda.library.database;

import pl.sda.library.bookfactory.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

}
