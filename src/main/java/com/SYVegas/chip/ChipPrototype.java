package com.SYVegas.chip;

import com.SYVegas.common.CurrentUser;

import java.util.Map;
import java.util.Scanner;

public class ChipPrototype {

    public void chipStart(CurrentUser currentUser) {

        ChipService chipService = new ChipService();
        Scanner scanner = new Scanner(System.in);

//        chipService.setWalletAmount("sss", 100000000);

        System.out.println("======================Chip 서비스 시작======================");

        Map<String, Integer> chipCounts = null;

        Map<String, Object> chipExchangeReturn = chipService.chipExchangeReturn(currentUser, chipCounts);

        System.out.println("사용자 ID: " + chipExchangeReturn.get("id"));
        int attribute = (int) chipExchangeReturn.get("attribute");
        System.out.println("작업 선택: " + (attribute == 1 ? "교환" : "반환"));

        chipService.updateChipDTO(currentUser,chipExchangeReturn);

    }
}