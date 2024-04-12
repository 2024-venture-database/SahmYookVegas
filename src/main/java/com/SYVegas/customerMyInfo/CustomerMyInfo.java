package com.SYVegas.customerMyInfo;

import com.SYVegas.common.CustomerDTO;
import com.SYVegas.common.SearchCriteria;

import java.util.List;

public interface CustomerMyInfo {


    List<CustomerDTO> searchCustomer(SearchCriteria searchCriteria);
}
