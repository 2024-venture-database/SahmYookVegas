package com.SYVegas.customerMyInfo;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    /*CREATE TABLE customer
            (
                    customer_id VARCHAR(255) NOT NULL, -- 이용자 ID ,중복 허용 X, 기본키
    customer_password VARCHAR(255) NOT NULL, -- 이용자 비밀번호
    customer_name VARCHAR(255) NOT NULL, -- 이용자 이름
    customer_phone VARCHAR(255) default 'none', -- 이용자 전화번호 null 가능

    customer_balance INT default 0, -- 이용자 지갑 잔액
    customer_credit INT default 0, -- 이용자 크레딧 잔액
    customer_rank varchar(255) default 'n1', -- 이용자 등급 코드(외래키)
    PRIMARY KEY (customer_id),
    FOREIGN KEY (customer_rank) REFERENCES vegas_rank(vegas_rank_id)
            );*/

    private String id;
    private String password;
    private String name;
    private String phone;
    private int balance;
    private int credit;
    private  String rank;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String password, String name, String phone, int balance, int credit, String rank) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", credit=" + credit +
                ", rank='" + rank + '\'' +
                '}';
    }
}
