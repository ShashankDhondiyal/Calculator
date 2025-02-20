package com.myapps;
import java.util.ArrayList;

public class Logic {

    ArrayList<String> equation = new ArrayList<>();

    public void addToEquation(String value) {
        equation.add(value);
    }

    public String getEquation() {
        return String.join("", equation);
    }

    public void clearEquation() {
        equation.clear();
    }
}