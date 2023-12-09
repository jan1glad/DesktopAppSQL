package Insert;
import java.sql.*;

public class SQL {
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        SQL sqlInsert = new SQL();
        sqlInsert.getConnection();

    }
}



