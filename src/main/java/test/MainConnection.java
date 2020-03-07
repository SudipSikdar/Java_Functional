package test;

import java.sql.*;

public class MainConnection {

    public static void main(String[] args) {

        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("mystring");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from table x");
            while(resultSet.next()){

                resultSet.getString(0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
