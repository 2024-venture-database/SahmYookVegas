package com.SYVegas.chip;

import java.util.Date;

public class Log {

    private int log_code;
    private Date log_date;
    private int log_money;
    private String log_kind_money;
    private String log_activity;
    private String log_customer_id;

    public int getLog_code() {
        return log_code;
    }

    public void setLog_code(int log_code) {
        this.log_code = log_code;
    }

    public Date getLog_date() {
        return log_date;
    }

    public void setLog_date(Date log_date) {
        this.log_date = log_date;
    }

    public int getLog_money() {
        return log_money;
    }

    public void setLog_money(int log_money) {
        this.log_money = log_money;
    }

    public String getLog_kind_money() {
        return log_kind_money;
    }

    public void setLog_kind_money(String log_kind_money) {
        this.log_kind_money = log_kind_money;
    }

    public String getLog_activity() {
        return log_activity;
    }

    public void setLog_activity(String log_activity) {
        this.log_activity = log_activity;
    }

    public String getLog_customer_id() {
        return log_customer_id;
    }

    public void setLog_customer_id(String log_customer_id) {
        this.log_customer_id = log_customer_id;
    }
}
