package com.SYVegas.member;

import java.util.Map;

public interface CustomerMapper {

    void insertCustomer(Customer customer);
    Customer getCustomerByIdAndPassword(Map<String, String> credentials);

}
