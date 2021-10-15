package com.company.homeworkFive.task10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeserializerOfBoxes {
    public static void createFiveBoxesAndSerializeThemAndDeserializeThemAndSortAndWriteTheBiggest() throws IOException, ClassNotFoundException {
        Box box1 = new Box(10,2,1);
        Box box2 = new Box(44,5,56);
        Box box3 = new Box(3,58,9);
        Box box4 = new Box(7,1,212);
        Box box5 = new Box(113,12,1);

        FileOutputStream fos = new FileOutputStream("src/com/company/homeworkFive/task10/BOXES.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(box1);
        oos.writeObject(box2);
        oos.writeObject(box3);
        oos.writeObject(box4);
        oos.writeObject(box5);

        FileInputStream fis = new FileInputStream("src/com/company/homeworkFive/task10/BOXES.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Box readBox1 = (Box) ois.readObject();
        Box readBox2 = (Box) ois.readObject();
        Box readBox3 = (Box) ois.readObject();
        Box readBox4 = (Box) ois.readObject();
        Box readBox5 = (Box) ois.readObject();
        List<Box> boxList = new ArrayList<>();
        boxList.add(readBox1);
        boxList.add(readBox2);
        boxList.add(readBox3);
        boxList.add(readBox4);
        boxList.add(readBox5);

        Collections.sort(boxList);
        System.out.println(boxList);

        PrintWriter writer = new PrintWriter("src/com/company/homeworkFive/task10/OUTPUT.txt", StandardCharsets.UTF_8);
        writer.println("Biggest box volume is " + boxList.get(boxList.size() - 1).getVolume());
        writer.close();
    }
}
