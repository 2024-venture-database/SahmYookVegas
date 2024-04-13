package com.SYVegas.chip;

import java.util.Scanner;

public class Prototype {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("원하는 기능을 선택하세요:");
            System.out.println("1. 칩 교환");
            System.out.println("2. 칩 반환");
            System.out.println("3. 종료");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    ChipExchangeService chipExchangeService = new ChipExchangeServiceImpl();

                    int[] chipValues = {10000, 50000, 100000, 500000, 1000000};

                    System.out.println("1만 칩, 5만 칩, 10만 칩, 50만 칩, 100만 칩의 개수를 공백으로 구분하여 입력하세요:");
                    int[] chipCounts = new int[5];
                    for (int i = 0; i < chipCounts.length; i++) {
                        chipCounts[i] = scanner.nextInt();
                    }

                    int moneyToExchange = 0;
                    for (int i = 0; i < chipCounts.length; i++) {
                        moneyToExchange += chipCounts[i] * chipValues[i];
                    }

                    int exchangedAmount = chipExchangeService.exchangeChips(moneyToExchange, chipCounts);
                    System.out.println("교환된 총액: " + exchangedAmount + "만원");

                    break;

                case 2:
                    ChipReturnService chipReturnService = new ChipReturnServiceImpl();
                    System.out.println("1만 칩, 5만 칩, 10만 칩, 50만 칩, 100만 칩의 개수를 공백으로 구분하여 입력하세요:");
                    int[] chipCountsToReturn = new int[5];
                    for (int i = 0; i < chipCountsToReturn.length; i++) {
                        chipCountsToReturn[i] = scanner.nextInt();
                    }
                    int returnedMoney = chipReturnService.returnChips(chipCountsToReturn);
                    System.out.println("반환된 총액: " + returnedMoney + "만원");
                    break;

                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
                    break;
            }
        }

        scanner.close();
    }
}
