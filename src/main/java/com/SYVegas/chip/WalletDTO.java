package com.SYVegas.chip;

public class WalletDTO {

    private int userId;
    private int amount;

    public WalletDTO() {
        this.userId = userId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "지갑 정보: " + amount;
    }

}
