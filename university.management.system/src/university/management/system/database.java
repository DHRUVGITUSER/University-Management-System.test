package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database {
    Connection connection;
    Statement statement;

    public database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universitymanagement",
                    "root",
                    "WJ28@krhps"
            );
            statement = connection.createStatement();
            System.out.println("Database connected successfully!");

            // Sample query to test data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Login");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new database();
}
}