package com.company.homeworkThree.carProperties;

import java.util.ArrayList;
import java.util.List;

public class Options {
    private final List<String> optionList;

    public Options() {
        optionList = new ArrayList<>();
    }

    public void addOption(String option) {
        optionList.add(option);
    }

    public void deleteOptions(String option) {
        optionList.remove(option);
    }

    public List<String> getOptionList() {
        return optionList;
    }
}
