package com.SYVegas.chip;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ChipReturnService {

    private ChipSqlMapper mapper;

    public static Map<String, Object> inputChipKey(int serviceOption) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("공백으로 구분하여 1칩, 5칩, 10칩, 50칩, 100칩 순으로 입력하세요: ");
        String[] nums = scanner.nextLine().split(" ");

        Map<String, Object> chipKey = new HashMap<>();
        chipKey.put("attribute", serviceOption);
        for (int i = 0; i < nums.length; i++) {
            chipKey.put("num" + (i+1), Integer.parseInt(nums[i]));
        }

        return chipKey;
    }

    public void returnChips(Map<String, Object> inputKey) {
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
