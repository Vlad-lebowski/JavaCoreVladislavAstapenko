package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // task 1
        System.out.println("Task 1");
        int numberOfElements = (int)Math.floor(Math.random() * 11 + 10);
        int[] firstArray = new int[numberOfElements];
        int sum = 0;
        int sumWithoutNumber = 0;
        int number = (int)Math.floor(Math.random() * 6 + 15);
        for (int i = 0; i < firstArray.length; i++){
            firstArray[i] = (int)Math.floor(Math.random() * 16 + 15);
            sum += firstArray[i];
            if (firstArray[i] == number){
                continue;
            }
            sumWithoutNumber += firstArray[i];
        }
        System.out.println(Arrays.toString(firstArray));
        System.out.println("Whole sum is " + sum);
        System.out.println("Sum without " + number + " is " + sumWithoutNumber);
        System.out.println();

        //task 2
        System.out.println("Task 2");
        int sumFibonacci = 0;
        int fibonacciOne, fibonacciTwo = 0, fibonacciThree = 1;
        int index = (int)Math.floor(Math.random() * 10 + 1);
        System.out.println("Index is " + index);
        for (int i = 2; i <= index; i++) { // start with 2 to correctly begin fibonacci sequence
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = fibonacciThree;
            fibonacciThree = fibonacciOne + fibonacciTwo;
            if (fibonacciThree % 2 == 0){
                sumFibonacci += fibonacciThree;
            }
        }
        System.out.println("Sum of even Fibonacci numbers up to index " + index + " is " + sumFibonacci);
        System.out.println();

        //task 3
        System.out.println("Task 3");

        int[] secondArray = new int[numberOfElements];
        for (int i = 0; i < secondArray.length; i++){
            secondArray[i] = (int)Math.floor(Math.random() * 101);
        }
        System.out.println("Initial array is " + Arrays.toString(secondArray));

        for (int i = 0; i < secondArray.length / 2; i++){
            int temp = secondArray[i];
            secondArray[i] = secondArray[secondArray.length - i - 1];
            secondArray[secondArray.length - i - 1] = temp;
        }
        System.out.println("Inverted array is " + Arrays.toString(secondArray));
        System.out.println();

        //task 4
        System.out.println("Task 4");
        int rows = (int)Math.floor(Math.random() * 3 + 3);
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++){
            int rowNumbers = (int)Math.floor(Math.random() * 3 + 3);
            matrix[i] = new int[rowNumbers];
        }
        int countOfPositive = 0;
        int countOfNegative = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.floor(Math.random() * 201 - 100);
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j] > 0){
                    countOfPositive += 1;
                }
                if (matrix[i][j] < 0){
                    countOfNegative += 1;
                }
            }
            System.out.println();
        }
        if (countOfPositive > countOfNegative){
            System.out.println("There are more positive numbers than negative.");
        } else if (countOfNegative > countOfPositive) {
            System.out.println("There are more negative numbers than positive.");
        } else {
            System.out.println("The amount of positive and negative numbers is the same.");
        }
        System.out.println();

        //task 5
        System.out.println("Task 5");
        int dimensions = (int)Math.floor(Math.random() * 3 + 3);
        int[][] squareMatrix = new int[dimensions][dimensions];
        for (int i = 0; i < squareMatrix.length; i++){
            for (int j = 0; j < squareMatrix[i].length; j++) {
                squareMatrix[i][j] = (int) Math.floor(Math.random()*2);
                System.out.print(squareMatrix[i][j] + " ");
            }
            System.out.println();
        }
        boolean isLowerTriangularMatrix = true;
        outer: for (int i = 0; i < squareMatrix.length; i++){
            for (int j = 0; j < i; j++) {
                if (squareMatrix[i][j] != 0){
                    isLowerTriangularMatrix = false;
                    break outer;
                }
            }
        }
        if (!isLowerTriangularMatrix){
            System.out.println("Matrix is not a lower triangular matrix.");
            System.out.println("Now let's make it a a lower triangular matrix and print it again.");
            for (int i = 0; i < squareMatrix.length; i++){
                for (int j = 0; j < i; j++) {
                    if (squareMatrix[i][j] != 0){
                        squareMatrix[i][j] = 0;
                    }
                }
            }
            for (int[] ints : squareMatrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is a lower triangular matrix.");
        }
        System.out.println();

        //task 6
        System.out.println("Task 6");
        int dimensionsForMatrices = (int)Math.floor(Math.random() * 3 + 3);
        int[][] firstMatrix = new int[dimensionsForMatrices][dimensionsForMatrices];
        int[][] secondMatrix = new int[dimensionsForMatrices][dimensionsForMatrices];
        System.out.println("\nFirst matrix");
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = (int) Math.floor(Math.random() * 201 - 100);
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSecond matrix");
        for (int i = 0; i < secondMatrix.length; i++){
            for (int j = 0; j < secondMatrix[i].length; j++) {
                secondMatrix[i][j] = (int) Math.floor(Math.random() * 201 - 100);
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] sumOfMatrices = new int[dimensionsForMatrices][dimensionsForMatrices];
        int[][] differenceOfMatrices = new int[dimensionsForMatrices][dimensionsForMatrices];

        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++) {
                sumOfMatrices[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                differenceOfMatrices[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }

        System.out.println("\nSum of matrices:");
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++){
                System.out.print(sumOfMatrices[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nDifference of matrices");
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++){
                System.out.print(differenceOfMatrices[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //task 7
        System.out.println("Task 7");

        System.out.println();

        //task8
        System.out.println("Task 8");
        int[] score = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int[] money = new int[score.length];
        int minMoneySum = 0;
        money[0] = 1;
        for (int i = 0; i < score.length; i++){
            if (i - 1 >= 0 && score[i] > score[i - 1]){
                money[i] += money[i - 1] + 1;
            }
            if (i - 1 >= 0 && score[i] <= score[i - 1]){
                money[i] = 1;
                if (i + 1 < score.length && score[i] > score[i + 1]){
                    int j = i;
                    while (j + 1 < score.length && score[j] > score[j + 1]){
                        money[j] += 1;
                        j--;
                        if(money[j] > money[j - 1] && money[j] > money[j + 1]){
                            break;
                        }
                    }
                }
            }
        }

        for (int j : money) {
            minMoneySum += j;
        }
        System.out.println(Arrays.toString(money));
        System.out.println("Minimum sum of money is " + minMoneySum);
    }
}
