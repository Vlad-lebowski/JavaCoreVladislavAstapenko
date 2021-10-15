package com.company.homeworkFive.task2;

import java.util.Scanner;

public class MatricesMultiplier {
    public static void multiplyTwoMatrices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of lines of the first matrix");
        String linesOneInput = scanner.nextLine();
        while (isNotPositiveInteger(linesOneInput)){
            System.out.println("Your input is wrong. Try again:");
            linesOneInput = scanner.nextLine();
        }
        int linesOne = Integer.parseInt(linesOneInput);

        System.out.println("Enter the number of columns of the first matrix");
        String columnsOneInput = scanner.nextLine();
        while (isNotPositiveInteger(columnsOneInput)){
            System.out.println("Your input is wrong. Try again:");
            columnsOneInput = scanner.nextLine();
        }
        int columnsOne = Integer.parseInt(columnsOneInput);

        double[][] firstMatrix = new double[linesOne][columnsOne];

        System.out.println("Enter the number of lines of the second matrix");
        String linesTwoInput = scanner.nextLine();
        while (isNotPositiveInteger(linesTwoInput)){
            System.out.println("Your input is wrong. Try again:");
            linesTwoInput = scanner.nextLine();
        }
        int linesTwo = Integer.parseInt(linesTwoInput);

        System.out.println("Enter the number of columns of the second matrix");
        String columnsTwoInput = scanner.nextLine();
        while (isNotPositiveInteger(columnsTwoInput)){
            System.out.println("Your input is wrong. Try again:");
            columnsTwoInput = scanner.nextLine();
        }
        int columnsTwo = Integer.parseInt(columnsTwoInput);
        double[][] secondMatrix = new double[linesTwo][columnsTwo];

        if (columnsOne != linesTwo && columnsTwo != linesOne){
            System.out.println("Your matrices can't be multiplied");
            scanner.close();
            return;
        }

        System.out.println("Enter the values for the first matrix:");
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++){
                System.out.print("Element [" + i + "][" + j + "]: ");
                String matrixInput = scanner.nextLine();
                while(isNotDouble(matrixInput)){
                    System.out.println("Your input is wrong. Try again:");
                    matrixInput = scanner.nextLine();
                }
                double matrixElement = Double.parseDouble(matrixInput);
                firstMatrix[i][j] = matrixElement;
            }
        }

        System.out.println("Enter the values for the second matrix:");
        for (int i = 0; i < secondMatrix.length; i++){
            for (int j = 0; j < secondMatrix[i].length; j++){
                System.out.print("Element [" + i + "][" + j + "]: ");
                String matrixInput = scanner.nextLine();
                while(isNotDouble(matrixInput)){
                    System.out.println("Your input is wrong. Try again:");
                    matrixInput = scanner.nextLine();
                }
                double matrixElement = Double.parseDouble(matrixInput);
                secondMatrix[i][j] = matrixElement;
            }
        }

        double[][] thirdMatrix;

        if(columnsOne == linesTwo){ //first possible case
            thirdMatrix = new double[linesOne][columnsTwo];
            for (int i = 0; i < thirdMatrix.length; i++) {
                for (int j = 0; j < thirdMatrix[i].length; j++){
                    int index = 0;
                    while (index < columnsOne){
                        thirdMatrix[i][j] += firstMatrix[i][index] * secondMatrix[index][j];
                        index++;
                    }
                }
            }
            System.out.println("Your final matrix:");
            for (double[] matrix : thirdMatrix) {
                for (double v : matrix) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }
            scanner.close();
            return;
        }

        thirdMatrix = new double[linesTwo][columnsOne]; //second possible case
        for (int i = 0; i < thirdMatrix.length; i++) {
            for (int j = 0; j < thirdMatrix[i].length; j++){
                int index = 0;
                while (index < columnsTwo){
                    thirdMatrix[i][j] += secondMatrix[i][index] * firstMatrix[index][j];
                    index++;
                }
            }
        }
        System.out.println("Your final matrix:");
        for (double[] matrix : thirdMatrix) {
            for (double v : matrix) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static boolean isNotPositiveInteger(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            int num = Integer.parseInt(strNum);
            if (num <= 0){
                return true;
            }
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    private static boolean isNotDouble(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
