package com.SYVegas.common.DepositAndPurchase;

import org.apache.ibatis.session.SqlSession;
import java.util.*;
import static com.SYVegas.common.Template.getSqlSession;

public class productPurchase {

    private SYUVegasMapper mapper;

    // 지불 방식 선택
    public void productPaymentType() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("고객 ID를 입력하세요");
        System.out.println("=======================");

        String customerId = sc.nextLine();

        System.out.println("========\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99========");
        System.out.println("[1] 지갑 | [2] 크레딧");
        System.out.println("=======================");
        System.out.print("지불 방식을 선택하세요");
        int payment = sc.nextInt();

        selectproductType(payment, customerId);
    }

    // 상품 종류 선택
    public void selectproductType(int payment, String customerId) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================ [ 상품 종류 선택 ] ================");
        System.out.println("[1] 술 | [2] 음료 | [3] 과자 | [4] 담배 | [5] 교환권");
        System.out.println("==================================================");
        System.out.println("상품 타입을 선택하세요");
        System.out.println("==================================================");

        int no = sc.nextInt();
        String productType;

        switch (no) {
            case 1: productType = "술";  break;
            case 2: productType = "음료"; break;
            case 3: productType = "과자"; break;
            case 4: productType = "담배"; break;
            case 5: productType = "교환권"; break;
            default:
                return;
        }
        getProList(productType, payment, customerId);
    }

    // 상품 리스트 출력 후 선택
    public void getProList(String productType, int payment, String customerId) {

        Scanner sc = new Scanner(System.in);
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);
        List<ProductDTO> productList = mapper.getproductListByType(productType);
        sqlSession.close();

        if (productList != null && productList.size() > 0) {
            System.out.println("---------------[" + productType + "]---------------");
            ProductDTO product;
            for (int i = 0; i < productList.size(); i++) {
                product = productList.get(i);
                System.out.println("[" + (i + 1) + "] " + product.getName() + " - "+ product.getPrice() + "원");
            }
            System.out.println("==================================================");
            System.out.println("구매하실 상품 번호를 선택하세요 ");
            System.out.println("==================================================");

            int choice = sc.nextInt();
            sc.nextLine();

            ProductDTO selectedProduct = productList.get(choice - 1);
            purchaseProduct(selectedProduct, payment, customerId);

        } else {
            System.out.println("해당하는 상품이 없습니다.");
            selectproductType(payment, customerId);
        }
    }

    // 상품 구매
    public void purchaseProduct(ProductDTO product, int payment, String customerId) {
        int totalPrice = -(product.getPrice());

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("totalPrice", totalPrice);
        parameters.put("customerId", customerId);

        int currentBalance = mapper.getCustomerBalance(customerId);
        int currentCredit = mapper.getCustomerCredit(customerId);

        int newBalance = currentBalance + totalPrice;
        int newCreditBalance = currentCredit + totalPrice;

        if (product.getPrice() > currentBalance) {                   // 지갑 잔액 부족
            System.out.println("잔액이 부족하여 구매할 수 없습니다.");
            System.out.println("다시 상품을 선택해주세요!");
            System.out.println(" \uD83D\uDCB0지갑 잔액 : " + currentBalance + "원");
            System.out.println("");
            selectproductType(payment, customerId);
            return;

        } else if (product.getPrice() > currentCredit) {            // 크레딧 잔액 부족
            System.out.println("잔액이 부족하여 구매할 수 없습니다.");
            System.out.println("다시 상품을 선택해주세요!");
            System.out.println("==================================================");
            System.out.println(" \uD83D\uDCB0크레딧 잔액 : " + currentCredit + "원");
            System.out.println("");
            selectproductType(payment, customerId);
            return;
        }

        switch (payment) {
            case 1: // 지갑
                mapper.updateCustomerBalance(parameters);
                System.out.println("==================================================");
                System.out.println(" \uD83D\uDCB0지갑 잔액 : " + newBalance + "원");
                System.out.println("==================================================");
                break;
            case 2: // 크레딧
                mapper.updateCreditBalance(parameters);
                System.out.println("==================================================");
                System.out.println(" \uD83D\uDCB0크레딧 잔액 : " + newCreditBalance + "원");
                System.out.println("==================================================");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }
        sqlSession.commit();
        sqlSession.close();

        System.out.println(product.getName() + "를 구매완료했습니다.");
    }
}