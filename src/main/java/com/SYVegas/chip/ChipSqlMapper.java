package com.SYVegas.chip;

import com.mysql.cj.log.Log;

import java.util.List;
import java.util.Map;

public interface ChipSqlMapper {

    int updateChipTransaction(Map<String, Object> chipTransactionUpdate);

    List<Log> selectAllLogs();

    void updateWallet(Map<String, Object> walletUpdateParams);
    

    int returnChips(Map<String, Object> walletUpdateParams);

    int getWalletAmount(Map<String, Object> chipExchangeReturn);

    int getBalance(String id);


    int exchangeChips(Map<String, Object> chipExchange);
}
