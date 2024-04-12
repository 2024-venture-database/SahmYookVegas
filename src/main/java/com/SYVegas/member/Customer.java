package com.SYVegas.member;

public class Customer {

    private String customerId;
    private String customerPw;
    private String customerName;
    private String customerPhone;

    // 생성자, getter, setter 생략


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPw() {
        return customerPw;
    }

    public void setCustomerPw(String customerPw) {
        this.customerPw = customerPw;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Customer(String customerId, String customerPw, String customerName, String customerPhone) {
        this.customerId = customerId;
        this.customerPw = customerPw;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }
}
