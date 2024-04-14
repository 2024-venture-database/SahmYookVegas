package com.SYVegas.common;

import com.SYVegas.common.DepositAndPurchase.depositManager;
import com.SYVegas.common.DepositAndPurchase.productPurchase;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

       depositManager DepositManager = new depositManager();
       DepositManager.depositMoney();

       productPurchase purchase = new productPurchase();
       purchase.productPaymentType();

        }


    }