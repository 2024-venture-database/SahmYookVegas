package com.SYVegas.chip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {

        ChipService chipService = new ChipService();
        Scanner scanner = new Scanner(System.in);

        chipService.setWalletAmount("sss", 100000000);

        System.out.println("======================Chip 서비스 시작======================");

        Map<String, Integer> chipCounts = null;

        Map<String, Object> chipExchangeReturn = chipService.chipExchangeReturn(chipCounts);

        System.out.println("사용자 ID: " + chipExchangeReturn.get("id"));
        int attribute = (int) chipExchangeReturn.get("attribute");
        System.out.println("작업 선택: " + (attribute == 1 ? "교환" : "반환"));

        chipService.updateChipDTO(chipExchangeReturn);

        System.out.println("프로그램을 종료합니다.");
    }
}