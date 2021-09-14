package com.company.test;

import com.company.homeworkTwo.Box;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main (String[] args){ //... - параметры переменной среды
        System.out.println("Task 5");
        Pattern pattern = Pattern.compile("([ЁёА-я]*[Сс]+[ЁёА-я]*[Сс]+[ЁёА-я]*[Сс]+[ЁёА-я]*)");
        Matcher matcher = pattern.matcher("ссср торт привет ссссссс сесесесесе лампа секрет секретсс лол кек семья сесмьяс, компьютер, сессия");
        long count = matcher.results().count();
        System.out.println("Number of russian words with 3 or more letters \"с\" is " + count);
        System.out.println();

        System.out.println("Task 6");
        String exampleForLongest = "We need to find the longest possible word in this string. You hear me? The longest!!!";
        String longest = Arrays.stream(exampleForLongest.split("\\s+|!+|[.]+|,+|[?]+"))
                .max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("The longest word is \"" + longest + "\"");
        System.out.println();

        System.out.println("Task 7");
        Pattern secondPattern = Pattern.compile("\\b[Аа]+[ЁёА-я]*[Аа]+\\b");
        Matcher secondMatcher = secondPattern.matcher("Аргентина");
        if(secondMatcher.find()){
            System.out.println("There is a russian word that starts and ends with the letter \"А\".");
        } else {
            System.out.println("There is no russian word that starts and ends with the letter \"А\"");
        }
        System.out.println();

        System.out.println("Task 8");
        String text = "Аргентина, америка. 8761-1274-7612-9091, это был номер карты. 31232133123 - а это нет.";
        Pattern thirdPattern = Pattern.compile("\\b[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}\\b");
        Matcher thirdMatcher = thirdPattern.matcher(text);
        while (thirdMatcher.find()) {
            System.out.println("Card number is " + text.substring(thirdMatcher.start(), thirdMatcher.end()));
        }
        System.out.println();

        System.out.println("Task 9");
        String anotherText = "Аргентина, америка. 8761-1274-7612-9091, это был номер карты. 31232133123 - а это нет.";
        String word = "номер";
        Pattern fourthPattern = Pattern.compile(word);
        Matcher fourthMatcher = fourthPattern.matcher(anotherText);
        if(fourthMatcher.find()){
            System.out.println("There is such word and it is on the position " + fourthMatcher.start());
        } else {
            System.out.println("There is no such word.");
        }
        System.out.println();

        System.out.println("Task 10");
        Box box = new Box("Box[2]");
        box.typeOfBox();
        box = new Box("Box[15,17,20]");
        box.typeOfBox();
        box = new Box("Box[17,20]");
        box.typeOfBox();
    }
}
