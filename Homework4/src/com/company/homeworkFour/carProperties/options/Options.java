package com.company.homeworkFour.carProperties.options;

import java.util.ArrayList;
import java.util.List;

public class Options {
    private final List<Optionable> optionList;

    public Options() {
        optionList = new ArrayList<>();
    }

    public void addOption(Optionable option) {
        optionList.add(option);
    }

    public void deleteOptions(Optionable option) {
        optionList.remove(option);
    }

    public List<Optionable> getOptionList() {
        return optionList;
    }
}
