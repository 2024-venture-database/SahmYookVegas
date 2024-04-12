package com.SYVegas.customerMyInfo;

import com.SYVegas.common.SearchCriteria;

import java.util.Scanner;

public class testapplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. 검색 ");
            System.out.println("9. 프로그램 종료");
            System.out.println("검색조건을 입력해주세요 :");
            int no = sc.nextInt();
            switch (no){
                case 1: CustomerInfoRead.searchCustomer(inputSearchCriteria());break;
                case 9:
                    System.out.println("프로그램을 종료합니다. "); return;
            }
        }while(true);
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준을 입력하세요 (id 또는 name) : ");
        String condition = sc.nextLine();
        System.out.println("검색어를 입력하세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

}
