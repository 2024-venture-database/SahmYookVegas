package com.SYVegas.customerMyInfo;

import com.SYVegas.common.CurrentUser;
import com.SYVegas.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class testapplication {

    public void testApplication(CurrentUser currentUser) {
        Scanner scanner = new Scanner(System.in);
        String id = currentUser.getCurrentUserId();
        System.out.println();
        System.out.println("==================================================");
        CustomerDTO customer = searchCustomerById(id);
        if (customer != null) {
            System.out.println(customer);

        } else {
            System.out.println("ID 와 일치하는 고객 정보가 없습니다.");
        }
        System.out.println("==================================================");
    }
    private static CustomerDTO searchCustomerById(String id) {
        SqlSession sqlSession = Template.getSqlSession();
        try {
            CustomerMyInfoMapper mapper = sqlSession.getMapper(CustomerMyInfoMapper.class);
            return mapper.selectCustomerById(id);
        } finally {
            sqlSession.close();
        }
    }
}

