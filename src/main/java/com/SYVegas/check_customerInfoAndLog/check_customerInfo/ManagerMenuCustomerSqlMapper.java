package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

import com.SYVegas.check_customerInfoAndLog.check_Log.Log;

import java.util.List;

public interface ManagerMenuCustomerSqlMapper {

    List<CustomerInfo> selectAllManagerMenuCustomerInfo();


    List<CustomerInfo> deleteCustomerMangerMenuLog(String cid);
}



