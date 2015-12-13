package com.mptife;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by piotr on 15.10.15.
 */
public class Algorithm {

    public static int maxValue = 100000;

    private List<Integer> s = new LinkedList<>();
    private int[] d;
    private int[] p;
    private int size;
    private int m[][];

    public Algorithm(int[][] m) {
        this.size = m.length;
        this.m = m;
        d = new int[size];
        p = new int[size];
    }

    public void dijkstraAlgorithm() {
        s.add(0);
        p[0] = 0;
        for (int i = 1; i < size; i++) {
            d[i] = m[0][i];
            p[i] = 0;
        }
        do {
            int nearest = findNearest();
            s.add(nearest);
            for (int i = 0; i < size; i++) {
                if (s.contains(i)) continue;
                if ((d[nearest] + m[nearest][i]) < d[i]) {
                    d[i] = d[nearest] + m[nearest][i];
                    p[i] = nearest;
                }
            }
        } while (!this.isVSEmpty());
    }

    private boolean isVSEmpty() {
        for (int i = 0; i < size; i++)
            if (s.contains(i)) continue;
            else return false;
        return true;
    }

    private int findNearest() {
        int result = maxValue;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (s.contains(i)) continue;
            result = d[i];
            index = i;
        }
        for (int i = 0; i < size; i++) {
            if (s.contains(i)) continue;
            int temp = d[i];
            if (temp < result) {
                result = temp;
                index = i;
            }

        }

        return index;
    }

    public String getSolution() {
        String solution = "";
        for (int i = 0; i < size; i++) {
            solution += "Path: " + getPath(i) + "\t\t\t\tDistance: " + d[i] + "\n";
        }
        return solution;
    }

    private String getPath(int v) {
        String path = "";
        if (v == p[v])
            return String.valueOf(v + 1);
        else {
            path += getPath(p[v]);
            path += "\t" + String.valueOf(v + 1);
        }
        return path;
    }
}
