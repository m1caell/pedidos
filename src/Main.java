import br.com.bdConnection.MySqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();

        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM Cliente");

        while(result.next()) {
            System.out.println("Resultado da busca: ");
            System.out.println("ID: " + result.getString(1));
            System.out.println("Nome: " + result.getString(2));
            System.out.println("Saldo: " + result.getString(3));
            System.out.println();

        }

        statement.close();
    }
}
