package com.mptife;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by piotr on 15.10.15.
 */
public class Algorithm {
    // Value representing infinity in the algorithm
    public static int maxValue = 100000;

    // Set S of vertices
    private List<Integer> s = new LinkedList<>();
    // Array D
    private int[] d;
    // Array P
    private int[] p;
    // Size - number of vertixes
    private int size;
    // Neighborhood matrix M
    private int m[][];

    // Initialization of a object
    public Algorithm(int[][] m) {
        this.size = m.length;
        this.m = m;
        d = new int[size];
        p = new int[size];
    }

    // Main algorithm
    public void dijkstraAlgorithm() {
        // Step 1. add to the set S the source vertex 1
        s.add(0);

        // Step 2. and 3.
        // P(1) = 0
        p[0] = 0;
        for (int i = 1; i < size; i++) {
            // D(i) = M(1,i)
            d[i] = m[0][i];
            // P(i) = 1
            p[i] = 0;
        }

        do {
            // Step 4. select from the set V S vertex w, for which the distance D ( w ) is the smallest
            int nearest = findNearest();

            // Step 5. add a vertex w to the set S
            s.add(nearest);

            // Step 6. stepping through all vertices v
            for (int i = 0; i < size; i++) {
                // in the set V-S
                if (s.contains(i)) continue;

                // check whether D ( w ) + M ( w; v ) < D ( v )
                if ((d[nearest] + m[nearest][i]) < d[i]) {
                    // If the inequality is satisfied, then substitute: D ( v ) = D ( w ) + M ( w; v )
                    d[i] = d[nearest] + m[nearest][i];

                    // and P ( v ) = w
                    p[i] = nearest;
                }
            }
        } while (!this.isVSEmpty()); // Step 6. if the set V S is not empty, then go to step 4.
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

    // Returns the solution if form of String object
    // Arrays are indexed starting form 0 so all vertixes numbers have to incremented by 1
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
