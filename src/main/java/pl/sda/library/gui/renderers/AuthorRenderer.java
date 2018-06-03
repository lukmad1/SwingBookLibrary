package pl.sda.library.gui.renderers;

import pl.sda.library.authorfactory.Author;

import javax.swing.*;
import java.awt.*;

public class AuthorRenderer extends JLabel implements ListCellRenderer<Author> {

    public AuthorRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Author> list, Author value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getFirstName() + " " + value.getLastName());

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
