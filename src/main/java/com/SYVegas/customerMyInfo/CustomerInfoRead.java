package com.SYVegas.customerMyInfo;

import com.SYVegas.common.CustomerDTO;
import com.SYVegas.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.SYVegas.common.Template.getSqlSession;

public class CustomerInfoRead {
    private static CustomerMyInfo mapper;

    public static void searchCustomer(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CustomerMyInfo.class);

        List<CustomerDTO> customerList = mapper.searchCustomer(searchCriteria);

        sqlSession.close();

        if (customerList != null && customerList.size() > 0) {
            for (CustomerDTO code : customerList) {
                System.out.println(code);
            }
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

    }

}
