package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ResetButton extends JButton {
    private Border roundedBorder;

    public ResetButton(String text) {

        roundedBorder = new LineBorder(Color.BLACK, 2, true);

        setBackground(Color.BLACK);
        setName("ButtonStartReset");
        setBounds(170, 5, 100, 30);
        setText(text);
        setForeground(Color.white);
        setFont(new Font("Arial", Font.BOLD, 20));
        setBorder(roundedBorder);
        setFocusPainted(false);
        setVisible(true);
    }
}
