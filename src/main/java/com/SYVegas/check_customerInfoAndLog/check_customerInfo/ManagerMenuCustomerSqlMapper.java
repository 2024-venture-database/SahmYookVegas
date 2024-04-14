package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

import com.SYVegas.check_customerInfoAndLog.check_Log.Log;

import java.util.List;
import java.util.Map;

public interface ManagerMenuCustomerSqlMapper {

    List<CustomerInfo> selectAllManagerMenuCustomerInfo();

    int updateManagerMenuCustomerInfo(Map<String, Object> searchKey);

    int deleteMangerMenuCustomerInfo(Map<String, Object> searchKey);
}



