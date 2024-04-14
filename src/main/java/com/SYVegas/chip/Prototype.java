package com.SYVegas.chip;

import java.util.Map;
import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이용할 서비스를 선택하세요.");
        System.out.println("1. 칩 교환");
        System.out.println("2. 칩 반환");
        int serviceOption = scanner.nextInt();

        if (serviceOption == 1) {
            ChipExchangeService chipExchangeService = new ChipExchangeService();
            Map<String, Object> inputKey = ChipExchangeService.inputChipKey(serviceOption);
            chipExchangeService.exchangeChips(inputKey);
        } else if (serviceOption == 2) {
            ChipReturnService chipReturnService = new ChipReturnService();
            Map<String, Object> inputKey = ChipReturnService.inputChipKey(serviceOption);
            chipReturnService.returnChips(inputKey);
        } else {
            System.out.println("올바른 서비스 옵션을 선택해주세요.");
        }

        scanner.close();
    }
}
