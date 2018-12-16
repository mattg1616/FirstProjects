import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String username = "postgres";
        String password = "@Skater4life";
        String host = "localhost";
        String database = "test";
        String port = "5432";


        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager
            .getConnection(String.format("jdbc:postgresql://%s:%s/%s", host, port, database),
                           username, password);

        if (conn == null) {
            throw new RuntimeException("Failed connection");
        }


        String selectUsers = "select * from users";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(selectUsers);
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            users.add(new User(resultSet));
        }

        System.out.println("Done fetching");

        for (User user : users) {
            System.out.println(user);
        }
    }
}
