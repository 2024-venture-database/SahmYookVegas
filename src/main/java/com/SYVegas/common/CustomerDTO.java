package com.SYVegas.common;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    /*
*
*customer_code INT NOT NULL AUTO_INCREMENT,
customer_name VARCHAR(255) NOT NULL,
customer_id VARCHAR(255) NOT NULL UNIQUE,
customer_password VARCHAR(255) NOT NULL,
customer_phone VARCHAR(255),
customer_birth VARCHAR(255),
customer_address VARCHAR(255),
customer_balance INT,
customer_credit INT,
customer_rank INT NOT NULL,
*
* */
    private static int code;
    private String name;
    private String id;
    private String password;
    private String phone;
    private String birth;
    private String address;
    private int balance;
    private int credit;
    private int rank;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String id, String password, String phone, String birth, String address, int balance, int credit, int rank) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
        this.balance = balance;
        this.credit = credit;
        this.rank = rank;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        CustomerDTO.code = code;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", credit=" + credit +
                ", rank=" + rank +
                '}';
    }
}
