package com.SYVegas.common.DepositAndPurchase;

import com.SYVegas.common.CurrentUser;
import org.apache.ibatis.session.SqlSession;
import java.util.*;
import static com.SYVegas.common.Template.getSqlSession;

public class ProductPurchase {

    private SYUVegasMapper mapper;

    // 지불 방식 선택
    public void productPaymentType(CurrentUser currentUser) {
        Scanner sc = new Scanner(System.in);

        String customerId = currentUser.getCurrentUserId();

        System.out.println("========\uD83E\uDE99\uD83E\uDE99\uD83E\uDE99========");
        System.out.println("[1] 지갑 | [2] 크레딧");
        System.out.println("=======================");
        System.out.print("지불 방식을 선택하세요 : ");

        int payment = sc.nextInt();
        selectproductType(payment, customerId);
    }

    // 구매할 상품 선택
    public void selectproductType(int payment, String customerId) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);
        List<ProductDTO> productList = mapper.getproductListByType();
        sqlSession.close();

        if (productList != null && productList.size() > 0) {
            System.out.println("");
            System.out.println("================= [ 상품 종류 ] =================");
            System.out.println("  술   |   음료   |   과자   |   담배   |   교환권  ");
            System.out.println("================================================");

            for(int i =0; i < productList.size(); i++){
                ProductDTO product = productList.get(i);
                System.out.println((i+1)+ product.toString());
            }

            System.out.println("==================================================");
            System.out.print("구매하실 상품 번호를 선택하세요 : ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice > 0 && choice <= productList.size()) {
                ProductDTO selectedProduct = productList.get(choice - 1);
                purchaseProduct(selectedProduct, payment, customerId);
            } else{
                System.out.println("==================================================");
                System.out.println("잘못된 선택입니다.");
                selectproductType(payment, customerId);
            }
        } else {
            System.out.println("==================================================");
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




        if (payment == 1) {

            if (product.getPrice() > currentBalance) {
                System.out.println("==================================================");// 지갑 잔액 부족
                System.out.println("잔액이 부족하여 구매할 수 없습니다.");
                System.out.println("다시 상품을 선택해주세요!");
                System.out.println(" \uD83D\uDCB0[지갑 잔액] : " + currentBalance + "원");
                selectproductType(payment, customerId);
                return;
            }   else{
                mapper.updateCustomerBalance(parameters);
                System.out.println("==================================================");
                System.out.println(" \uD83D\uDCB0[지갑 잔액] : " + newBalance + "원");
                System.out.println("==================================================");
                //saveLog(totalPrice);
            }

        } else if (payment == 2) {

            if (product.getPrice() > currentCredit) {            // 크레딧 잔액 부족
                System.out.println("==================================================");
                System.out.println("잔액이 부족하여 구매할 수 없습니다.");
                System.out.println("다시 상품을 선택해주세요!");
                System.out.println("==================================================");
                System.out.println(" \uD83D\uDCB0[크레딧 잔액] : " + currentCredit + "원");
                selectproductType(payment, customerId);
                return;

            } else{
                mapper.updateCreditBalance(parameters);
                System.out.println("==================================================");
                System.out.println(" \uD83D\uDCB0[크레딧 잔액] : " + newCreditBalance + "원");
                System.out.println("==================================================");
                // saveLog(totalPrice);
            }

        } else {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        sqlSession.commit();
        sqlSession.close();

        System.out.println(product.getName() + "를 구매완료했습니다.");
    }

    /*
   public void saveLog(int totalPrice) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(SYUVegasMapper.class);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("logDate", LocalDate.now());
        parameters.put("logMoney", totalPrice);
        parameters.put("logActivity", "상품구매");

        mapper.insertPurchaseLog(parameters);

        sqlSession.commit();
        sqlSession.close();

    }*/

}