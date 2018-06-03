package pl.sda.library.gui;

import pl.sda.library.authorfactory.Author;
import pl.sda.library.database.AuthorFileService;
import pl.sda.library.gui.listmodels.AuthorListModel;
import pl.sda.library.gui.renderers.AuthorRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.IOException;

public class AuthorListWindow extends JFrame {
    private DefaultListModel<Author> authorListModel = new AuthorListModel();
    private JList<Author> authorList = new JList<>(authorListModel);
    private JButton addAuthorButton = new JButton("Add author");
    private AddAuthorWindow addAuthorWindow = new AddAuthorWindow();
    AuthorFileService authorFileService = new AuthorFileService("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Authors.txt");


    public AuthorListWindow() throws HeadlessException {
        loadAuthors();

        this.setTitle("Available authors");
        setLayout(new BorderLayout());
        this.setSize(300, 600);

        authorList.setCellRenderer(new AuthorRenderer());
        add(new JScrollPane(this.authorList), BorderLayout.CENTER);

        add(this.addAuthorButton, BorderLayout.PAGE_END);

        this.addAuthorButton.addActionListener(e -> addAuthorWindow.setVisible(true));

        this.addAuthorWindow.addAuthorActionListener(e -> {

            Author userInputAuthor = addAuthorWindow.createAuthor();
            if (authorListModel.contains(userInputAuthor)) {
                this.addAuthorWindow.showAlert("Author already exists!");
            } else {
                try {
                    authorFileService.save(userInputAuthor);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                authorListModel.addElement(userInputAuthor);
            }
            addAuthorWindow.setVisible(false);
        });
    }

    private void loadAuthors() {
        AuthorFileService authorFileService = new AuthorFileService("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Authors.txt");
        try {
            for (Author a : authorFileService.load()) {
                authorListModel.addElement(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addListDoubleClickListener(MouseAdapter mouseAdapter) {
        authorList.addMouseListener(mouseAdapter);
    }

    public JList<Author> getAuthorList() {
        return authorList;
    }


    public DefaultListModel<Author> getAuthorListModel() {
        return authorListModel;
    }
}
