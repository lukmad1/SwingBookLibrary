package pl.sda.library.gui;

import pl.sda.library.authorfactory.Author;
import pl.sda.library.authorfactory.AuthorFactory;
import pl.sda.library.bookfactory.Book;
import pl.sda.library.bookfactory.BookFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddBookWindow extends JFrame {
    private JTextField bookTitleField = new JTextField();
    private JTextField authorFirstName = new JTextField();
    private JTextField authorLastName = new JTextField();
    private JButton addBookButton = new JButton("Add Book");
    private JButton showAuthorsButton = new JButton("Authors");
    private AuthorListWindow authorListWindow = new AuthorListWindow();

    public AddBookWindow() throws HeadlessException {
        this.setTitle("Add a book");
        this.setSize(400, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Tytuł"));
        c.gridy = 1;
        bookTitleField.setPreferredSize(new Dimension(100, 30));
        add(this.bookTitleField, c);

        c.gridx = 1;
        c.gridy = 0;
        add(new JLabel("Imie"));
        c.gridy = 1;
        authorFirstName.setPreferredSize(new Dimension(100, 30));
        add(this.authorFirstName, c);

        c.gridx = 2;
        c.gridy = 0;
        add(new JLabel("Nazwisko"));
        c.gridy = 1;
        authorLastName.setPreferredSize(new Dimension(100, 30));
        add(this.authorLastName, c);

        c.gridx = 2;
        c.gridy = 2;
        showAuthorsButton.setPreferredSize(new Dimension(100, 30));
        add(this.showAuthorsButton, c);

        c.gridx = 0;
        c.gridy = 2;
        addBookButton.setPreferredSize(new Dimension(100, 30));
        add(this.addBookButton, c);

        this.showAuthorsButton.addActionListener(e -> this.authorListWindow.setVisible(true));

        this.authorListWindow.addListDoubleClickListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = authorListWindow.getAuthorList().getSelectedIndex();
                    authorFirstName.setText(authorListWindow.getAuthorListModel().getElementAt(index).getFirstName());
                    authorLastName.setText(authorListWindow.getAuthorListModel().getElementAt(index).getLastName());
                    authorListWindow.setVisible(false);
                }
            }
        });
    }

    public void addButtonActionListner(ActionListener actionListener) {
        this.addBookButton.addActionListener(actionListener);
    }

    public Book createBook() {
        Author newAuthor = AuthorFactory.createAuthor(this.authorFirstName.getText(), this.authorLastName.getText());

        if (!authorListWindow.getAuthorListModel().contains(newAuthor)) {
            authorListWindow.getAuthorListModel().addElement(newAuthor);
        }
        return BookFactory.createBook(this.bookTitleField.getText(), newAuthor);
    }

    public void showAlert(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
