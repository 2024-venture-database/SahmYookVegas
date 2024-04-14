package com.SYVegas.chip;

import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이용할 서비스를 선택하세요.");
        System.out.println("1. 칩 교환");
        System.out.println("2. 칩 반환");

        int serviceOption = 0;
        while (serviceOption != 1 && serviceOption != 2) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                serviceOption = scanner.nextInt();
                if (serviceOption != 1 && serviceOption != 2) {
                    System.out.println("잘못된 옵션입니다. 다시 선택해주세요.");
                }
            } else {
                System.out.println("숫자를 입력해주세요.");
                scanner.next(); // 잘못된 입력 제거
            }
        }

        ChipService.runService(serviceOption);

        scanner.close();
    }
}
