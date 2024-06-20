package ru.kurochkin.readjson.regionalbloc;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class RegionalBloc {
    private String acronym;
    private String name;
    private ArrayList<String> otherAcronyms;
    private ArrayList<String> otherNames;

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public void setOtherAcronyms(ArrayList<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public ArrayList<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(ArrayList<String> otherNames) {
        this.otherNames = otherNames;
    }
}
