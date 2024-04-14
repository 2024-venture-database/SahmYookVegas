package com.SYVegas.playgame;

import com.SYVegas.common.CurrentUser;

import java.util.Currency;
import java.util.Scanner;

public class PlayGame {
    private int[] chip=new int[5];
    private int[] result_chip=new int[5];
    private int result=0;
    private boolean bool=true;
    public float gameRate =0;

    public void betting(CurrentUser currentUser) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(currentUser.toString());
            System.out.println();
            System.out.println("이번 게임에서 사용할 칩을 선택해주십시오");
            System.out.print("[칩100] : ");
            chip[0] = sc.nextInt();
            System.out.print("[칩50] : ");
            chip[1] = sc.nextInt();
            System.out.print("[칩10] : ");
            chip[2] = sc.nextInt();
            System.out.print("[칩5] : ");
            chip[3] = sc.nextInt();
            System.out.print("[칩1] : ");
            chip[4] = sc.nextInt();
            System.out.println("===============================");
            System.out.println("현재 선택한 칩은"
                    + '\n' + "[칩100] : " + chip[0] + "개"
                    + '\n' + "[칩50] : " + chip[1] + "개"
                    + '\n' + "[칩10] : " + chip[2] + "개"
                    + '\n' + "[칩5] : " + chip[3] + "개"
                    + '\n' + "[칩1] : " + chip[4] + "개"
                    + '\n' + "입니다.");
            System.out.println("===============================");
            System.out.println("맞으시면 [1. 배팅]을 선택해주시고, 다시 배팅하시려면 [2. 재선택]을 선택해주십시오");
            System.out.print("[1. 배팅]     [2. 재선택]\n   선택 : ");
            int num = sc.nextInt();
            if (num==1) {
                if (currentUser.getChip100() >= chip[0] && currentUser.getChip50() >= chip[1] && currentUser.getChip10() >= chip[2] && currentUser.getChip5() >= chip[3] && currentUser.getChip1() >= chip[4]){
                    bool=false;
                }else {
                    System.out.println("보유한 칩 개수가 모자랍니다.재선택 합니다.");
                }
            }else {
                System.out.println("배팅할 칩을 재선택 합니다.");
            }
        } while (bool);
        System.out.println();
        System.out.println("===============================");
        System.out.println("최종 선택한 칩은"
                + '\n' + "[칩100] : " + chip[0] + "개"
                + '\n' + "[칩50] : " + chip[1] + "개"
                + '\n' + "[칩10] : " + chip[2] + "개"
                + '\n' + "[칩5] : " + chip[3] + "개"
                + '\n' + "[칩1] : " + chip[4] + "개"
                + '\n' + "입니다.");
        currentUser.setChip100(currentUser.getChip100() - chip[0]);
        currentUser.setChip50(currentUser.getChip50() - chip[1]);
        currentUser.setChip10(currentUser.getChip10() - chip[2]);
        currentUser.setChip5(currentUser.getChip5() - chip[3]);
        currentUser.setChip1(currentUser.getChip1() - chip[4]);
        System.out.println("===============================");
        System.out.println("배팅후 남은 보유칩");
        System.out.println(currentUser.toString());
        System.out.println("배팅이 완료되었습니다. 게임을 시작합니다.");
        result=chip[0]*1000000+chip[1]*500000+chip[2]*100000+chip[3]*50000+chip[4]*10000;
    }

    public void gameResult(CurrentUser currentUser) {
        if(currentUser.getGameResult()=="win"){
            gameRate=2;
            result*= (int) gameRate;
            result_chip[0]=result/1000000;
            result%=1000000;
            result_chip[1]=result/500000;
            result%=500000;
            result_chip[2]=result/100000;
            result%=100000;
            result_chip[3]=result/50000;
            result%=50000;
            result_chip[4]=result/10000;
            result%=10000;


            System.out.println("축하합니다. 게임에서 승리하셨습니다.");
            System.out.println("===============================");
            System.out.println("승리하여 획득한 칩은"
                    + '\n' + "[칩100] : " + result_chip[0] + "개"
                    + '\n' + "[칩50] : " + result_chip[1] + "개"
                    + '\n' + "[칩10] : " + result_chip[2] + "개"
                    + '\n' + "[칩5] : " + result_chip[3] + "개"
                    + '\n' + "[칩1] : " + result_chip[4] + "개"
                    + '\n' + "입니다.");
            System.out.println("===============================");
            System.out.println("획득하신 칩을 보유칩에 추가합니다.");
            currentUser.setChip100(currentUser.getChip100() + result_chip[0]);
            currentUser.setChip50(currentUser.getChip50() + result_chip[1]);
            currentUser.setChip10(currentUser.getChip10() + result_chip[2]);
            currentUser.setChip5(currentUser.getChip5() + result_chip[3]);
            currentUser.setChip1(currentUser.getChip1() + result_chip[4]);
            System.out.println(currentUser.toString());
        }

        else{
            System.out.println("게임에서 패배하셨습니다.");
        }
    }
}

