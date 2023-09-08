package org.example;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is for CRUD functions.
 */
public class WordCRUD implements ICRUD{
    ArrayList<Word> w;
    Scanner s;
    int i; //반복문

    WordCRUD(Scanner s){
        this.s = s;
        w = new ArrayList<>();
    }
    @Override
    public void add() {
        try{
            System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
            byte dif = s.nextByte();
            String newWord = s.next();
            s.nextLine(); //버퍼 비우기
            System.out.print("뜻 입력: ");
            String meaning = s.nextLine();
            w.add(new Word(dif, newWord, meaning));
            System.out.println();
            System.out.println("새 단어가 단어장에 추가되었습니다 !!!");
        } catch(Exception e){
            s.nextLine();
            System.out.println("다시 시도해 주세요.");
        }
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

    public void listAll(){
        System.out.println("--------------------------------");
        for(i=0; i<w.size(); i++){
            System.out.println((i+1) + " " + w.get(i).toString());
        }
        System.out.println("--------------------------------");
    }
}
