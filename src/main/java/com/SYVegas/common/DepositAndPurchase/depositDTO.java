package com.SYVegas.common.DepositAndPurchase;

import java.io.Serializable;

public class depositDTO {

        private String id;
        private String name;
        private int balance;
        private int credit;
        private String rank;

    public depositDTO() {
    }

    public depositDTO(String id, String name, int balance, int credit, String rank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.credit = credit;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "depositDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", credit=" + credit +
                ", rank='" + rank + '\'' +
                '}';
    }
}
