package pl.sda.library.gui.renderers;

import pl.sda.library.bookfactory.Book;

import javax.swing.*;
import java.awt.*;

public class BookRenderer extends JLabel implements ListCellRenderer<Book> {

    public BookRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book value, int index, boolean isSelected, boolean cellHasFocus) {

        ImageIcon icon;
        if (value.isAvailable()) {
            icon = new ImageIcon("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Tick2.png");
        } else {
            icon = new ImageIcon("D:\\Projekty_Java\\WzorceProjektowe3\\src\\main\\resources\\Cross2.png");
        }
        setIcon(icon);

        setText(value.getTitle() + ", " + value.getAuthor().getFirstName() + " " + value.getAuthor().getLastName());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
}
