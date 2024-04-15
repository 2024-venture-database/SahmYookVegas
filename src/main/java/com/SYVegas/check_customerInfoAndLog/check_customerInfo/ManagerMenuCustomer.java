package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

import com.SYVegas.check_customerInfoAndLog.check_Log.Log;
import com.SYVegas.check_customerInfoAndLog.check_Log.ManagerMenuLogSqlMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.SYVegas.common.Template.getSqlSession;

public class ManagerMenuCustomer {

    private ManagerMenuCustomerSqlMapper mapper;

    public void selectAllManagerMenuCustomerInfo(){ //모든 유저들의 정보를 검색
        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(ManagerMenuCustomerSqlMapper.class);

        List<CustomerInfo> customerInfoList=mapper.selectAllManagerMenuCustomerInfo();

        sqlSession.close();
        if(customerInfoList != null && customerInfoList.size()>0){
            for(CustomerInfo customerInfo : customerInfoList){
                System.out.println(customerInfo);
            }
        }else{
            System.out.println("일치하는 결과가 없습니다.");
        }
    }
    
    public static Map<String,Object> inputSearchKey(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정보를 수정할 이용자의 ID를 입력하세요 : ");
        String id=sc.nextLine();
        System.out.println("(1.비밀번호, 2.이름, 3.전화번호)");
        System.out.print("수정할 속성의 번호를 입력하세요 : ");
        int attribute = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 정보를 입력하세요 : ");
        String value = sc.nextLine();

        Map<String, Object> searchKey = new HashMap<>();
        searchKey.put("id",id);
        searchKey.put("attribute",attribute);
        searchKey.put("value",value);

        return searchKey;
    }
    
    public void updateManagerMenuCustomerInfo(Map<String, Object> searchKey){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuCustomerSqlMapper.class);

        int result = mapper.updateManagerMenuCustomerInfo(searchKey);

        if (result > 0) {
            System.out.println("해당 속성의 정보를 수정하였습니다.");
            sqlSession.commit();
        } else {
            System.out.println("해당 속성의 정보를 수정하지 못하였습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();

    }

    public static Map<String,Object> managerSearchCustomer(){ //삭제 하고자 하는 사람의ID 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("정보를 삭제할 이용자의 ID를 입력하세요 : ");
        String id=sc.nextLine();

        Map<String, Object> searchKey = new HashMap<>();
        searchKey.put("id",id);

        return searchKey;
    }

    public void deleteMangerMenuCustomerInfo(Map<String, Object> searchKey){
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuCustomerSqlMapper.class);

        int result = mapper.deleteMangerMenuCustomerInfo(searchKey);

        if (result > 0) {
            System.out.println("해당 이용자를 성공적으로 삭제하였습니다.");
            sqlSession.commit();
        } else {
            System.out.println("해당 이용자가 삭제되지 않았습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
