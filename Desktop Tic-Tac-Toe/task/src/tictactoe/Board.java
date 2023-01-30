package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {



    public Board() {
        super();
        setBounds(18,40, 400, 320);
        setLayout(new GridLayout(3, 2, 10, 10));
//        setBackground(Color.BLACK);
        setVisible(true);

    }
}
