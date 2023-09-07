package org.example;

import java.util.Scanner;
import java.util.ArrayList;
public class WordCRUD implements ICRUD{
    ArrayList<Word> w;
    Scanner s;
    WordCRUD(Scanner s){
        this.s = s;
        w = new ArrayList<>();
    }
    @Override
    public int add() {

        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select(Object o) {

    }
}
