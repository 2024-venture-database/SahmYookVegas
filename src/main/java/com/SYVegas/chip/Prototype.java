package com.SYVegas.chip;

import java.util.Scanner;
import com.SYVegas.chip.ChipExchangeService;
import com.SYVegas.chip.ChipExchangeServiceImpl;
import com.SYVegas.chip.ChipReturnService;
import com.SYVegas.chip.ChipReturnServiceImpl;

public class Prototype {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 칩 교환 기능 사용 예시
        ChipExchangeService chipExchangeService = new ChipExchangeServiceImpl();
        System.out.print("교환할 돈을 입력하세요: ");
        int moneyToExchange = scanner.nextInt();
        System.out.println("칩 종류 및 개수를 입력하세요:");
        int[] chipCounts = new int[5];
        String[] chipTypes = {"1만원짜리", "5만원짜리", "10만원짜리", "50만원짜리", "100만원짜리"};
        for (int i = 0; i < chipCounts.length; i++) {
            System.out.print(chipTypes[i] + " 칩 개수: ");
            chipCounts[i] = scanner.nextInt();
        }
        chipExchangeService.exchangeChips(moneyToExchange, chipCounts); // 교환된 돈은 반환값으로 받지 않음
        int exchangedAmount = chipExchangeService.getExchangedAmount();
        System.out.println("교환된 총액: " + exchangedAmount);

        // 칩 반환 기능 사용 예시
        ChipReturnService chipReturnService = new ChipReturnServiceImpl();
        System.out.println("보유한 칩의 개수를 입력하세요:");
        int[] chipCountsToReturn = new int[5]; // 1만원짜리부터 100만원짜리까지 칩의 개수를 입력하세요
        for (int i = 0; i < chipCountsToReturn.length; i++) {
            System.out.print(chipTypes[i] + " 칩 개수: ");
            chipCountsToReturn[i] = scanner.nextInt();
        }
        int returnedMoney = chipReturnService.returnChips(chipCountsToReturn);
        System.out.println("반환된 총액: " + returnedMoney);

        scanner.close();
    }
}
