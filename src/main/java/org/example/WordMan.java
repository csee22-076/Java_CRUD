package org.example;

import java.util.Scanner;

public class WordMan {
    Scanner s = new Scanner(System.in);
    private byte menu;


    public void run(){
        WordCRUD wc = new WordCRUD(s);
        System.out.println("*** 영단어 마스터 ***");
        while(true){
            printMenu();
            menu = selectMenu();
            if(menu==0) break;
            else if(menu==1){

            }
            else if(menu==2){

            }
            else if(menu==3){

            }
            else if(menu==4){
                wc.add();
            }
            else if(menu==5){

            }
            else if(menu==6){

            }
            else if(menu==7){

            }
            else continue;
        }
    }

    public void printMenu(){
        System.out.println();
        System.out.println("********************");
        System.out.println("1. 모든 단어 보기");
        System.out.println("2. 수준별 단어 보기");
        System.out.println("3. 단어 검색");
        System.out.println("4. 단어 추가");
        System.out.println("5. 단어 수정");
        System.out.println("6. 단어 삭제");
        System.out.println("7. 파일 저장");
        System.out.println("0. 나가기");
        System.out.println("********************");
    }

    public byte selectMenu(){
        System.out.print("=> 원하는 메뉴는? ");
        try{
            return s.nextByte();
        } catch(Exception e) {
            System.out.println("숫자를 입력해 주세요.");
            s.nextLine();
            return 9;
        }
    }
}
