package com.SYVegas.check_customerInfoAndLog.check_Log;

public class Log {
    private int code;
    private String customer_id;
    private String date;
    private String activity;
    private int money;
    private String kind_money;

    public Log() {
    }

    public Log(int code, String customer_id, String date, String activity, int money, String kind_money) {
        this.code = code;
        this.customer_id = customer_id;
        this.date = date;
        this.activity = activity;
        this.money = money;
        this.kind_money = kind_money;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getKind_money() {
        return kind_money;
    }

    public void setKind_money(String kind_money) {
        this.kind_money = kind_money;
    }

    @Override
    public String toString() {
        return   code +
                " [이용자ID]: " + customer_id +
                " [날짜]: " + date +
                " [사용처]: " + activity +
                " [금액]:  "+ money +
                " [지불방법]: " + kind_money
                ;
    }
}
