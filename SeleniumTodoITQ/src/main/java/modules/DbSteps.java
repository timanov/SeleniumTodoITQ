package modules;

import java.sql.*;

public class DbSteps {

    public static String responseQuery = "";

    public DbSteps DbQuerySelect(String query, String column) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/TodoProject?autoReconnect=true&useSSL=false", "mysql", "mysql");
        Statement statement = con.createStatement();
        ResultSet queryResponse = statement.executeQuery(query);
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

        return this;
    }

}
