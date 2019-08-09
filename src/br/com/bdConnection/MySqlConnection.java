package br.com.bdConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    public static String status = "Connected unsucceful";

    public MySqlConnection() {}

    public static Connection getConnection() {
        Connection connection = null;

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "localhost";
            String db = "pedidos";
            String url = "jdbc:mysql://" + serverName + "/" + db;
            String userName = "administrador";
            String password = "administrador";

            connection = DriverManager.getConnection(url, userName, password);

            if(connection != null) {
                status = "Connected succeful";
            }

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
            return null;
        } catch (SQLException e) {
            System.out.println("Not possible to connect to mysql");
            return null;
        }
    }

    public static String getConnectionStatus() {
        return status;
    }

    public static boolean closeConnection() {
        MySqlConnection.closeConnection();
        return true;
    }

    public static Connection restartConnection() {
        closeConnection();

        return MySqlConnection.getConnection();
    }
}
