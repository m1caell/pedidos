import br.com.bdConnection.MySqlConnection;
import br.com.repository.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();

        Statement statement = conn.createStatement();

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o saldo inicial do cliente: ");
        double saldo = scanner.nextDouble();

        Client client = new Client(nome, saldo);

        ResultSet result = statement.executeQuery("SELECT * FROM Cliente WHERE id = '"+client.getId()+"' ");

        while(result.next()) {
            System.out.println("Resultado da busca: ");
            System.out.println("ID: " + result.getString(1));
            System.out.println("Nome: " + result.getString(2) + " - Nome na classe: " + client.getName());
            System.out.println("Saldo: " + result.getString(3) + " - Saldo na classe: " + client.getSaldo());
            System.out.println();
        }
        statement.close();
    }
}
