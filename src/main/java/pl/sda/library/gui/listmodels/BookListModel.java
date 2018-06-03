package pl.sda.library.gui.listmodels;

import pl.sda.library.bookfactory.Book;
import pl.sda.library.database.BookDto;

import javax.swing.*;

public class BookListModel extends DefaultListModel<Book> {
    private BookDto dto = new BookDto();


    @Override
    public void addElement(Book element) {
        super.addElement(element);
        dto.getBooks().add(element);
    }

}
