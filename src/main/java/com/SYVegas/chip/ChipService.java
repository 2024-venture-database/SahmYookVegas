package com.SYVegas.chip;

import com.SYVegas.common.CurrentUser;
import com.SYVegas.playgame.GameMapper;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ChipService {

    public int balance;
    private ChipSqlMapper mapper;

    private final Map<String, Integer> walletMap = new HashMap<>();

    public void setWalletAmount(String userId, int amount) {
        walletMap.put(userId, amount);
    }

    public int getBalance(String id){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);

        balance = mapper.getBalance(id);
        sqlSession.close();
        return balance;
    }



    public Map<String, Object> chipExchangeReturn(CurrentUser currentUser, Map<String, Integer> chipCounts) {
        Scanner sc = new Scanner(System.in);

        System.out.println("칩 교환/반환 서비스를 시작하겠습니다.");
        String id = currentUser.getCurrentUserId();

        System.out.println();
        System.out.println("=========현재 "+id+"님의 보유 칩========= ");
        System.out.println("[칩1]: "+currentUser.getChip1());
        System.out.println("[칩5]: "+currentUser.getChip5());
        System.out.println("[칩10]: "+currentUser.getChip10());
        System.out.println("[칩50]: "+currentUser.getChip50());
        System.out.println("[칩100]: "+currentUser.getChip100());
        System.out.println(id+"님의 현재 잔액은 "+getBalance(id)+"원 입니다.");





        System.out.println("======================");
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
            System.out.println("======================");
            System.out.println("1칩, 5칩, 10칩, 50칩, 100칩 각각 몇 개씩 교환/반환하시겠습니까? (공백으로 구분하여 입력)");
            String[] chipInput = sc.nextLine().split(" ");

            chipCounts.put("1칩", Integer.parseInt(chipInput[0]));
            chipCounts.put("5칩", Integer.parseInt(chipInput[1]));
            chipCounts.put("10칩", Integer.parseInt(chipInput[2]));
            chipCounts.put("50칩", Integer.parseInt(chipInput[3]));
            chipCounts.put("100칩", Integer.parseInt(chipInput[4]));

        }

        Map<String, Object> chipExchangeReturn = new HashMap<>();
        chipExchangeReturn.put("id", id);
        chipExchangeReturn.put("attribute", attribute);
        chipExchangeReturn.put("chipCounts", chipCounts);

        return chipExchangeReturn;
    }

    public void exchangeChips(Map<String, Object> chipExchange){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);
        int result= mapper.exchangeChips(chipExchange);

        if (result > 0) {
            System.out.println("칩을 교환했습니다.");
            sqlSession.commit();
        } else {
            System.out.println("칩을 교환하지 못했습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }

    public void returnChips(Map<String, Object> chipExchange){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);
        int result= mapper.returnChips(chipExchange);

        if (result > 0) {
            System.out.println("칩을 교환했습니다.");
            sqlSession.commit();
        } else {
            System.out.println("칩을 교환하지 못했습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }


    public void updateChipDTO(CurrentUser currentUser, Map<String, Object> chipExchangeReturn) {
        String id = (String) chipExchangeReturn.get("id");
        int attribute = (int) chipExchangeReturn.get("attribute");
        Map<String, Integer> chipCounts = (Map<String, Integer>) chipExchangeReturn.get("chipCounts");



        int currentAmount = getBalance(id);
        int totalChipValue = chipCounts.get("1칩") * 10000 +
                chipCounts.get("5칩") * 50000 +
                chipCounts.get("10칩") * 100000 +
                chipCounts.get("50칩") * 500000 +
                chipCounts.get("100칩") * 1000000;


        if (attribute == 1) { // 교환

            if (currentAmount < totalChipValue) {
                System.out.println("잔액이 부족하여 교환할 수 없습니다.");
                System.out.println("전메뉴로 돌아갑니다.");
                return;
            }

            currentUser.setChip1(currentUser.getChip1()+chipCounts.get("1칩"));
            currentUser.setChip5(currentUser.getChip5()+chipCounts.get("5칩"));
            currentUser.setChip10(currentUser.getChip10()+chipCounts.get("10칩"));
            currentUser.setChip50(currentUser.getChip50()+chipCounts.get("50칩"));
            currentUser.setChip100(currentUser.getChip100()+chipCounts.get("100칩"));


            System.out.println("=========현재 "+id+"님의 보유 칩========= ");
            System.out.println("[칩1]: "+currentUser.getChip1());
            System.out.println("[칩5]: "+currentUser.getChip5());
            System.out.println("[칩10]: "+currentUser.getChip10());
            System.out.println("[칩50]: "+currentUser.getChip50());
            System.out.println("[칩100]: "+currentUser.getChip100());


            Map<String, Object> chipExchange = new HashMap<>();

            int exchangeAmount =currentAmount - totalChipValue;

            chipExchange.put("exchangeAmount",exchangeAmount);
            chipExchange.put("id",currentUser.getCurrentUserId());

            exchangeChips(chipExchange);
            System.out.println(id+"님의 현재 잔액은 "+getBalance(id)+"원 입니다.");
            saveLog1(totalChipValue, currentUser.getCurrentUserId());

        } else if (attribute == 2) { // 반환이면

            currentUser.setChip1(currentUser.getChip1()-chipCounts.get("1칩"));
            currentUser.setChip5(currentUser.getChip5()-chipCounts.get("5칩"));
            currentUser.setChip10(currentUser.getChip10()-chipCounts.get("10칩"));
            currentUser.setChip50(currentUser.getChip50()-chipCounts.get("50칩"));
            currentUser.setChip100(currentUser.getChip100()-chipCounts.get("100칩"));


            System.out.println("=========현재 "+id+"님의 보유 칩========= ");
            System.out.println("[칩1]: "+currentUser.getChip1());
            System.out.println("[칩5]: "+currentUser.getChip5());
            System.out.println("[칩10]: "+currentUser.getChip10());
            System.out.println("[칩50]: "+currentUser.getChip50());
            System.out.println("[칩100]: "+currentUser.getChip100());


            int totalMoneyValue = chipCounts.get("1칩") * 10000 +
                    chipCounts.get("5칩") * 50000 +
                    chipCounts.get("10칩") * 100000 +
                    chipCounts.get("50칩") * 500000 +
                    chipCounts.get("100칩") * 1000000;

            Map<String, Object> chipExchange = new HashMap<>();

            int exchangeAmount =currentAmount + totalChipValue;

            chipExchange.put("exchangeAmount",exchangeAmount);
            chipExchange.put("id",currentUser.getCurrentUserId());
            returnChips(chipExchange);
            System.out.println(id+"님의 현재 잔액은 "+getBalance(id)+"원 입니다.");
            saveLog2(totalChipValue, currentUser.getCurrentUserId());


        }


        // 지갑 정보 출력
    }
    public void saveLog1(int totalPrice, String customerId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("logDate", LocalDate.now());
        parameters.put("logMoney", totalPrice);
        parameters.put("logKindMoney", "지갑");
        parameters.put("logActiviy", "칩교환");
        parameters.put("logCustomerId", customerId);

        mapper.insertChipExchangeLog(parameters);

        sqlSession.commit();
        sqlSession.close();
    }

    public void saveLog2(int totalPrice, String customerId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ChipSqlMapper.class);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("logDate", LocalDate.now());
        parameters.put("logMoney", totalPrice);
        parameters.put("logKindMoney", "지갑");
        parameters.put("logActiviy", "칩반환");
        parameters.put("logCustomerId", customerId);

        mapper.insertChipReturnLog(parameters);

        sqlSession.commit();
        sqlSession.close();
    }

}

/* 지갑에 있는 돈을 칩으로 교환을 하고
 * 칩으로 교환한 액수만큼 지갑에서 돈을 빼는 것
 * 칩에 있는 숫자 1당 만원의 가치를 가짐
 * 만약 100만원짜리 칩 5개를 교환 받으면
 * 지갑에서 500만원이 빠지는 걸 업데이트 하는 기능
 * 반환하면 내가 가진 칩을 다 돈으로 환산해서
 * 지갑 액수에 추가해주는 업데이트
 * 부가적으로 칩을 교환했을 때 돈을 얼만큼 교환했는지
 * 로그 테이블에 인서트 해줘라 */