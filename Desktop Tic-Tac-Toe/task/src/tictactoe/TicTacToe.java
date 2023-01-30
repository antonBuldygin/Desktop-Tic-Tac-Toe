package tictactoe;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

import static java.awt.Event.F6;

public class TicTacToe extends JFrame {
    private JLabel status;
    private JFrame tic_tac;
    private Board board;

    private Player player1;
    private Player player2;

    boolean rob ;
    boolean hum ;

    //    private Button button;
    private List<Button> setTextButtonList = new ArrayList<>();
    private List<Button> buttonList = new ArrayList<>();
    boolean endOfGame = false;
    ResetButton reset;
    ResetButton human;
    ResetButton robot;

    M m = new M();

    public List<Button> getSetTextButtonList() {
        return setTextButtonList;
    }

    public List<Button> getButtonList() {
        return buttonList;
    }

    public void setSetTextButtonList(List<Button> setTextButtonList) {
        this.setTextButtonList = setTextButtonList;
    }


    public void setButtonList(List<Button> buttonList) {
        this.buttonList = buttonList;
    }

    int mouseClicksCount;

    public ResetButton getReset() {
        return reset;
    }

    public void setReset(ResetButton reset) {
        this.reset = reset;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatusText(String text) {
        this.status.setText(text);
    }

    public JFrame getTic_tac() {
        return tic_tac;
    }

    public void setTic_tac(JFrame tic_tac) {
        this.tic_tac = tic_tac;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public TicTacToe() {
        super("Tic Tac Toe");
        setName("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
//        setResizable(false);
        setVisible(true);
        setLayout(null);


        board = new Board();

        for (int i = 3; i > 0; i--) {

            for (int j = 'A'; j <= 'C'; j++) {

                String text = Character.toString(j);
                Button button = new Button(" ");
                button.addMouseListener(m);
                button.setName("Button" + text + "" + i);
                button.setEnabled(false);
                buttonList.add(button);
                board.add(button);
            }
        }


        add(board);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Game");
        menu.setName("MenuGame");

        JMenuItem humanhuman = new JMenuItem("Human vs Human");
        humanhuman.setName("MenuHumanHuman");

        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");

        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");

        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");


        JMenuItem exit = new JMenuItem("Exit");
        exit.setName("MenuExit");


        menu.add(humanhuman);
        menu.add(menuHumanRobot);
        menu.add(menuRobotHuman);
        menu.add(menuRobotRobot);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        menuBar.setVisible(true);
        menuBar.repaint();


humanhuman.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        menuActive("Human", "Human");


    }
});


menuHumanRobot.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuActive("Human", "Robot");
    }
});

menuRobotHuman.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuActive( "Robot", "Human");
    }
});

menuRobotRobot.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuActive("Robot", "Robot");

    }
});


        reset = new ResetButton("Start");

        human = new ResetButton("Human");
        human.setName("ButtonPlayer1");
        human.setBounds(30, 5, 100, 30);


        human.setBackground(ColorUIResource.getHSBColor(1, 0, 0.9F));

        human.setForeground(Color.BLACK);

        robot = new ResetButton("Human");
        robot.setName("ButtonPlayer2");
        robot.setBounds(303, 5, 100, 30);

        robot.setForeground(Color.black);

        robot.setBackground(ColorUIResource.getHSBColor(1, 0, 0.9F));

        add(reset);
        add(human);
        add(robot);

        mouseClicksCount = 0;
        status = new JLabel("Game is not started");
        status.setName("LabelStatus");
        status.setBounds(20, 365, 400, 20);
        setFont(new Font("Arial", Font.BOLD, 10));
        add(status);


        human.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (human.getText().equals("Human")) {
                    human.setText("Robot");
                    hum = true;
                } else human.setText("Human");
            }
        });

        robot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (robot.getText().equals("Human")) {
                    robot.setText("Robot");
                    rob = true;
                } else robot.setText("Human");
            }
        });

        getReset().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() instanceof ResetButton) {
                    getSetTextButtonList().clear();
                    getButtonList().stream().forEach(s -> s.setText(" "));
                    setStatusText("Game is not started");
                    player1.setToNull();
                    player2.setToNull();
                    getSetTextButtonList().clear();
                    endOfGame = false;
                    mouseClicksCount++;
                    if (getReset().getText().equals("Start") && mouseClicksCount == 1) {
                        getReset().setText("Reset");
                        setStatusText(MessageFormat.format("The turn of {0} Player (X)", human.getText()));
                        getButtonList().stream().forEach(c -> c.setEnabled(true));
                        human.setEnabled(false);
                        robot.setEnabled(false);



                        forRobots(true, false);


                    }
                    if (getReset().getText().equals("Reset") && mouseClicksCount != 1) {
                        getReset().setText("Start");
                        mouseClicksCount = 0;
                        getButtonList().stream().forEach(c -> c.setEnabled(false));
                        human.setEnabled(true);
                        robot.setEnabled(true);


                    }

                }
            }
        });


        player1 = new Player();
        player2 = new Player();


    }

    private void menuActive(String but1, String but2) {
        human.setText(but1);
        robot.setText(but2);
        hum = false;
        rob = false;
        getSetTextButtonList().clear();
        getButtonList().stream().forEach(s -> s.setText(" "));
        setStatusText("Game is not started");
        player1.setToNull();
        player2.setToNull();
        getSetTextButtonList().clear();
        endOfGame = false;


        getReset().setText("Reset");
        setStatusText(MessageFormat.format("The turn of {0} Player (X)", human.getText()));
        getButtonList().stream().forEach(c -> c.setEnabled(true));
        human.setEnabled(false);
        robot.setEnabled(false);


        forRobots(true, false);
    }

    private void forRobots(boolean hum, boolean rob) {
//        while (getButtonList().size() != getSetTextButtonList().size() && (human.getText().equals("Robot") ||
//                robot.getText().equals("Robot")) && (hum || rob)) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {


            if (human.getText().equals("Robot") && hum) {
//                setStatusText("The turn of Robot Player (O1)");
                List<Button> listOutput = new ArrayList<>();
                listOutput.addAll(getButtonList());
                listOutput.removeAll(getSetTextButtonList());

                Random r = new Random();
                if(listOutput.size()>1){
                Button button = listOutput.get(r.nextInt(listOutput.size() - 1));clk(button);  button.doClick();}
                if(listOutput.size()<=1){
                    Button button = listOutput.get(r.nextInt(listOutput.size() ));clk(button);  button.doClick();}
            }

            if (robot.getText().equals("Robot") && rob) {
//                setStatusText("The turn of Robot Player (X1)");
                List<Button> listOutput = new ArrayList<>();
                listOutput.addAll(getButtonList());
                listOutput.removeAll(getSetTextButtonList());

                Random r = new Random();
                if(listOutput.size()>0){
                    Button button = listOutput.get(r.nextInt(listOutput.size() - 1));clk(button);  button.doClick();}
                if(listOutput.size()==0){
                    Button button = listOutput.get(r.nextInt(listOutput.size() - 1));clk(button);  button.doClick();}

            }
            }
        };
        timer.schedule(task,1000);
        }



    public void clk(Button e) {
        if (e instanceof Button) {
            Button source = (Button) e;
            System.out.println(source.getName());

            boolean win1;

            if (!getSetTextButtonList().contains(source)
                    && getSetTextButtonList().size() != getButtonList().size() && !endOfGame
                    && (reset.getText().equals("Reset"))

            ) {
                if (getSetTextButtonList().size() == 0) {
                    setStatusText(MessageFormat.format("The turn of {0} Player (O)", robot.getText()));
                    source.setText("X");
                    getSetTextButtonList().add(source);
                    win1 = player1.play(source.getName().substring(6, source.getName().length()));
                    getReset().setText("Reset");
//                    hum = false;
//                    rob = true;
                    forRobots(false,true);
                    return;
                }
                if (getSetTextButtonList().get(getSetTextButtonList().size() - 1).getText() != "O") {

                    source.setText("O");
                    setStatusText(MessageFormat.format("The turn of {0} Player (X)", human.getText()));
                    getSetTextButtonList().add(source);
                    hum = false;
                    rob = true;
                    boolean win2 = player2.play(source.getName().substring(6, source.getName().length()));
                    if (!win2) {
                        setStatusText("The Robot Player (O) wins");
                        player1.setToNull();
                        player2.setToNull();
                        getSetTextButtonList().clear();
                        endOfGame = true;
                        getReset().setText("Reset");
                        hum = false;
                        rob = false;
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                    }
                    if (getSetTextButtonList().size() == getButtonList().size()) {
                        setStatusText("Draw");
                        hum = false;
                        rob = false;
                        player1.setToNull();
                        player2.setToNull();
                        getSetTextButtonList().clear();
                        endOfGame = true;
                        getReset().setText("Reset");
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                        return;
                    }
                    forRobots(true,false);
                    return;
                }
                if (getSetTextButtonList().get(getSetTextButtonList().size() - 1).getText() != "X") {
                    source.setText("X");
                    setStatusText(MessageFormat.format("The turn of {0} Player (O)", robot.getText()));
//                    setStatusText("The turn of Robot Player (X)");
                    getSetTextButtonList().add(source);
                    hum = true;
                    rob = false;
                    win1 = player1.play(source.getName().substring(6, source.getName().length()));
                    if (!win1) {
                        setStatusText("The Robot Player (X) wins");
                        player1.setToNull();
                        player2.setToNull();
                        getSetTextButtonList().clear();
                        endOfGame = true;
                        getReset().setText("Reset");

                        hum = false;
                        rob = false;
                        return;
                    }
                    if (getSetTextButtonList().size() == getButtonList().size()) {
                        setStatusText("Draw");
                        hum = false;
                        rob = false;
                        player1.setToNull();
                        player2.setToNull();
                        getSetTextButtonList().clear();
                        endOfGame = true;
                        getReset().setText("Reset");

                        return;
                    }
                    forRobots(false,true);
                }


            }
        }
    }

    public class M implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof Button) {
                Button source = (Button) e.getSource();
                System.out.println(source.getName());
//                source.setText("X");
                boolean win1;


                if (!getSetTextButtonList().contains(source)
                        && getSetTextButtonList().size() != getButtonList().size() && !endOfGame
                        && (reset.getText().equals("Reset"))
//                        &&mouseClicksCount!=0)||( reset.getText().equals("Start")
//                        &&mouseClicksCount==0)
                ) {
                    if (getSetTextButtonList().size() == 0) {
                        setStatusText("Game in progress");

                        source.setText("X");
                        getSetTextButtonList().add(source);
                        setStatusText(MessageFormat.format("The turn of {0} Player (O)", robot.getText()));
                        win1 = player1.play(source.getName().substring(6, source.getName().length()));
                        if(robot.getText().equals("Robot")){forRobots(false,true); rob = true;}

//                        getReset().setText("Reset");
                        return;
                    }
                    if (getSetTextButtonList().get(getSetTextButtonList().size() - 1).getText() != "O") {
                        source.setText("O");
                        setStatusText(MessageFormat.format("The turn of {0} Player (X)", human.getText()));
                        getSetTextButtonList().add(source);
                        boolean win2 = player2.play(source.getName().substring(6, source.getName().length()));
                        if (!win2) {
                            setStatusText("The Human Player (O) wins");
                            player1.setToNull();
                            player2.setToNull();
                            getSetTextButtonList().clear();
                            endOfGame = true;
                            return;
//                            getReset().setText("Reset");
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                        }
                        if (getSetTextButtonList().size() == getButtonList().size()) {
                            setStatusText("Draw");
                            player1.setToNull();
                            player2.setToNull();
                            getSetTextButtonList().clear();
                            endOfGame = true;
//                            getReset().setText("Reset");
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                            return;
                        }
//                        if(human.getText().equals("Robot")){
//                            setStatusText("The turn of Robot Player (X)");
                            forRobots(true, false); hum =true;
//                        if(human.getText().equals("Human")){
//                            setStatusText("The turn of Human Player (X)");
//                            }

                        return;
                    }
                    if (getSetTextButtonList().get(getSetTextButtonList().size() - 1).getText() != "X") {
                        source.setText("X");
                        setStatusText(MessageFormat.format("The turn of {0} Player (O)", robot.getText()));
                        getSetTextButtonList().add(source);
                        win1 = player1.play(source.getName().substring(6, source.getName().length()));

                        if (!win1) {
                            setStatusText("The Human Player (X) wins");
                            player1.setToNull();
                            player2.setToNull();
                            getSetTextButtonList().clear();
                            endOfGame = true;
//                            getReset().setText("Reset");
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                            return;
                        }
                        if (getSetTextButtonList().size() == getButtonList().size()) {
                            setStatusText("Draw");
                            player1.setToNull();
                            player2.setToNull();
                            getSetTextButtonList().clear();
                            endOfGame = true;
//                            getReset().setText("Reset");
//                        getButtonList().stream().forEach(c -> c.setText(" "));
                            return;
                        }
//                        if(robot.getText().equals("Robot")){
//                            setStatusText("The turn of Robot Player (O)");
                            forRobots(false,true); rob = true;
//                        if(robot.getText().equals("Human")){
//                            setStatusText("The turn of Human Player (O)");
//                        }

                    }


                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {


        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}