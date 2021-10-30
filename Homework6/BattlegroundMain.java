package com.company.homeworkSix;

import com.company.homeworkSix.country.Country;
import com.company.homeworkSix.factory.NeutralFactory;
import com.company.homeworkSix.factory.Storage;

public class BattlegroundMain {

    public static void main(String[] args) throws InterruptedException {

        Storage storage = new Storage();
        EndOfWarFlag flag = new EndOfWarFlag();

        NeutralFactory neutralFactory = new NeutralFactory(storage, flag);

        Country firstCountry = new Country(storage, flag);
        Country secondCountry = new Country(storage, flag);

        Thread thread = new Thread(neutralFactory);
        Thread thread_1 = new Thread(firstCountry);
        Thread thread_2 = new Thread(secondCountry);

        thread.start();
        thread_1.start();
        thread_2.start();
        thread.join();
        thread_1.join();
        thread_2.join();
    }
}
