package com.SYVegas.chip;

public interface ChipExchangeService {

    void exchangeChips(int money, int[] chipCounts);

    int getExchangedAmount();
}