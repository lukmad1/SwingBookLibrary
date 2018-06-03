package pl.sda.library.database;

import pl.sda.library.authorfactory.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorDto {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }

}
