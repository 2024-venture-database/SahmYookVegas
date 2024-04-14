package com.SYVegas.chip;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ChipService {

    public static void runService(int serviceOption, String customerId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("칩을 입력하세요 (공백으로 구분하여 1칩, 5칩, 10칩, 50칩, 100칩 순으로 입력): ");
        String[] nums = scanner.nextLine().split(" ");

        Map<String, Object> inputKey = new HashMap<>();
        inputKey.put("attribute", serviceOption);

        // 입력 받은 칩의 개수를 맵에 저장
        for (int i = 0; i < nums.length; i++) {
            inputKey.put("num" + (i + 1), Integer.parseInt(nums[i]));
        }

        switch (serviceOption) {
            case 1:
                exchangeChips(inputKey, customerId);
                break;
            case 2:
                returnChips(inputKey, customerId);
                break;
            default:
                System.out.println("올바르지 않은 서비스 옵션입니다.");
                break;
        }

        scanner.close();
    }

    private static void exchangeChips(Map<String, Object> inputKey, String customerId) {
        inputKey.put("log_customer_id", customerId);
        inputKey.put("attribute", 1);
        try (SqlSession sqlSession = getSqlSession()) {
            ChipSqlMapper mapper = sqlSession.getMapper(ChipSqlMapper.class);
            int result = mapper.updateChipDTO(inputKey);

            if (result > 0) {
                int totalValue = calculateTotalChipValue(inputKey);
                System.out.println("칩을 교환했습니다.");
                sqlSession.commit();
            } else {
                System.out.println("칩 교환에 실패했습니다.");
                sqlSession.rollback();
            }
        }
    }

    private static void returnChips(Map<String, Object> inputKey, String customerId) {
        try (SqlSession sqlSession = getSqlSession()) {
            ChipSqlMapper mapper = sqlSession.getMapper(ChipSqlMapper.class);
            int result = mapper.updateChipDTO(inputKey);

            if (result > 0) {
                int totalValue2 = calculateTotalChipValue(inputKey);
                System.out.println("칩을 반환했습니다.");
                sqlSession.commit();
            } else {
                System.out.println("칩 반환에 실패했습니다.");
                sqlSession.rollback();
            }
        }
    }

    private static int calculateTotalChipValue(Map<String, Object> inputKey) {
        int num1 = (int) inputKey.get("num1");
        int num2 = (int) inputKey.get("num2");
        int num3 = (int) inputKey.get("num3");
        int num4 = (int) inputKey.get("num4");
        int num5 = (int) inputKey.get("num5");

        // 각 칩의 가치에 맞게 더해서 총 가치 계산
        return num1 * 10000 + num2 * 50000 + num3 * 100000 + num4 * 500000 + num5 * 1000000;
    }
}