package com.SYVegas.chip;

public class ChipReturnServiceImpl implements ChipReturnService {
    @Override
    public int returnChips(int[] chipCountsToReturn) {
        int totalReturnedMoney = 0;
        int[] chipValues = {100, 50, 10, 5, 1};

        for (int i = 0; i < chipCountsToReturn.length; i++) {
            totalReturnedMoney += chipCountsToReturn[i] * chipValues[i];
        }

        return totalReturnedMoney;
    }
}