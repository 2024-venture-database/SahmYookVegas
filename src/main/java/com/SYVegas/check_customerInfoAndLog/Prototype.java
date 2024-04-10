package com.SYVegas.check_customerInfoAndLog;

import com.SYVegas.check_customerInfoAndLog.check_Log.ManagerMenuLog;
import com.SYVegas.check_customerInfoAndLog.check_customerInfo.ManagerMenuCustomer;

import java.util.Scanner;

public class Prototype {
    public void managerPrototypeStart() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("======================관리자 메뉴======================");
            System.out.println("1. 모든 회원의 정보를 조회거나 수정,삭제 합니다.");
            System.out.println("2. 모든 로그를 확인합니다.");
            System.out.println("9. 로그인 화면으로 돌아갑니다.");
            System.out.print("실행할 메뉴를 선택하십시오 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    manageCustomerInfo();
                    break;
                case 2:
                    manageLog();
                    break;
                case 9:
                    return;
            }
        } while (true);

    }
    private static void manageCustomerInfo(){
        Scanner sc = new Scanner(System.in);
        ManagerMenuCustomer managerMenuCustomer = new ManagerMenuCustomer();
        do{
            managerMenuCustomer.selectAllManagerMenuCustomerInfo();
            System.out.println("======================관리자 메뉴======================");
            System.out.println("1. 회원의 정보를 수정합니다.");
            System.out.println("2. 회원의 정보를 삭제합니다.");
            System.out.println("9. 이전 메뉴로 돌아갑니다.");
            System.out.print("실행할 메뉴를 선택하십시오 : ");
            int num=sc.nextInt();
            switch (num) {
                case 1:
                    continue;
                case 2:
                    continue;
                case 9:
                    return;
            }
        }while (true);
    }

    private static void manageLog(){
        Scanner sc = new Scanner(System.in);
        ManagerMenuLog managerMenuLog = new ManagerMenuLog();
        do{
            managerMenuLog.selectAllMangerMenuLog();
            System.out.println("======================관리자 메뉴======================");
            System.out.println("1. 회원의 이름으로 필터링합니다.");
            System.out.println("2. 총 매출을 확인합니다.");
            System.out.println("9. 이전 메뉴로 돌아갑니다.");
            System.out.print("실행할 메뉴를 선택하십시오 : ");
            int num=sc.nextInt();
            switch (num) {
                case 1:
                    managerMenuLog.searchCustomerMangerMenuLog(ManagerMenuLog.managerSearchCustomer());
                    break;
                case 2:
                    managerMenuLog.sumAllMangerMenuLog();
                case 9:
                    return;
            }
        }while (true);
    }
}

