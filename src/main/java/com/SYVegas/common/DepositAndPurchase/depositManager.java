package com.SYVegas.common.DepositAndPurchase;

import org.apache.ibatis.session.SqlSession;
import java.util.Scanner;
import static com.SYVegas.common.Template.getSqlSession;

public class depositManager {
    private SYUVegasMapper mapper;

    public void depositMoney() {

        Scanner sc = new Scanner(System.in);

        System.out.println("고객 ID를 입력하세요 : ");
        int customerId = sc.nextInt();

        System.out.println("충전할 금액을 입력하세요 : ");
        double depositAmount = sc.nextDouble();

        //credit_rate 비율 가져오기
        float creditRate = mapper.getVegasCreditRateByRank();

        float creditAmount = (float) (depositAmount * (creditRate / 100.0));

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        int rowsAffected = mapper.updateCustomerBalance((int) depositAmount, customerId);

        mapper.updateCreditBalance(creditAmount, customerId);

        if (rowsAffected > 0) {
            System.out.println("충전이 완료되었습니다.");
        } else {
            System.out.println("충전에 실패했습니다.");
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
