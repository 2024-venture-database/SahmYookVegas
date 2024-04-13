package com.SYVegas.common.DepositAndPurchase;

import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static com.SYVegas.common.Template.getSqlSession;

public class depositManager {

    private static SYUVegasMapper mapper;

    public static void depositMoney() {

        Scanner sc = new Scanner(System.in);
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        System.out.println("=======================");
        System.out.println("고객 ID를 입력하세요 ");
        System.out.println("=======================");
        String customerId = sc.nextLine();

        System.out.println("=======================");
        System.out.println("충전할 금액을 입력하세요");
        System.out.println("=======================");
        int depositAmount = sc.nextInt();

        int currentBalance = mapper.getCustomerBalance(customerId);
        int currentCredit = mapper.getCustomerCredit(customerId);
        float creditRate = mapper.getCustomerCreditRate(customerId);

        int creditEarned = (int) (depositAmount * creditRate);

        int newBalance = currentBalance + depositAmount;
        int newCreditBalance = currentCredit + creditEarned;

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("depositAmount", depositAmount);
        parameters.put("customerId", customerId);
        parameters.put("newCreditBalance", newCreditBalance);

        System.out.println("===========================================");
        System.out.println("충전이 완료되었습니다!");
        System.out.println("===========================================");
        System.out.println(" \uD83D\uDCB0지갑 잔액 : " + newBalance + "원");
        System.out.println("-------------------------------------------");
        System.out.println(" \uD83D\uDCB0크레딧 잔액 : " + newCreditBalance + "원");
        System.out.println("============================================");

        sqlSession.commit();
        sqlSession.close();
    }
}
