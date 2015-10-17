package com.mptife;

import java.util.Random;

/**
 * Created by piotr on 15.10.15.
 */
public class Algorithm {
    private static Random rand = new Random();

    public static int[] generateRandom(int size) {
        int[] tab = new int[size];
        for (int i : tab) {
            i = rand.nextInt();
        }
        return tab;
    }

    public static int[] generateAscending(int size){
        int tab[] = new int[size];
        for(int i = 0; i<size; i++){
            tab[i] = i;
        }
        return tab;
    }

    public static int[] generateDescending(int size){
        int tab[] = new int[size];
        for(int i = 0; i<size; i++){
            tab[i] = size-1;
        }
        return tab;
    }

    public static void quickSort(int tab[], int x, int y) {

        int i, j, v, temp;

        i = x;
        j = y;
        v = tab[(x + y) / 2];
        do {
            while (tab[i] < v)
                i++;
            while (v < tab[j])
                j--;
            if (i <= j) {
                temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                i++;
                j--;
            }
        }
        while (i <= j);
        if (x < j)
            quickSort(tab, x, j);
        if (i < y)
            quickSort(tab, i, y);
    }
}
