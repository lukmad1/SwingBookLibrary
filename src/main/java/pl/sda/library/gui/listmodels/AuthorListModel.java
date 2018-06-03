package pl.sda.library.gui.listmodels;

import pl.sda.library.authorfactory.Author;
import pl.sda.library.database.AuthorDto;

import javax.swing.*;

public class AuthorListModel extends DefaultListModel<Author> {

    private AuthorDto dto = new AuthorDto();

    @Override
    public void addElement(Author element) {
        super.addElement(element);
        dto.getAuthors().add(element);

    }

}
