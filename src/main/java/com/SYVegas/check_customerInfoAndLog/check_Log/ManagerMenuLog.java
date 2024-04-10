package com.SYVegas.check_customerInfoAndLog.check_Log;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ManagerMenuLog {

    private ManagerMenuLogSqlMapper mapper;

    public void selectAllMangerMenuLog() { //모든 로그들을 검색
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuLogSqlMapper.class);

        List<Log> logList = mapper.selectAllMangerMenuLog();

        sqlSession.close();
        if (logList != null && logList.size() > 0) {
            for (Log log : logList) {
                System.out.println(log);
            }
        } else {
            System.out.println("일치하는 결과가 없습니다.");
        }
    }

    public static String managerSearchCustomer(){ //조회하고자하는 사람의 로그 검색을 위해 사람이름 입력
        Scanner sc=new Scanner(System.in);
        System.out.print("조회하려는 사용자 명을 입력하세요 : ");
        String Cname=sc.nextLine();

        return Cname;
    }

    public void searchCustomerMangerMenuLog(String Cname) { //사람의 이름으로 그 사람의 로그를 검색
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuLogSqlMapper.class);
        Map<String, String> map=new HashMap<>();
        map.put("Cname",Cname);
        List<Log> logList = mapper.searchCustomerMangerMenuLog(Cname);
        sqlSession.close();

        if (logList != null && logList.size() > 0) {
            for (Log log : logList) {
                System.out.println(log);
            }
        } else {
            System.out.println("일치하는 결과가 없습니다.");
        }
    }

    public void sumAllMangerMenuLog() { //모든 로그들의 amount값을 합침
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuLogSqlMapper.class);

        List<Log> logList = mapper.sumAllMangerMenuLog();

        sqlSession.close();
        if (logList != null && logList.size() > 0) {
            for (Log log : logList) {
                System.out.println(log);
            }
        } else {
            System.out.println("일치하는 결과가 없습니다.");
        }
    }
}
