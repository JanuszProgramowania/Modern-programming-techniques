package com.mptife;

public class Main {
    private static int resolution = 50000;

    //private static int maxSize = 520000000;
    private static int maxSize = 10000000;

    private static int repeatTimes = 10;

    public static void main(String[] args) {
        //FileHandler fileHandler = new FileHandler("/home/piotr/IdeaProjects/Modern-programming-techniques/Laboratories/QuickSort/testData/data.txt");
        int currentSize = 50000;
        int currentRepeat;
        String file = "";
        while (currentSize <= maxSize) {
            currentRepeat = 0;
            file += currentSize + " ";
            while (currentRepeat < repeatTimes) {
                int[] tab = Algorithm.generateDescending(currentSize);
                long startTime = System.currentTimeMillis();
                Algorithm.quickSort(tab, 0, tab.length - 1);
                long endTime = System.currentTimeMillis();
                file += (endTime - startTime) + " ";
                currentRepeat++;
            }
            file += "\n";
            currentSize += resolution;
            System.out.println(currentSize);
        }
        FileHandler fileHandler = new FileHandler("/home/piotr/IdeaProjects/Modern-programming-techniques/Laboratories/QuickSort/testData/data.txt");
        fileHandler.println(file);
        fileHandler.close();
    }
}
