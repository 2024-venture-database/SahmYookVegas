package com.SYVegas.playgame;

import com.SYVegas.common.CurrentUser;
import org.apache.ibatis.session.SqlSession;

import java.util.Currency;
import java.util.Objects;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class PlayGame {
    private int[] chip = new int[5];
    private int[] result_chip = new int[5];
    private int result = 0;
    private boolean bool = true;
    private int gameNum;
    private float gameRate;
    private GameMapper mapper;



    public void gamePlay(CurrentUser currentUser) {
        do {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("삼육베가스의 카지노 게임 환영합니다. ");
            System.out.println("==================================");
            System.out.println("1.[미니룰렛],  2. [익스트림룰렛]  9.그만할래요");
            System.out.println("==================================");
            System.out.print("어떤 게임을 하시겠습니까?(숫자로입력) : ");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("[미니룰렛]을 선택하셨습니다.");
                startMiniRulet(currentUser);
            }else if(num==2){
                System.out.println("[빅룰렛]을 선택하셨습니다.");
                startExtremeRulet(currentUser);
            }else if(num==9){
                System.out.println("게임을 그만합니다. 이용해주셔서 감사합니다.");
                return;
            }else{
                System.out.println("해당게임은 없습니다. 다시 선택해주세요.");
            }

        }while(true);
    }

    public float getGameRate(int gameNum){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(GameMapper.class);

        gameRate= mapper.getGameRate(gameNum);
        return gameRate;
    }

    public void startMiniRulet(CurrentUser currentUser){
        Scanner sc=new Scanner(System.in);
        float ruletRate=getGameRate(1);
        System.out.println();
        System.out.println("해당 게임은 1~3까지의 룰렛에서 하나의 수를 선택하여 맞추는 게임입니다.");
        System.out.println("현재 해당 게임의 배당율은 "+ruletRate+"배 입니다.");
        System.out.print("입장하시겠습니까? (Y or N) : ");
        String str =sc.nextLine();
        if(Objects.equals(str, "Y")){
            System.out.println("게임에 입장합니다.");
            miniRulet(currentUser);
            return;
        }else {
            System.out.println("게임에서 나갑니다.");
            return;
        }
    }

    public void miniRulet(CurrentUser currentUser){
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("환영합니다.");
            System.out.print("1~3까지의 숫자중 하나를 입력해 주십시오 : ");
            int num = sc.nextInt();
            int resultNum = (int) (Math.random() * 2 + 1);
            if (num == resultNum) {
                currentUser.setGameResult("win");
            } else {
                currentUser.setGameResult("lose");
            }
            betting(currentUser);
            System.out.println();
            System.out.println("룰렛 돌아가는 중.....");
            System.out.println();
            System.out.println("룰렛이 멈췄다!");
            System.out.println();
            System.out.println("룰렛이 가리키는 숫자는 "+resultNum+" 입니다.!!");
            System.out.println();
            gameResult(currentUser);
            System.out.println();
            System.out.print("게임을 계속 하시겠습니까?(Y or N) :");
            sc.nextLine();
            String str=sc.nextLine();
            if(Objects.equals(str, "Y")){
                System.out.println("게임을 계속 진행합니다.");
            }else{
                System.out.println("게임 진행을 멈춥니다.");
                break;
            }
        }while (true);
    }

    public void startExtremeRulet(CurrentUser currentUser){
        Scanner sc=new Scanner(System.in);
        float ruletRate=getGameRate(2);
        System.out.println();
        System.out.println("해당 게임은 1~20까지의 룰렛에서 하나의 수를 선택하여 맞추는 게임입니다.");
        System.out.println("현재 해당 게임의 배당율은 "+ruletRate+"배 입니다.");
        System.out.print("입장하시겠습니까? (Y or N) : ");
        String str =sc.nextLine();
        if(Objects.equals(str, "Y")){
            System.out.println("게임에 입장합니다.");
            extremeRulet(currentUser);
            return;

        }else {
            System.out.println("게임에서 나갑니다.");
            return;
        }
    }
    public void extremeRulet(CurrentUser currentUser){
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("환영합니다.");
            System.out.print("1~20까지의 숫자중 하나를 입력해 주십시오 : ");
            int num = sc.nextInt();
            int resultNum = (int) (Math.random() * 19 + 1);
            if (num == resultNum) {
                currentUser.setGameResult("win");
            } else {
                currentUser.setGameResult("lose");
            }
            betting(currentUser);
            System.out.println();
            System.out.println("룰렛 돌아가는 중.....");
            System.out.println();
            System.out.println("룰렛이 멈췄다!");
            System.out.println();
            System.out.println("룰렛이 가리키는 숫자는 "+resultNum+" 입니다.!!");
            System.out.println();
            gameResult(currentUser);
            System.out.println();
            System.out.println("게임을 계속 하시겠습니까?(Y or N) :");
            sc.nextLine();
            String str=sc.nextLine();
            if(Objects.equals(str, "Y")){
                System.out.println("게임을 계속 진행합니다.");
            }else{
                System.out.println("게임 진행을 멈춥니다.");
                return;
            }
        }while (true);
    }




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
            System.out.print("[1. 배팅]     [2. 재선택]\n 선택 : ");
            int num = sc.nextInt();
            if (num == 1) {
                if (currentUser.getChip100() >= chip[0] && currentUser.getChip50() >= chip[1] && currentUser.getChip10() >= chip[2] && currentUser.getChip5() >= chip[3] && currentUser.getChip1() >= chip[4]) {
                    break;
                } else {
                    System.out.println("보유한 칩 개수가 모자랍니다.재선택 합니다.");
                }
            } else {
                System.out.println("배팅할 칩을 재선택 합니다.");
            }
        } while (true);
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
        result = chip[0] * 1000000 + chip[1] * 500000 + chip[2] * 100000 + chip[3] * 50000 + chip[4] * 10000;
    }

    public void gameResult(CurrentUser currentUser) {
        System.out.println();
        System.out.println();
        if (currentUser.getGameResult() == "win") {
            result =(int)(result*gameRate);
            result_chip[0] = result / 1000000;
            result %= 1000000;
            result_chip[1] = result / 500000;
            result %= 500000;
            result_chip[2] = result / 100000;
            result %= 100000;
            result_chip[3] = result / 50000;
            result %= 50000;
            result_chip[4] = result / 10000;
            result %= 10000;

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
            for (int i = 0; i < chip.length; i++) {
                chip[i] = 0;
            }
        } else {
            System.out.println("게임에서 패배하셨습니다. 배팅하신 칩은 모두 사라집니다.");
            for (int i = 0; i < chip.length; i++) {
                chip[i] = 0;
            }
        }
        System.out.println(currentUser.toString());
    }
}

