package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * This class is for CRUD functions.
 */
public class WordCRUD implements ICRUD{
    ArrayList<Word> w;
    Scanner s;
    int i; //반복문
    byte count;
    final String fileName = "voca.txt";

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
        /*try{
            System.out.print("=> 수정할 단어 검색: ");
            String wordFind = s.next();
            showList(wordFind);
            System.out.print("=> 수정할 번호 선택: ");
            byte numberForUpdate = s.nextByte();

        }*/
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

    public void showList(String wordFind){
        count = 1;
        System.out.println("--------------------------------");
        for(i=0; i<w.size(); i++){
            if(w.get(i).getNewWord().contains(wordFind)) {
                System.out.println((count) + " " + w.get(i).toString());
                count ++;
            }
        }
        System.out.println("--------------------------------");
    }

    public void saveFile(){
        try {
            File file = new File(fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (Word word : w) {
                pw.println(word.toSaveString());
            }
            System.out.println("모든 단어 파일 저장 완료 !!!");
            pw.close();
        }catch(IOException e){
            System.out.println("다시 시도해주세요");
        }
    }

    public void loadFile(){
        try{
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            byte count = 0;
            while((line=br.readLine()) != null){
                String[] data = line.split("\\|");
                byte difficulty = Byte.parseByte(data[0]);
                String newWord = data[1];
                String meaning = data[2];
                w.add(new Word(difficulty, newWord, meaning));
                count++;
            }
            System.out.println("=> " + count + "개 단어 로딩 완료!\n");
        }catch(IOException e){
            System.out.println("다시 시도해주세요");
        }
    }
}
