package com.SYVegas.common.DepositAndPurchase;

import java.util.List;
import java.util.Map;

public interface SYUVegasMapper {

    //상품 구매

    void updateCustomerBalance(Map<String, Object> parameters);

    void updateCreditBalance(Map<String, Object> parameters);

    List<ProductDTO> getproductListByType();

    void insertPurchaseLog(Map<String, Object> parameters);

    //지갑 충전

    void updateCustomerWallet(Map<String, Object> parameters);

    int getCustomerBalance(String customerId);

    float getCustomerCreditRate(String customerId);

    int getCustomerCredit(String customerId);


    void insertMoneyExchangeLog(Map<String, Object> parameters);
}