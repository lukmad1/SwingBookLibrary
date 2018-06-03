package pl.sda.library.bookfactory;

import pl.sda.library.authorfactory.Author;

public class BookFactory {
    public static Book createBook(String title, Author author) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        return book;
    }
}
