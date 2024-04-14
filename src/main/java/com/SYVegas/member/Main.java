package com.SYVegas.member;

import com.SYVegas.common.Template;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // 나중에 메소드화 할예정
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerMapper customerMapper = Template.getSqlSession().getMapper(CustomerMapper.class);

        while (true) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("9. 종료");
            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            // 입력값이 숫자인지 확인
            if (input.matches("\\d+")) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        login(scanner, customerMapper);
                        break;
                    case 2:
                        signUp(scanner, customerMapper);
                        break;
                    case 9:
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("올바른 메뉴를 선택하세요.");
                        break;
                }
            } else {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    private static void login(Scanner scanner, CustomerMapper customerMapper) {
        System.out.print("아이디를 입력하세요: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pw = scanner.nextLine();

        Map<String, String> credentials = new HashMap<>();
        credentials.put("customerId", id);
        credentials.put("customerPw", pw);

        Customer customer = customerMapper.getCustomerByIdAndPassword(credentials);
        if (customer != null) {
            System.out.println("로그인 성공! 환영합니다, " + customer.getCustomerName() + "님");
            System.out.println("등급: " + customer.getCustomerRank());
            // 로그인 성공 시 메인 메뉴 호출
            printMainMenu(scanner, customerMapper);
            if ("ma".equals(customer.getCustomerRank())) {
                System.out.println("관리자입니다.");
            }
        } else {
            System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    private static void signUp(Scanner scanner, CustomerMapper customerMapper) {
        System.out.print("아이디를 입력하세요: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String pw = scanner.nextLine();
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phone = scanner.nextLine();

        String rank = "n1";

        Customer newCustomer = new Customer(id, pw, name, phone, rank);
        customerMapper.insertCustomer(newCustomer);
        System.out.println("회원가입이 완료되었습니다.");
    }

    private static void printMainMenu(Scanner scanner, CustomerMapper customerMapper) {
        while (true) {
            System.out.println("1. 내 정보 조회");
            System.out.println("2. 충전");
            System.out.println("3. 칩 교환");
            System.out.println("4. 칩 반환");
            System.out.println("5. 상품 구매");
            System.out.println("6. 게임 시작");
            System.out.println("7. 로그아웃");
            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            // 입력값이 숫자인지 확인
            if (input.matches("\\d+")) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        // 내 정보 조회 메소드 실행
                        // 이 부분은 내 정보 조회에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 2:
                        // 충전 메소드 실행
                        // 이 부분은 충전에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 3:
                        // 칩 교환 메소드 실행
                        // 이 부분은 칩 교환에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 4:
                        // 칩 반환 메소드 실행
                        // 이 부분은 칩 반환에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 5:
                        // 상품 구매 메소드 실행
                        // 이 부분은 상품 구매에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 6:
                        // 게임 시작 메소드 실행
                        // 이 부분은 게임 시작에 해당하는 메소드 호출로 대체되어야 합니다.
                        break;
                    case 7:
                        System.out.println("로그아웃합니다.");
                        return; // 메소드 종료 및 프로그램 종료
                    default:
                        System.out.println("올바른 메뉴를 선택하세요.");
                        break;
                }
            } else {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }
}
