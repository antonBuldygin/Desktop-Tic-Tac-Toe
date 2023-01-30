package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Button extends JButton {

    public Button(String text) {
        Border roundedBorder = new LineBorder(Color.BLACK, 2, true);

        setBackground(Color.ORANGE);
//        setBounds(0,0, 30, 30);
        setText(text);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.BOLD, 40));
        setBorder(roundedBorder);
        setFocusPainted(false);}

}

