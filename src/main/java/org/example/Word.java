package org.example;
public class Word {
    private byte difficulty;
    private String newWord;
    private String meaning;

    Word(){}
    Word(byte difficulty, String newWord, String meaning){
        this.difficulty = difficulty;
        this.newWord = newWord;
        this.meaning = meaning;
    }
    public byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(byte difficulty) {
        this.difficulty = difficulty;
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
