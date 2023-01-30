package tictactoe;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    public Model(List<Button> setTextButtonList, String text) {
        this.setTextButtonList = setTextButtonList;
        this.buttonText = text;
    }

    private List<Button> setTextButtonList;

    String flag = "";
    boolean fl = true;
    private String buttonText;
    private String[][] humanVsHuman = new String[][]{
            {"A3", "X________", "P"},
            {"A1", "______X__", "P"}, {"B1", "______XO_", "P"},
            {"C3", "__X___XO_", "P"}, {"B3", "_OX___XO_", "P"},
            {"B2", "_OX_X_XO_", "X"}, {"RS", "_________", "E"},

            {"B2", "____X____", "P"}, {"A1", "____X_O__", "P"},
            {"C1", "____X_O_X", "P"}, {"A3", "O___X_O_X", "P"},
            {"A2", "O__XX_O_X", "P"}, {"C2", "O__XXOO_X", "P"},
            {"B3", "OX_XXOO_X", "P"}, {"B1", "OX_XXOOOX", "P"},
            {"C3", "OXXXXOOOX", "D"}, {"B2", "OXXXXOOOX", "D"},
            {"B2", "OXXXXOOOX", "D"}, {"RS", "_________", "E"},

            {"A2", "___X_____", "P"}, {"B2", "___XO____", "P"},
            {"A1", "___XO_X__", "P"}, {"A3", "O__XO_X__", "P"},
            {"C1", "O__XO_X_X", "P"}, {"B1", "O__XO_XOX", "P"},
            {"C2", "O__XOXXOX", "P"}, {"B3", "OO_XOXXOX", "O"},
            {"A3", "OO_XOXXOX", "O"}, {"C3", "OO_XOXXOX", "O"},
            {"C3", "OO_XOXXOX", "O"}, {"B2", "OO_XOXXOX", "O"},
            {"RS", "_________", "E"}, {"RS", "_________", "E"},

            {"C1", "________X", "P"}, {"B1", "_______OX", "P"},
            {"B2", "____X__OX", "P"}, {"C2", "____XO_OX", "P"},
            {"A3", "X___XO_OX", "X"}, {"B3", "X___XO_OX", "X"},
            {"C3", "X___XO_OX", "X"}, {"A1", "X___XO_OX", "X"},
            {"A1", "X___XO_OX", "X"}, {"RS", "_________", "E"},
            {"A3", "XXX______", "X"}, {"C1", "XOXXXOOOX", "D"},
    };

    String status() {
        List<Character> collect = setTextButtonList.stream().map(s -> s.getText().charAt(0)).collect(Collectors.toList());

        if(collect.size()<9){return flag="CONTinue"; }


        for (int i = 0; i < humanVsHuman.length - 1; i++) {
            System.out.println(humanVsHuman[i][0] + " " + humanVsHuman[i][1] + " " + humanVsHuman[i][2]);

//            StringCharacterIterator iter = new StringCharacterIterator(" " + humanVsHuman[i][1].replace('_', ' '));
            int count = 0;

            for (Character str : collect
            ) {
                System.out.println(str);

                if ( humanVsHuman[i][1].charAt(count)==str) {
                    flag = "gAME";

                }
                if ( humanVsHuman[i][1].charAt(count)!=str) {

                    flag = humanVsHuman[i][2];
                }
                count++;

            }

            System.out.println(flag);


        }


        return flag;
    }


}
