package tictactoe;

import java.util.Set;
import java.util.TreeSet;

public class Player {
    int gamesWincount;

    Set<String> one = new TreeSet<>();
    Set<String> two = new TreeSet<>();
    Set<String> three = new TreeSet<>();
    Set<String> four = new TreeSet<>();
    Set<String> five = new TreeSet<>();
    Set<String> six = new TreeSet<>();
    Set<String> seven = new TreeSet<>();
    Set<String> eight = new TreeSet<>();


    public int getGamesWincount() {
        return gamesWincount++;
    }
    public void setToNull(){
        this.one = new TreeSet<>();
        this.two = new TreeSet<>();
        this.three = new TreeSet<>();
        this.four = new TreeSet<>();
        this.five = new TreeSet<>();
        this.six = new TreeSet<>();
        this.seven = new TreeSet<>();
        this.eight = new TreeSet<>();

    }



    public boolean play(String input) {

        switch (input) {
            case "A3":
                this.one.add(input);
                this.four.add(input);
                this.seven.add(input);
                break;
            case "A2":
                this.one.add(input);
                this.five.add(input);
                break;
            case "A1":
                this.one.add(input);
                this.six.add(input);
                this.eight.add(input);
                break;
            case "B3":
                this.two.add(input);
                this.four.add(input);
                break;
            case "B2":
                this.two.add(input);
                this.five.add(input);
                this.seven.add(input);
                this.eight.add(input);
                break;
            case "B1":
                this.two.add(input);
                this.six.add(input);
                break;
            case "C3":
                this.three.add(input);
                this.four.add(input);
                this.eight.add(input);
                break;
            case "C2":
                this.three.add(input);
                this.five.add(input);
                break;
            case "C1":
                this.three.add(input);
                this.six.add(input);
                this.seven.add(input);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
        if ((this.one.size() == 3) || (this.two.size() == 3) || (this
                .three.size() == 3) || (this.four.size() == 3 || this
                .five.size() == 3) || (this.six.size() ==3) || (this
                .seven.size() ==3) || (this.eight.size() ==3)) {
            return  false;

        } else return  true;

    }


}
