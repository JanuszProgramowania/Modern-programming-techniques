package com.mptife;

public class Main {
    private static int resolution = 500000;

    //private static int maxSize = 520000000;
    private static int maxSize = 10000000;

    private static int repeatTimes = 10;

    private static long[] attemptTimesArray = new long[repeatTimes];

    /*
        Maximum time of sorting
        if quicksort function will exceed this
        program will be terminated
        0 means no limit
     */
    private static double maxTime = 0;

    public static void main(String[] args) {
        int currentSize = resolution;
        int currentRepeat, index;
        String file = "";
        double median;
        boolean stackOverflow = false;
        while ((currentSize <= maxSize)&&(!stackOverflow)) {
            currentRepeat = 0;
            file += currentSize + " ";
            int[] tab = Algorithm.generate(currentSize);
            while (currentRepeat < repeatTimes) {
                long startTime;
                long endTime;
                try{
                    startTime = System.nanoTime();
                    index = Algorithm.searchDnC(0, currentSize - 1, tab);
                    //index=Algorithm.searchNaive(tab);
                    endTime = System.nanoTime();
                    if(index!=currentSize-1)
                        System.out.println("fail!!!");
                    attemptTimesArray[currentRepeat] = (endTime - startTime);
                    currentRepeat++;
                }catch(java.lang.StackOverflowError e) {
                    System.out.println("Stack overflow occurred!");
                    file += e.toString();
                    System.out.println(e);
                    System.out.println("Program will be terminated.");
                    stackOverflow = true;
                    break;
                }
            }
            if(stackOverflow) break;
            median = Algorithm.median(attemptTimesArray);
            file += median+"\n";
            System.out.println(currentSize + " " + median);
            if(maxTime>0&&median>maxTime) break;
            currentSize += resolution;
        }
        FileHandler fileHandler = new FileHandler("/home/piotr/Development/Projects/Modern-programming-techniques/Laboratories/QuickSort/testData/data.txt");
        fileHandler.println(file);
        fileHandler.close();
    }
}
