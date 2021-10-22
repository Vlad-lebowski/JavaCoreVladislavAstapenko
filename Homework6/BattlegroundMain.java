package com.company.homeworkSix;

import com.company.homeworkSix.countries.FirstCountry;
import com.company.homeworkSix.countries.SecondCountry;
import com.company.homeworkSix.factory.NeutralFactory;

public class BattlegroundMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NeutralFactory());
        Thread thread_1 = new Thread(new FirstCountry());
        Thread thread_2 = new Thread(new SecondCountry());

        thread.start();
        thread_1.start();
        thread_2.start();
        thread.join();
        thread_1.join();
        thread_2.join();
    }
}
