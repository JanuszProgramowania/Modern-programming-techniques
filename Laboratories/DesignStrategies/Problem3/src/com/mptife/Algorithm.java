package com.mptife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by piotr on 15.10.15.
 */
public class Algorithm {
    private static Random rand = new Random();

    public static double median(long[] tab) {
        double median;
        Arrays.sort(tab);
//        for (long l:tab){
//            System.out.print(l + " ");
//        }
//        System.out.println();
        int i = (tab.length - 1) / 2;
        if ((tab.length % 2) == 0) {
            median = (double) (tab[i] + tab[i + 1]) / 2;
        } else {
            return tab[i];
        }
        return median;
    }

    public static Match[][] generateTournament(int size) {
        if ((size & (size - 1)) != 0) {
            return new Match[0][0];
        }
        Match[][] tab = new Match[size - 1][size / 2];
        boolean[][] alreadyPlayed = new boolean[size][size];

        //Init first row
        int player1;
        int player2;
        for (int i = 0; i < size / 2; i++) {
            player1 = 2 * i + 1;
            player2 = 2 * i + 2;
            tab[0][i] = new Match(player1, player2);
            alreadyPlayed[player1 - 1][player2 - 1] = true;
            alreadyPlayed[player2 - 1][player1 - 1] = true;
        }

        //Init first column
        player1 = 1;
        for (int i = 1; i < size - 1; i++) {
            player2 = i + 2;
            tab[i][0] = new Match(player1, player2);
            alreadyPlayed[player1 - 1][player2 - 1] = true;
            alreadyPlayed[player2 - 1][player1 - 1] = true;
        }

        //Main Activity
        int m,n;
        for (int i = 1; i < size-1; i++) {
            m = 1;
            n = i;
            do {
                player1 = getPlayerThatDidNotHaveMatchToday(tab[n],1);
                int j =2;
                do{
                    player2 = getPlayerThatDidNotHaveMatchToday(tab[n],j);
                    j++;
                }while(alreadyPlayed[player1-1][player2-1]);
                tab[n][m] = new Match(player1, player2);
                alreadyPlayed[player1 - 1][player2 - 1] = true;
                alreadyPlayed[player2 - 1][player1 - 1] = true;
                m++;
                n--;
            } while (n > 0 && m < size / 2);
        }

        //Last Row
        for (int i = 2; i < size / 2;i++){
            n=size-2;
            m=i;
            while(n > 0 && m < size / 2){
                player1 = getPlayerThatDidNotHaveMatchToday(tab[n],1);
                int j =2;
                do{
                    player2 = getPlayerThatDidNotHaveMatchToday(tab[n],j);
                    j++;
                }while(alreadyPlayed[player1-1][player2-1]);
                tab[n][m] = new Match(player1, player2);
                alreadyPlayed[player1 - 1][player2 - 1] = true;
                alreadyPlayed[player2 - 1][player1 - 1] = true;
                m++;
                n--;
            }
        }
        return tab;
    }

    private static int getPlayerThatDidNotHaveMatchToday(Match[] today, int index){
        int result = -1, valueNumber = 1;
        int size = today.length;
        boolean[] hasMatchToday = new boolean[size*2];
        for (Match match : today){
            if(match!=null){
                hasMatchToday[match.player1-1] = true;
                hasMatchToday[match.player2-1] = true;
            }
        }

        for (int i=1; i<=hasMatchToday.length;i++){
            if(hasMatchToday[i-1])
                continue;
            else if(valueNumber==index){
                return i;
            }
            else{
                valueNumber++;
            }
        }

        return result;
    }
}
