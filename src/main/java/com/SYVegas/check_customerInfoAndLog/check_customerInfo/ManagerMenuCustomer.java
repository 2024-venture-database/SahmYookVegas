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
    
    public static SearchKey inputSearchKey(){
        Scanner sc=new Scanner(System.in);
        System.out.print("수정할 사람의 아이디를 고르세요 : ");
        String id =sc.nextLine();
        System.out.println("1.이름 2.전화번호 3.생년월일 4.주소");
        System.out.print("수정할 항목을 고르세요 : ");
        int num =sc.nextInt();
        String attribute=null;
        switch (num) {
            case 1:
                attribute = "customer_name";
                break;
            case 2:
                attribute = "customer_phone";
                break;
            case 3:
                attribute = "customer_birth";
                break;
            case 4:
                attribute = "customer_address";
                break;
        }
        System.out.print("수정할 내용을 입력하세요 : ");
        String value = sc.nextLine();
        
        return new SearchKey(id,attribute,value);
    }
    
    public void updateManagerMenuCustomerInfo(SearchKey searchKey){
        SqlSession sqlSession=getSqlSession();
        mapper=sqlSession.getMapper(ManagerMenuCustomerSqlMapper.class);

        int result =mapper.updateManagerMenuCustomerInfo(searchKey)

    }

    public static String managerSearchCustomer(){ //삭제 하고자 하는 사람의ID 입력
        Scanner sc=new Scanner(System.in);
        System.out.print("삭제하려는 사용자 ID를 입력하세요 : ");
        String Cid=sc.nextLine();

        return Cid;
    }
    public void deleteCustomerMangerMenuLog(String Cid) { //사람의 이름으로 그 사람의 로그를 검색
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ManagerMenuCustomerSqlMapper.class);
        Map<String, String> map=new HashMap<>();
        map.put("Cid",Cid);
        List<CustomerInfo> customerInfoList = mapper.deleteCustomerMangerMenuLog(Cid);
        sqlSession.close();

        if (customerInfoList != null && customerInfoList.size() > 0) {
            for (CustomerInfo customerInfo : customerInfoList) {
                System.out.println(customerInfo);
            }
        } else {
            System.out.println("일치하는 결과가 없습니다.");
        }
    }

}
