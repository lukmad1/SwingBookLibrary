package pl.sda.library.gui;

import pl.sda.library.authorfactory.Author;
import pl.sda.library.authorfactory.AuthorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddAuthorWindow extends JFrame {
    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JButton addAuthorButton = new JButton("Add author");

    public AddAuthorWindow() throws HeadlessException {
        this.setTitle("Add new author");
        setLayout(new GridBagLayout());
        setSize(new Dimension(250, 250));
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;


        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Imie"));
        c.gridy = 1;
        firstNameField.setPreferredSize(new Dimension(100, 30));
        add(this.firstNameField, c);

        c.gridx = 1;
        c.gridy = 0;
        add(new JLabel("Nazwisko"));
        c.gridy = 1;
        lastNameField.setPreferredSize(new Dimension(100, 30));
        add(this.lastNameField, c);

        c.gridx = 0;
        c.gridy = 2;
        addAuthorButton.setPreferredSize(new Dimension(100, 30));
        add(this.addAuthorButton, c);
    }

    public void addAuthorActionListener(ActionListener actionListener) {
        this.addAuthorButton.addActionListener(actionListener);
    }


    public Author createAuthor() {
        return AuthorFactory.createAuthor(this.firstNameField.getText(), this.lastNameField.getText());
    }

    public void showAlert(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
