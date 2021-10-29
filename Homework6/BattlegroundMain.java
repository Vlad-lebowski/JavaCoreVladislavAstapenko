package com.company.homeworkSix;

import com.company.homeworkSix.countries.Country;
import com.company.homeworkSix.factory.NeutralFactory;

public class BattlegroundMain {

    public static void main(String[] args) throws InterruptedException {

        NeutralFactory neutralFactory = new NeutralFactory();

        //setting up business relationships
        Country firstCountry = new Country(neutralFactory);
        Country secondCountry = new Country(neutralFactory);
        neutralFactory.setFirstCountry(firstCountry);
        neutralFactory.setSecondCountry(secondCountry);

        //setting up rivals
        firstCountry.setSecondCountry(secondCountry);
        secondCountry.setSecondCountry(firstCountry);

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
