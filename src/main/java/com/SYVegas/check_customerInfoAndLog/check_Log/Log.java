package com.SYVegas.check_customerInfoAndLog.check_Log;

public class Log {
    private int code;
    private String date;
    private int amount;

    public Log() {
    }

    public Log(int code, String date, int amount) {
        this.code = code;
        this.date = date;
        this.amount = amount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "로그 " +
                " [로그번호]: " + code +
                " [날짜]: " + date +
                " [돈]: " + amount ;
    }
}
