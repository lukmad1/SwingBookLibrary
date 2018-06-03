package pl.sda.library.database;

import com.google.gson.Gson;
import pl.sda.library.authorfactory.Author;

public class AuthorFileService extends AbstractFileService<Author> {


    public AuthorFileService(String PATH) {
        super(PATH);
    }

    @Override
    protected Author unJson(String str) {
        return new Gson().fromJson(str, Author.class);
    }
}
