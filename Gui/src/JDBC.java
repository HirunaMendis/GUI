import javax.swing.*;
import java.sql.*;
import java.sql.SQLException;

public class JDBC {


    private static final String URL = "jdbc:mysql://localhost:3306/signup";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Static method to get the database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean registerUser(String name, String email, String gender, String password) {
        String query = "INSERT INTO user (Name, email, gender, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set parameters for the SQL query
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, gender);
            pstmt.setString(4, password);

            // Execute the update (insert)
            pstmt.executeUpdate();
            return true;  // Registration successful
        } catch (SQLException e) {
            e.printStackTrace();  // Print the exception if it occurs
        }
        return false;  // Registration failed
    }
}
