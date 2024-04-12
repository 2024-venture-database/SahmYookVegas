package com.SYVegas.common.DepositAndPurchase;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;
import static com.SYVegas.common.Template.getSqlSession;

public class productPurchase {

    private SYUVegasMapper mapper;

    public int productPaymentType() {       // 지불 방식 선택

        Scanner sc = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("[1] 지갑 | [2] 크레딧");
        System.out.println("=======================");
        System.out.println("지불 방식을 선택하세요 : ");
        int payment = sc.nextInt();
        sc.nextLine();

        return payment;
    }

    public String productType(ProductDTO product) {          // 상품 종류 선택
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("[1] 음료 | [2] 과자 | [3] 담배 | [4] 술 | [5] 교환권");
        System.out.println("=================================================");
        System.out.println("상품 타입을 선택하세요 : ");
        int productTypeChoice = sc.nextInt();
        sc.nextLine();

        switch (productTypeChoice) {
            case 1:
                return "음료";
            case 2:
                return "과자";
            case 3:
                return "담배";
            case 4:
                return "술";
            case 5:
                return "교환권";
            default:
                return null;
        }
    }

    public void getproductList(List<ProductDTO> productList, String productType, int payment, int productPrice) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        sqlSession.close();

        Scanner sc = new Scanner(System.in);

        if (productList != null && productList.size() > 0) {
            System.out.println("상품 목록:");
            for (int i = 0; i < productList.size(); i++) {
                ProductDTO product = productList.get(i);
                System.out.println("[" + (i + 1) + "] " + product.getName() + " - " + product.getPrice());
            }
        }

        System.out.println("구매할 상품 번호를 선택하세요 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        ProductDTO selectedProduct = productList.get(choice - 1);

        // 상품 구매
        mapper.purchaseProduct(choice, selectedProduct.getName(), productPrice);

        // 지갑 또는 크레딧에서 금액 차감
        if (payment == 1 || payment == 2) {
            mapper.depositManager(choice, -productPrice);
        }

        sqlSession.commit();
        sqlSession.close();

        System.out.println(selectedProduct.getName() + "을(를) 구매 완료했습니다.");

    }
}

