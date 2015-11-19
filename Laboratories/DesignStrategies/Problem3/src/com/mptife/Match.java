package com.mptife;

/**
 * Created by piotr on 18.11.15.
 */
public class Match {
    public int player1;
    public int player2;

    public Match(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return player1+"-"+player2;
    }
}
