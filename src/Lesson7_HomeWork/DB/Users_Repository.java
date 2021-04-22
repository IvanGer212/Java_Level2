package Lesson7_HomeWork.DB;

import Lesson7_HomeWork.server.AuthenticationService;

import java.sql.*;
import java.util.Optional;


public class Users_Repository {

    public Optional<AuthenticationService.Entry> findEntryFromName(String name){
        Connection connection = DBConection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chat_users WHERE Name = ?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
               return Optional.of(new AuthenticationService.Entry(
                       resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password")));

            }
            else return Optional.empty();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            close(connection);
        }
    }

    public Optional<AuthenticationService.Entry> findEntryForAuthentication(String login, String password){
        Connection connection = DBConection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chat_users WHERE Login =? and Password = ?;");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return Optional.of(new AuthenticationService.Entry(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password")));

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
            PreparedStatement statement = connection.prepareStatement("UPDATE chat_users SET Name = ? WHERE Login = ?");
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
