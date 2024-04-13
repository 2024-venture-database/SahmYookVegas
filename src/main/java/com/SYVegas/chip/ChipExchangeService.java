package com.SYVegas.chip;

public interface ChipExchangeService {

    int exchangeChips(int money, int[] chipCounts);

    int getExchangedAmount();
}