package Lesson7_HomeWork.DB;

import Lesson7_HomeWork.server.AuthenticationService;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Users_Repository {
    public Set<AuthenticationService.Entry> findAll(){
        Connection connection = DBConection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat_users");
            Set<AuthenticationService.Entry> entries = new HashSet<>();
            while (resultSet.next()){
                entries.add(new AuthenticationService.Entry(
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password")
                ));
            }
            return entries;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            close(connection);
        }
    }

    public Optional<AuthenticationService.Entry> findEntryForChangeName(String name){
        Connection connection = DBConection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chat_users WHERE Name = "+name);
            if (resultSet.next()){
                return Optional.of(new AuthenticationService.Entry(
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password")
                ));
            }
            else return Optional.empty();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            close(connection);
        }
    }
    public boolean update(AuthenticationService.Entry entry){
        Connection connection = DBConection.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("UPDATE chat_user SET Name = ? WHERE Login = ?");
            statement.setString(1, entry.getName());
            statement.setString(2, entry.getLogin());
            boolean result = statement.execute();
            connection.commit();
            return result;

        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(throwables);
        }
        finally {
            close(connection);
        }

    }

    private void close (Connection connection){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
