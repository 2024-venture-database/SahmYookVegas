package com.SYVegas.chip;

public class ChipExchangeServiceImpl implements ChipExchangeService {
    private int exchangedAmount;

    @Override
    public void exchangeChips(int money, int[] chipCounts) {
        int totalAmount = 0;
        for (int i = 0; i < chipCounts.length; i++) {
            totalAmount += chipCounts[i] * (i * 10 + 10);
        }

        System.out.println("돈을 칩으로 교환합니다.");

        exchangedAmount += totalAmount;
    }

    @Override
    public int getExchangedAmount() {
        return exchangedAmount;
    }
}