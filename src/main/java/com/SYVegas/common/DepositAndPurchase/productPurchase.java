package com.SYVegas.common.DepositAndPurchase;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;
import static com.SYVegas.common.Template.getSqlSession;

public class productPurchase {

    private SYUVegasMapper mapper;

    public int productPaymentType() {       // 지불 방식 선택
        Scanner sc = new Scanner(System.in);

        System.out.println("고객 ID를 입력하세요 : ");
        String customerId = sc.nextLine();

        System.out.println("=======================");
        System.out.println("[1] 지갑 | [2] 크레딧");
        System.out.println("=======================");
        System.out.print("지불 방식을 선택하세요 : ");
        int payment = sc.nextInt();
        sc.nextLine();
        selectproductType(payment);

        return payment;
    }

    public void selectproductType(int payment) { // 상품 종류 선택
        Scanner sc = new Scanner(System.in);

        System.out.println("================ [ 상품 종류 선택 ] ================");
        System.out.println("[1] 술 | [2] 음료 | [3] 과자 | [4] 담배 | [5] 교환권");
        System.out.println("==================================================");
        System.out.print("상품 타입을 선택하세요 : ");
        int no = sc.nextInt();
        String productType = "";

        switch (no) {
            case 1:
                productType = "술";
                break;
            case 2:
                productType = "음료";
                break;
            case 3:
                productType = "과자";
                break;
            case 4:
                productType = "담배";
                break;
            case 5:
                productType = "교환권";
                break;
            default:
                return;
        }
        getProList(productType, payment);
    }

    public void getProList(String productType, int payment) {

        Scanner sc = new Scanner(System.in);

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        List<ProductDTO> productList = mapper.getproductListByType(productType);

        sqlSession.close();

        if (productList != null && productList.size() > 0) {
            System.out.println("[ " + productType + " ]");
            ProductDTO product = null;
            for (int i = 0; i < productList.size(); i++) {
                product = productList.get(i);
                System.out.println("[" + (i + 1) + "] " + product.getName() + " - " + product.getPrice() + "원 개수 - " + product.getQuantity() + "개");
            }

            System.out.println("구매하실 상품 번호를 선택하세요 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            int totalPrice = product.getPrice();

            switch (payment) {
                case 1: // 지갑
                    mapper.updateCustomerBalance(-totalPrice);
                    break;
                case 2: // 크레딧
                    mapper.updateCreditBalance(-totalPrice);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    return;
            }

            purchaseProduct(productList.get(choice - 1), payment);

        } else {
            System.out.println("해당하는 상품이 없습니다.");
        }
    }


    public void purchaseProduct(ProductDTO product, int payment) {
        Scanner sc = new Scanner(System.in);

        System.out.print("구매할 개수를 입력하세요: ");
        int qty = sc.nextInt();
        int totalPrice = product.getPrice() * qty;

        if (qty > product.getQuantity()) {
            System.out.println("재고가 부족합니다.");
            return;
        }

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        switch (payment) {
            case 1: // 지갑
                mapper.updateCustomerBalance(-totalPrice);
                break;
            case 2: // 크레딧
                mapper.updateCreditBalance(-totalPrice);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }

        mapper.updateProductQuantity(product.getCode(), qty);

        mapper.insertPurchaseLog(null,null, null, "상품구매",null);

        sqlSession.commit();
        sqlSession.close();

        System.out.println(product.getName() + " " + qty + "개를 구매했습니다.");
    }
}