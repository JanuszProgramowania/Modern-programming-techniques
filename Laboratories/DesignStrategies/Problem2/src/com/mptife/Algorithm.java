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

    public static int[] generate(int size) {
        int[] tab = new int[size];
        tab[size-1] = size-1;
        int[] tmp = new int[size-1];
        for (int i=0;i<tmp.length;i++) {
            int t = rand.nextInt(size-1);
            t=0-t;
            tmp[i]=t;
        }
        Arrays.sort(tmp);
        System.arraycopy( tmp, 0, tab, 0, tmp.length );
        return tab;
    }

    public static int searchDnC(int L, int R, int[] T) {
        if (L >= R) {
            if (T[L] == L) {
                return L;
            }
            return -1;
        }

        int mid = (R - L) / 2 + L;

        if (T[mid] == mid) {
            return mid;
        } else if (T[mid] > mid)
            return searchDnC(L, mid - 1, T);
        else
            return searchDnC(mid + 1, R, T);
    }

    public static int searchNaive(int[] T) {
        for (int i =0; i<T.length;i++){
            if(T[i]==i)
                return i;
        }
        return -1;
    }
}
