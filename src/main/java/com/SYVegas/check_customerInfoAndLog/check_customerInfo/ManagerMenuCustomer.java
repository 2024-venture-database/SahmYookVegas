package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

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

}
