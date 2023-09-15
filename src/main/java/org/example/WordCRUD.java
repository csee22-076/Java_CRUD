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
    ArrayList<Integer> address = new ArrayList<>(); //

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
    public void update() {
        try{
            //단어 검색
            System.out.print("=> 수정할 단어 검색: ");
            String wordFind = s.next();
            address = showListAndReturnIndex(wordFind);
            //수정할 번호 입력 후 수정할 단어의 인덱스 저장
            System.out.print("=> 수정할 번호 선택: ");
            int numberOfIndex = address.get(s.nextInt()-1);
            //수정할 단어의 뜻 입력
            s.nextLine(); //버퍼 비우기
            System.out.print("=> 뜻 입력: ");
            String newMeaning = s.nextLine();
            //단어 수정
            Word wordForUpdate = w.get(numberOfIndex);
            wordForUpdate.setMeaning(newMeaning);
            w.set(numberOfIndex,wordForUpdate);
            System.out.println("\n단어 수정이 성공적으로 되었습니다!!");
        }catch(Exception e){
            System.out.println("다시 시도해 주세요.");
            s.nextLine();
        }
    }

    @Override
    public void delete() {
        try{
            System.out.print("=> 삭제할 단어 검색: ");
            String wordFind = s.next();
            address = showListAndReturnIndex(wordFind);
            System.out.print("=> 삭제할 번호 선택: ");
            int numberOfIndex = address.get(s.nextInt()-1);
            s.nextLine(); //버퍼 비우기
            System.out.print("=> 정말로 삭제하시겠습니까?(Y/N) ");
            String check = s.next();
            if(check.equalsIgnoreCase("Y")){
                w.remove(numberOfIndex);
                System.out.println("\n선택한 단어 삭제 완료 !!!");
            }
            else if(check.equalsIgnoreCase("N")){
                System.out.println("\n취소되었습니다.");
            }
            else throw new Exception();
        }catch(Exception e){
            System.out.println("다시 시도해 주세요.");
            s.nextLine();
        }
    }

    @Override
    public void select() {
        try{
            System.out.print("=> 레벨(1:초급, 2:중급, 3:고급) 선택: ");
            byte difficulty = s.nextByte();
            if(difficulty < 1 || difficulty > 3) throw new Exception();
            showListAboutDifficulty(difficulty);
        }catch(Exception e){
            System.out.println("다시 시도해 주세요.");
            s.nextLine();
        }
    }

    public void findWord(){
        try{
            System.out.print("=> 검색할 단어 입력: ");
            String wordFind = s.next();
            showListAndReturnIndex(wordFind);
        }catch(Exception e){
            System.out.println("다시 시도해 주세요.");
            s.nextLine();
        }
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
            count = 0;
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

    public ArrayList<Integer> showListAndReturnIndex(String wordFind) {
        ArrayList<Integer> address = new ArrayList<>();
        count = 1;
        System.out.println("--------------------------------");
        for (i = 0; i < w.size(); i++) {
            if (w.get(i).getNewWord().contains(wordFind)) {
                System.out.println((count) + " " + w.get(i).toString());
                address.add(i);
                count++;
            }
        }
        System.out.println("--------------------------------");
        return address;
    }

    public void listAll() {
        System.out.println("--------------------------------");
        for (i = 0; i < w.size(); i++) {
            System.out.println((i + 1) + " " + w.get(i).toString());
        }
        System.out.println("--------------------------------");
    }

    public void showListAboutDifficulty(byte diff) {
        count = 1;
        System.out.println("--------------------------------");
        for (i = 0; i < w.size(); i++) {
            if (w.get(i).getDifficulty()==diff) {
                System.out.println((count) + " " + w.get(i).toString());
                count++;
            }
        }
        System.out.println("--------------------------------");
    }
}