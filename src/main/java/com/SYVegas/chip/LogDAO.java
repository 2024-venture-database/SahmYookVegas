package com.SYVegas.chip;

import java.sql.*;

public class LogDAO {
    private final String url;
    private final String user;
    private final String password;

    public LogDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void insertLog() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SQL 쿼리 실행
            statement.executeUpdate("insert into log(log_date, log_money, log_kind_money, log_activity, log_customer_id) " +
                    "values(curdate(),5000000,'지갑','충전','hhh'), " +
                    "(curdate(),-200000,'지갑','칩교환','aaa'), " +
                    "(curdate(),-200000,'지갑','칩교환','hhh'), " +
                    "(curdate(),300000,'지갑','칩반환','hhh'), " +
                    "(curdate(),-2000,'크레딧','상품구매','bbb')");

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
