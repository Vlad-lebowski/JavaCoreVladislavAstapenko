package com.company.homeworkFive.task6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatricesMultiplierFromFile {
    public static void multiplyTwoMatricesFromFile() throws IOException {
        Scanner scanner = new Scanner(new File("src/com/company/homeworkFive/task6/INPUT.txt"));
        int linesOne;
        int columnsOne;
        int linesTwo;
        int columnsTwo;


        if (scanner.hasNextInt()){
            linesOne = scanner.nextInt();
            System.out.println("Number of lines for the first matrix:" + linesOne);
        } else {
            System.out.println("File doesn't have necessary information");
            return;
        }
        if (scanner.hasNextInt()){
            columnsOne = scanner.nextInt();
            System.out.println("Number of columns for the first matrix:" + columnsOne);
        } else {
            System.out.println("File doesn't have necessary information");
            return;
        }
        if (scanner.hasNextInt()){
            linesTwo = scanner.nextInt();
            System.out.println("Number of lines for the second matrix:" + linesTwo);
        } else {
            System.out.println("File doesn't have necessary information");
            return;
        }
        if (scanner.hasNextInt()){
            columnsTwo = scanner.nextInt();
            System.out.println("Number of columns for the second matrix:" + columnsTwo);
        } else {
            System.out.println("File doesn't have necessary information");
            return;
        }
        double[][] firstMatrix = new double[linesOne][columnsOne];
        double[][] secondMatrix = new double[linesTwo][columnsTwo];

        if (columnsOne != linesTwo && columnsTwo != linesOne){
            System.out.println("Your matrices can't be multiplied");
            scanner.close();
            return;
        }

        scanner.nextLine(); //space between numbers

        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++){
                if (scanner.hasNextDouble()){
                    double matrixElement = scanner.nextDouble();
                    firstMatrix[i][j] = matrixElement;
                } else {
                    System.out.println("File doesn't have necessary information");
                    return;
                }
            }
        }
        scanner.nextLine(); //space between numbers

        for (int i = 0; i < secondMatrix.length; i++){
            for (int j = 0; j < secondMatrix[i].length; j++){
                if (scanner.hasNextDouble()){
                    double matrixElement = scanner.nextDouble();
                    secondMatrix[i][j] = matrixElement;
                } else {
                    System.out.println("File doesn't have necessary information");
                    return;
                }
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
}
