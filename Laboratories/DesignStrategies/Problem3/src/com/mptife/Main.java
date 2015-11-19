package com.mptife;

public class Main {
    private static int resolution = 2;

    //private static int maxSize = 520000000;
    private static int maxSize = 4096;

    private static int repeatTimes = 1;

    private static long[] attemptTimesArray = new long[repeatTimes];

    /*
        Pivot
        0 - mid element
        1 - first element
        2 - last element
    */
    private static int pivotOption = 2;

    /*
        Order of elements before sorting
        0 - random
        1 - ascending
        2 - descending
    */
    private static int initialOrder = 2;

    /*
        Maximum time of sorting
        if quicksort function will exceed this
        program will be terminated
        0 means no limit
     */
    private static double maxTime = 0;

    public static void main(String[] args) {
        int currentSize = resolution;
        int currentRepeat;
        String file = "";
        double median;
        boolean stackOverflow = false;
        while ((currentSize <= maxSize)&&(!stackOverflow)) {
            currentRepeat = 0;
            file += currentSize + " ";
            while (currentRepeat < repeatTimes) {
                long startTime;
                long endTime;
                try{
                    startTime = System.nanoTime();
                    Timetable timetable = new Timetable(currentSize, false);
                    endTime = System.nanoTime();
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
            currentSize *= resolution;
        }
        FileHandler fileHandler = new FileHandler("/home/piotr/Development/Projects/Modern-programming-techniques/Laboratories/QuickSort/testData/data.txt");
        fileHandler.println(file);
        fileHandler.close();
    }
}
