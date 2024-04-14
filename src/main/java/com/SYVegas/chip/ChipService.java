package com.SYVegas.chip;

import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ChipService {

    private static ChipSqlMapper mapper;

    public static void runService(int serviceOption) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("칩을 입력하세요 (공백으로 구분하여 1칩, 5칩, 10칩, 50칩, 100칩 순으로 입력): ");
        String[] nums = scanner.nextLine().split(" ");

        Map<String, Object> inputKey = new HashMap<>();
        inputKey.put("attribute", serviceOption);

        // 입력 받은 칩의 개수를 맵에 저장
        for (int i = 0; i < nums.length; i++) {
            inputKey.put("num" + (i + 1), Integer.parseInt(nums[i]));
        }

        // 서비스 옵션에 따라 처리
        switch (serviceOption) {
            case 1:
                // 교환 로직 수행
                exchangeChips(inputKey);
                break;
            case 2:
                // 반환 로직 수행
                returnChips(inputKey);
                break;
            default:
                System.out.println("올바르지 않은 서비스 옵션입니다.");
                break;
        }

        scanner.close();
    }

    private static void exchangeChips(Map<String, Object> inputKey) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);

        int result = mapper.updateChipDTO(inputKey);

        if (result > 0) {
            System.out.println("칩을 교환했습니다.");
            sqlSession.commit();
        } else {
            System.out.println("칩 교환에 실패했습니다.");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    private static void returnChips(Map<String, Object> inputKey) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);

        int result = mapper.updateChipDTO(inputKey);

        if (result > 0) {
            System.out.println("칩을 반환했습니다.");
            sqlSession.commit();
        } else {
            System.out.println("칩 반환에 실패했습니다.");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
