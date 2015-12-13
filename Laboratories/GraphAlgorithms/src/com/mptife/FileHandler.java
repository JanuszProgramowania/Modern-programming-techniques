package com.mptife;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by piotr on 15.10.15.
 */
public class FileHandler {
    private String filePath;

    private PrintWriter pw;

    private File file;

    private FileWriter fw;

    private Scanner sc;

    FileHandler(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
        try {
            fw = new FileWriter(file, true);
            sc = new Scanner(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw = new PrintWriter(fw);
    }

//    public int nextInt(){
//        return sc.nextInt();
//    }

    public void println(String line) {
        pw.println(line);
    }

    public void close() {
        if (pw != null) {
            pw.close();
        }
    }

    public int[][] getNeighbourhoodMatrix() {
        int size = sc.nextInt();
        int[][] m = new int[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                m[i][j] = Algorithm.maxValue;
            }

        while (sc.hasNextInt()) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int value = sc.nextInt();
            m[x][y] = value;
        }
        return m;
    }
}
