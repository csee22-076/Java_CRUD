package org.example;
import java.util.ArrayList;
public class Word {
    private ArrayList<Byte> dif = new ArrayList<>();
    private ArrayList<String> newWord = new ArrayList<>();
    private ArrayList<String> meaning = new ArrayList<>();

    public ArrayList<Byte> getDif() {
        return dif;
    }

    public ArrayList<String> getNewWord() {
        return newWord;
    }

    public ArrayList<String> getMeaning() {
        return meaning;
    }

    public void setDif(ArrayList<Byte> dif) {
        this.dif = dif;
    }

    public void setNewWord(ArrayList<String> newWord) {
        this.newWord = newWord;
    }

    public void setMeaning(ArrayList<String> meaning) {
        this.meaning = meaning;
    }
}
