package com.company.homeworkFive;

import com.company.homeworkFive.task1.StringInputOutput;
import com.company.homeworkFive.task10.DeserializerOfBoxes;
import com.company.homeworkFive.task2.MatricesMultiplier;
import com.company.homeworkFive.task3.NumbersInputUntilStopWord;
import com.company.homeworkFive.task4.NumbersInputUntilStopWordAndStatusOption;
import com.company.homeworkFive.task5.MyCalculator;
import com.company.homeworkFive.task6.MatricesMultiplierFromFile;
import com.company.homeworkFive.task7.ReversedLines;
import com.company.homeworkFive.task8.WriteSimilarLinesFromFiles;
import com.company.homeworkFive.task9.Box;
import com.company.homeworkFive.task9.CreatorOfFiveBoxes;

import java.io.IOException;

public class MainFive {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Task 1
        //StringInputOutput.readStringsAndPrintThem();

        //Task 2
        //MatricesMultiplier.multiplyTwoMatrices();

        //Task 3
        //NumbersInputUntilStopWord.inputNumbersUntilStopWord();

        //Task 4
        //NumbersInputUntilStopWordAndStatusOption.inputNumbersUntilStopWordWithStatusOption();

        //Task 5
        //MyCalculator.operationWithTwoNumbers();

        //Task 6
        //MatricesMultiplierFromFile.multiplyTwoMatricesFromFile();

        //Task 7
        //ReversedLines.reverseLinesFromFileAndWriteThem();

        //Task 8
        //WriteSimilarLinesFromFiles.writeSimilarLinesFromTwoFiles();

        //Task 9
        //CreatorOfFiveBoxes.createFiveBoxesAndSerializeThem();

        //Task 10
        DeserializerOfBoxes.createFiveBoxesAndSerializeThemAndDeserializeThemAndSortAndWriteTheBiggest();
    }
}
