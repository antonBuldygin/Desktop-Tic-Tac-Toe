package tictactoe;

import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu() {
        super();
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
        this.add(menu);

    }
}
