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

    public void displayLog() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM log")) {

            while (resultSet.next()) {
                int log_id = resultSet.getInt("log_id");
                Date log_date = resultSet.getDate("log_date");
                double log_money = resultSet.getDouble("log_money");
                String log_kind_money = resultSet.getString("log_kind_money");
                String log_activity = resultSet.getString("log_activity");
                String log_customer_id = resultSet.getString("log_customer_id");

                // 결과 출력 또는 다른 작업 수행
                System.out.println("Log ID: " + log_id + ", Date: " + log_date + ", Money: " + log_money +
                        ", Kind of Money: " + log_kind_money + ", Activity: " + log_activity +
                        ", Customer ID: " + log_customer_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
