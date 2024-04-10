package com.SYVegas.check_customerInfoAndLog.check_Log;

import java.util.List;

public interface ManagerMenuLogSqlMapper {

    List<Log> selectAllMangerMenuLog();

    List<Log> searchCustomerMangerMenuLog(String cname);

    List<Log> sumAllMangerMenuLog();
}
