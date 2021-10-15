package com.company.homeworkFive.task9;

import java.io.*;

public class CreatorOfFiveBoxes {
    public static void createFiveBoxesAndSerializeThem() throws IOException, ClassNotFoundException {
        Box box1 = new Box(1,2,3);
        Box box2 = new Box(4,5,6);
        Box box3 = new Box(7,8,9);
        Box box4 = new Box(10,11,12);
        Box box5 = new Box(13,14,15);

        FileOutputStream fos = new FileOutputStream("src/com/company/homeworkFive/task9/BOXES.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(box1);
        oos.writeObject(box2);
        oos.writeObject(box3);
        oos.writeObject(box4);
        oos.writeObject(box5);

        FileInputStream fis = new FileInputStream("src/com/company/homeworkFive/task9/BOXES.txt"); //just checking
        ObjectInputStream ois = new ObjectInputStream(fis);
        Box box = (Box) ois.readObject();
        System.out.println(box);
    }
}
