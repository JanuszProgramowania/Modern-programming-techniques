package com.mptife;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by piotr on 15.10.15.
 */
public class Algorithm {
    private static Random rand = new Random();

    public static double median(long[] tab){
        double median;
        Arrays.sort(tab);
//        for (long l:tab){
//            System.out.print(l + " ");
//        }
//        System.out.println();
        int i = (tab.length-1)/2;
        if((tab.length%2)==0){
            median = (double)(tab[i]+tab[i+1])/2;
        }
        else{
            return tab[i];
        }
        return median;
    }

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
            tab[i] = size-i;
        }
        return tab;
    }

    public static void quickSortMidPivot(int tab[], int x, int y) {

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
            quickSortMidPivot(tab, x, j);
        if (i < y)
            quickSortMidPivot(tab, i, y);
    }

    public static void quickSortFrstPivot(int tab[], int x, int y) {

        int i, j, v, temp;

        i = x;
        j = y;
        v = tab[x];
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
            quickSortFrstPivot(tab, x, j);
        if (i < y)
            quickSortFrstPivot(tab, i, y);
    }

    public static void quickSortLastPivot(int tab[], int x, int y) {

        int i, j, v, temp;

        i = x;
        j = y;
        v = tab[y];
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
            quickSortLastPivot(tab, x, j);
        if (i < y)
            quickSortLastPivot(tab, i, y);
    }
}
