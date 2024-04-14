package com.SYVegas.chip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {
        ChipService chipService = new ChipService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================Chip 서비스 시작======================");

        // 사용자 ID 입력 받기
        System.out.println("사용자 ID를 입력하세요:");
        String userId = scanner.nextLine();

        // 추가할 금액 입력 받기
        System.out.println("추가할 금액을 입력하세요:");
        int amount = scanner.nextInt();

        // 사용자의 지갑에 돈 추가
        chipService.addMoneyToWallet(userId, amount);

        // 교환/반환 작업 수행
        Map<String, Integer> chipCounts = null; // 사용자의 칩 개수를 나타내는 Map, 여기서는 초기화되지 않았음
        Map<String, Object> chipExchangeReturn = chipService.chipExchangeReturn(chipCounts);

        // 작업 결과 출력
        System.out.println("사용자 ID: " + chipExchangeReturn.get("id"));
        int attribute = (int) chipExchangeReturn.get("attribute");
        System.out.println("작업 선택: " + (attribute == 1 ? "교환" : "반환"));

        // 교환/반환 작업 결과 업데이트
        chipService.updateChipDTO(chipExchangeReturn);

        System.out.println("프로그램을 종료합니다.");
    }
}
