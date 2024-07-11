import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/Users/alex2/Downloads/test.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
                Statement stmt = conn.createStatement();
                // Create a table if it does not exist
                stmt.execute("CREATE TABLE IF NOT EXISTS test (id INTEGER PRIMARY KEY, name TEXT)");
                // Insert a sample record
                stmt.execute("INSERT INTO test (name) VALUES ('Sample Data')");
                // Query and print the results
                var resultSet = stmt.executeQuery("SELECT * FROM test");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
