package com.SYVegas.check_customerInfoAndLog.check_customerInfo;

public class CustomerInfo implements java.io.Serializable {
    private int code;
    private String name;
    private String id;
    private String password;
    private String phone;
    private String birth;
    private int balance;
    private int credit;
    private int rank;

    public CustomerInfo() {
    }

    public CustomerInfo(int code, String name, String id, String password, String phone, String birth, int balance, int credit, int rank) {
        this.code = code;
        this.name = name;
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.balance = balance;
        this.credit = credit;
        this.rank = rank;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "사용자 정보" +
                " [사용자 코드]: " + code +
                " [이름]: " + name +
                " [ID]: " + id +
                " [PASSWORD]: " + password +
                " [전화번호]: " + phone +
                " [생일]: " + birth +
                " [지갑 잔액]: " + balance +
                " [크래딧 잔액]: " + credit +
                " [등급]: " + rank
                ;
    }
}
