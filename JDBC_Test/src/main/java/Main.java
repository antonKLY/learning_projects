import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "895623Qwerty!";
        String sqlQuery = "SELECT pl.course_name, COUNT(pl.subscription_date)/(MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)) + 1) per " +
                "FROM PurchaseList pl " +
                "WHERE YEAR(pl.subscription_date) = ? " +
                "GROUP BY pl.course_name " +
                "ORDER BY per DESC";
        int year = 2018;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url,user,pass);
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,year);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + "   "
                        + resultSet.getString(2));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) { e.printStackTrace(); }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) { e.printStackTrace(); }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}
