package com.SYVegas.common.DepositAndPurchase;

import com.SYVegas.common.CurrentUser;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static com.SYVegas.common.Template.getSqlSession;

public class DepositManager {

    private static SYUVegasMapper mapper;

    public static void depositMoney(CurrentUser currentUser) {

        Scanner sc = new Scanner(System.in);
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        String customerId = currentUser.getCurrentUserId();

        int depositAmount;
        do{
            System.out.println();
            System.out.println("지갑에 금액을 충전합니다.");
            System.out.println( customerId+" 이용객님");
            System.out.println("=======================");
            System.out.println("충전할 금액을 입력하세요");
            System.out.println("=======================");
            depositAmount = sc.nextInt();

            if  (depositAmount <= 0) {
                System.out.println("충전 금액은 0보다 커야 합니다.");
            }
        } while(depositAmount <= 0);

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
        mapper.updateCustomerWallet(parameters);

        System.out.println("===========================================");
        System.out.println("충전이 완료되었습니다!");
        System.out.println("===========================================");
        System.out.println(" \uD83D\uDCB0[지갑 잔액] : " + newBalance + "원");
        System.out.println("-------------------------------------------");
        System.out.println(" \uD83D\uDCB0[크레딧 잔액] : " + newCreditBalance + "원");
        System.out.println("============================================");

        sqlSession.commit();
        sqlSession.close();
    }
}