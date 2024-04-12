package com.SYVegas.customerMyInfo;

import com.SYVegas.common.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

public class testapplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 고객의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        CustomerDTO customer = searchCustomerById(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("일치하는 고객 정보가 없습니다.");
        }
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

