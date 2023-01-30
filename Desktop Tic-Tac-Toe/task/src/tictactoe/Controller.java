package tictactoe;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter {

    private Model model;
    private TicTacToe view;
    private ActionListener actionListener;

    public Controller(Model model, TicTacToe view) {
        this.model = model;
        this.view = view;
    }


    void fr() {

        for (Button b : view.getButtonList()
        ) {
            b.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
//                    if (e.getSource() instanceof Button) {
                        Button source = (Button) e.getSource();
                    source.setText("X");
                        if (!view.getSetTextButtonList().contains(source)
                                && view.getSetTextButtonList().size() != view.getButtonList().size()) {
                            if (view.getSetTextButtonList().size() == 0) {
                                view.setStatusText("Game in progress");
                                source.setText("X");
                                view.getSetTextButtonList().add(source);
                                return;
                            }
                            if (view.getSetTextButtonList().get(view.getSetTextButtonList().size() - 1).getText() != "O") {
                                source.setText("O");
                                view.getSetTextButtonList().add(source);
                                return;
                            }
                            if (view.getSetTextButtonList().get(view.getSetTextButtonList().size() - 1).getText() != "X") {
                                source.setText("X");
                                view.getSetTextButtonList().add(source);

                                return;
                            }
                        }

                    }

//                }
            });

        }

        view.getReset().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() instanceof ResetButton){
                    view.getSetTextButtonList().clear();
                    view.getButtonList().stream().forEach(s->s.setText(" "));
                    view.getReset().setName("Start");
                    view.setStatusText("Game is not started");
                }
            }});
    }
}


