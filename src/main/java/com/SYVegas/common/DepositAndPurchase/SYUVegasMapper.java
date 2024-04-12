package com.SYVegas.common.DepositAndPurchase;

import java.util.List;

public interface SYUVegasMapper {

    void depositManager(int choice, int i);

    void purchaseProduct(int choice, String name, int productPrice);

    int updateCustomerBalance(int depositAmount, int customerId);

    float getVegasCreditRateByRank();

    void updateCreditBalance(float creditAmount, int customerId);
}
