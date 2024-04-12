package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

public class CustomerInfo implements java.io.Serializable {
    private String id;
    private String name;
    private String password;
    private String phone;
    private int balance;
    private int credit;
    private String rank;

    public CustomerInfo() {
    }

    public CustomerInfo( String id, String name, String password, String phone, int balance, int credit, String rank) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        this.credit = credit;
        this.rank = rank;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "사용자 정보" +
                " [ID]: " + id +
                " [이름]: " + name +
                " [PASSWORD]: " + password +
                " [전화번호]: " + phone +
                " [지갑 잔액]: " + balance +
                " [크래딧 잔액]: " + credit +
                " [등급]: " + rank
                ;
    }
}
