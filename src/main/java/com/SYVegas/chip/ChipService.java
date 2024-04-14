package com.SYVegas.chip;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ChipService {

    private static Object value;

    public static Map<String,Object> chipExchangeReturn(Map<String, Integer> chipCounts){

        Scanner sc = new Scanner(System.in);

        System.out.print("칩 교환/반환 서비스를 시작하겠습니다.");
        System.out.println("사용자 ID를 입력하세요: ");
        String id=sc.nextLine();

        System.out.println("(1.교환, 2.반환)");
        System.out.println("원하는 작업을 선택하세요: ");
        int attribute = sc.nextInt();
        sc.nextLine();

        if (attribute != 1 && attribute != 2) {
            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            return null;
        }

        if (chipCounts == null) {
            chipCounts = new HashMap<>();
            System.out.println("1칩, 5칩, 10칩, 50칩, 100칩 각각 몇 개씩 교환/반환하시겠습니까? (공백으로 구분하여 입력)");
            String[] chipInput = sc.nextLine().split(" ");
            chipCounts.put("1칩", Integer.parseInt(chipInput[0]));
            chipCounts.put("5칩", Integer.parseInt(chipInput[1]));
            chipCounts.put("10칩", Integer.parseInt(chipInput[2]));
            chipCounts.put("50칩", Integer.parseInt(chipInput[3]));
            chipCounts.put("100칩", Integer.parseInt(chipInput[4]));
        }

        Map<String, Object> chipExchangeReturn = new HashMap<>();
        chipExchangeReturn.put("id",id);
        chipExchangeReturn.put("attribute",attribute);

        return chipExchangeReturn;
    }

    public void updateChipDTO(Map<String, Object> chipExchangeReturn){
        SqlSession sqlSession = getSqlSession();
        ChipSqlMapper mapper = sqlSession.getMapper(ChipSqlMapper.class);

        int result = mapper.updateChipTransaction(chipExchangeReturn);

        if (result > 0) {
            System.out.println("칩 거래 내역이 성공적으로 업데이트되었습니다.");
            sqlSession.commit();
        } else {
            System.out.println("칩 거래 내역을 업데이트하는 데 실패했습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();

    }
}