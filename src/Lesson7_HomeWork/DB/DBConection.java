package Lesson7_HomeWork.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user_test",
                    "root",
                    "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
