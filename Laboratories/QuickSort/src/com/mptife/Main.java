package com.mptife;

public class Main {
    private static int resolution = 1000;

    //private static int maxSize = 520000000;
    private static int maxSize = 500000000;

    private static int repeatTimes = 10;

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
    private static double maxTime = 500;

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
                int[] tab;
                if(initialOrder==0){
                    tab = Algorithm.generateRandom(currentSize);
                }
                else if(initialOrder==1){
                    tab = Algorithm.generateAscending(currentSize);
                }
                else if(initialOrder==2){
                    tab = Algorithm.generateDescending(currentSize);
                }
                else{
                    System.out.println("Wrong value for array order");
                    return;
                }
                long startTime;
                long endTime;
                try{
                    if(pivotOption==0){
                        startTime = System.currentTimeMillis();
                        Algorithm.quickSortMidPivot(tab, 0, tab.length - 1);
                        endTime = System.currentTimeMillis();
                    }
                    else if(pivotOption==1){
                        startTime = System.currentTimeMillis();
                        Algorithm.quickSortFrstPivot(tab, 0, tab.length - 1);
                        endTime = System.currentTimeMillis();
                    }
                    else if(pivotOption==2){
                        startTime = System.currentTimeMillis();
                        Algorithm.quickSortLastPivot(tab, 0, tab.length - 1);
                        endTime = System.currentTimeMillis();
                    }
                    else{
                        System.out.println("Wrong pivot value");
                        return;
                    }
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
        FileHandler fileHandler = new FileHandler("/home/piotr/IdeaProjects/Modern-programming-techniques/Laboratories/QuickSort/testData/data.txt");
        fileHandler.println(file);
        fileHandler.close();
    }
}
