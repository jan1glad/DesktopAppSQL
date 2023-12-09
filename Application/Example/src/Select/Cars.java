package Select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cars {
        public ResultSet klienci(){
            ResultSet resultSet = null;
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");

                Statement statement = connection.createStatement();

                resultSet = statement.executeQuery("select * from klienci order by id");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultSet;
        }
        public ResultSet ceo(){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from ceo order by I_D");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet modele(){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from modele order by Identyfikator");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet zamowienia(){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cars", "root", "");

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from zamowienia order by Identyfikator");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static void main(String[] args) {
        Cars cars = new Cars();

    }
}



