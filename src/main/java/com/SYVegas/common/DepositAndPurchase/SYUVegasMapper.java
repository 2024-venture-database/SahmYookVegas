package com.SYVegas.common.DepositAndPurchase;

import java.util.List;
import java.util.Map;

public interface SYUVegasMapper {

    //상품 구매
    int updateCustomerBalance(int depositAmount);

    void updateCreditBalance(float creditAmount);

    List<ProductDTO> getproductListByType(String productType);

    void updateProductQuantity(int code, int qty);

    void insertPurchaseLog(Object o, Object o1, Object o2, String 상품구매, String customerId);


    //지갑 충전

    int updateCustomerWallet(Map<String, Object> parameters);

    int getCustomerBalance(String customerId);

    float getCustomerCreditRate(String customerId);

    int getCustomerCredit(String customerId);
}
