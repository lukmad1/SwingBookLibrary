package pl.sda.library.database;

import com.google.gson.Gson;
import pl.sda.library.bookfactory.Book;

public class BookFileService extends AbstractFileService<Book> {


    public BookFileService(String PATH) {
        super(PATH);
    }

    @Override
    protected Book unJson(String str) {
        return new Gson().fromJson(str, Book.class);
    }
}
