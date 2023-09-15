package org.example;

/**
 * This class deals with data of word.
 */
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

    @Override
    public String toString() {
        String stringForDifficulty;
        if(difficulty==1) stringForDifficulty = String.format("%-3s", "*");
        else if(difficulty==2) stringForDifficulty = String.format("%-3s", "**");
        else stringForDifficulty = String.format("%-3s", "***");
        /*for(int i=0; i<difficulty; i++){
            stringForDifficulty += "*"; //StringBuilder? .append("*")?
        }*/
        return stringForDifficulty + String.format("%15s", newWord) + "  " + meaning;
    }
    
    public String toSaveString(){
        return difficulty + "|" + newWord + "|" + meaning;
    }
}
