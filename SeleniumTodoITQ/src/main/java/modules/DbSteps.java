package modules;

import pages.login.LoginPage;

import java.sql.*;
import java.util.logging.Logger;

public class DbSteps {

    private static Logger log = Logger.getLogger(LoginPage.class.getName());
    public static String responseQuery = "";

    public DbSteps DbQuerySelect(String query, String column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/TodoProject?autoReconnect=true&useSSL=false", "mysql", "mysql");
        Statement statement = con.createStatement();
        ResultSet queryResponse = statement.executeQuery(query);
        log.info("Выполняем запрос: " + query + " и записываем в переменную значение столбца " + column);
        while (queryResponse.next()) {
            responseQuery = queryResponse.getString(column);
        }


        return this;
    }

    public DbSteps DbQueryInsert(String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/TodoProject?autoReconnect=true&useSSL=false", "mysql", "mysql");
        Statement statement = con.createStatement();
        statement.executeUpdate(query);
        log.info("Выполняем запрос: " + query);

        return this;
    }

}
