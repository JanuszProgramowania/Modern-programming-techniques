package com.mptife;

public class Main {
    private static String filePath = "/home/piotr/Development/Projects/Modern-programming-techniques/Laboratories/GraphAlgorithms/testData/data.txt";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler(filePath);
        // Reading graph from file in form of coincidence matrix
        int[][] matrix = fileHandler.getNeighbourhoodMatrix();
        Algorithm algorithm = new Algorithm(matrix);
        algorithm.dijkstraAlgorithm();
        String solution = algorithm.getSolution();
        System.out.println(solution);
        fileHandler.println("\n\n" + solution);
        fileHandler.close();
    }
}
