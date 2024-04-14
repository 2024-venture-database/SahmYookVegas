package com.SYVegas.common;

import com.SYVegas.check_customerInfoAndLog.Prototype;
import com.SYVegas.member.CustomerMapper;
import com.SYVegas.member.Main;

import java.util.Scanner;

import static com.SYVegas.member.Main.runMenu;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CustomerMapper customerMapper = Template.getSqlSession().getMapper(CustomerMapper.class);

        runMenu(scanner, customerMapper);
    }

}
