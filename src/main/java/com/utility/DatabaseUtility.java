package com.utility;

import java.sql.*;

public class DatabaseUtility {

    private Connection connection;
    private Statement statement;

    public DatabaseUtility(String url,String user,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
        try {
            return statement.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void close(){
        try{
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
