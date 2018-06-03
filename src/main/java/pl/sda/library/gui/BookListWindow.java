package pl.sda.library.gui;

import pl.sda.library.bookfactory.Book;
import pl.sda.library.database.BookFileService;
import pl.sda.library.gui.listmodels.BookListModel;
import pl.sda.library.gui.renderers.BookRenderer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BookListWindow extends JFrame {
    private JButton addBookButton = new JButton("Add new book");
    private JButton borrowBookButton = new JButton("Borrow book");
    private JButton handInBookButton = new JButton("Hand in book");
    private AddBookWindow addBookWindow = new AddBookWindow();
    private DefaultListModel<Book> bookListModel = new BookListModel();
    private JList<Book> bookList = new JList<>(bookListModel);
    private BookFileService bookFileService = new BookFileService("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Books.txt");


    public BookListWindow() throws HeadlessException {
        loadBookList();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        this.setSize(350, 600);
        this.setTitle("Library");

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.1;
        this.borrowBookButton.setPreferredSize(new Dimension(90, 20));
        add(this.borrowBookButton, c);

        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 0.1;
        this.handInBookButton.setPreferredSize(new Dimension(90, 20));
        add(this.handInBookButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.1;
        this.addBookButton.setPreferredSize(new Dimension(90, 20));
        add(this.addBookButton, c);

        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 500;
        c.gridwidth = 3;
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        bookList.setCellRenderer(new BookRenderer());
        add(new JScrollPane(this.bookList), c);


        this.addBookButton.addActionListener(e -> this.addBookWindow.setVisible(true));
        this.addBookWindow.addButtonActionListner(e -> {

            Book newBook = addBookWindow.createBook();
            if ("".equals(newBook.getAuthor().getFirstName()) && "".equals(newBook.getAuthor().getLastName())) {
                this.addBookWindow.showAlert("Brak Autora");
            } else {
                this.bookListModel.addElement(newBook);
                this.addBookWindow.setVisible(false);

                try {
                    bookFileService.save(newBook);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        });

        this.borrowBookButton.addActionListener(e -> {
            bookList.getSelectedValue().borrowBook();
            repaint();
        });

        this.handInBookButton.addActionListener(e -> {
            bookList.getSelectedValue().handInBook();
            repaint();
        });


        this.bookList.getSelectedValue();
    }

    private void loadBookList() {
        BookFileService bookFileService = new BookFileService("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Books.txt");
        try {
            for (Book book : bookFileService.load()) {
                bookListModel.addElement(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
