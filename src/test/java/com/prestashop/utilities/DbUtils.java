package com.prestashop.utilities;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbUtils {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;


     public static void setQuery(String query){
         try {
             connection= DriverManager.getConnection(ConfigurationReader.getProperty("dbUrl"),ConfigurationReader.getProperty("dbUserName"),
                     ConfigurationReader.getProperty("dbPassword"));
         } catch (SQLException e) {
             throw new RuntimeException("SQL- connection exception");
         }
         try {
             statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         } catch (SQLException e) {
             throw new RuntimeException("SQL- statement exception");
         }
         try {
             resultSet= statement.executeQuery(query);
         } catch (SQLException e) {
             new RuntimeException("SQL- query exception");
         }
     }

     public static void close(){
         try {
             if (resultSet != null) {
                 resultSet.close();
             }
             if (statement != null) {
                 statement.close();
             }
             if (connection != null) {
                 connection.close();
             }
         }
         catch (SQLException ex){
             throw new RuntimeException("SQL- close exception");
         }
    }

    public static List<Map<String,Object>> getDataList(){
         try {
             List<Map<String, Object>> list = new ArrayList<>();
             ResultSetMetaData rsMData = resultSet.getMetaData();
             int colCount = rsMData.getColumnCount();


             while (resultSet.next()) {
                 Map<String, Object> rowMap = new HashMap<>();
                 for (int i = 1; i <= colCount; i++) {
                     rowMap.put(rsMData.getColumnName(i), resultSet.getObject(i));

                 }
                 list.add(rowMap);
             }
             return list;
         }catch (SQLException e){
             throw new RuntimeException("SQL getDataList exception");
         }

    }

}
