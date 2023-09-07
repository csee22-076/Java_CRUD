package org.example;
public class Word {
    private byte difficulty;
    private int number;
    private String newWord;
    private String meaning;

    public byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(byte difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNewWord() {
        return newWord;
    }

    public void setNewWord(String newWord) {
        this.newWord = newWord;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
