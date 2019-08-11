import br.com.bdConnection.MySqlConnection;
import br.com.repository.Client;
import br.com.repository.Address;
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
            System.out.println("Usuário " + " ID: " + result.getString(1) + " - Nome: " + result.getString(2) +  " - Saldo: " + result.getString(3) + " criado com sucesso!" );
            System.out.println();
        }

        System.out.println("Agora vamos para o endereco do cliente. Por favor, digite o logradouro: ");
        String address = scanner.nextLine();

        System.out.println("Muito bem, preciso do número da residência:");
        int addressNumber = scanner.nextInt();

        System.out.println("Perfeito, e qual é a cidade?");
        String city = scanner.nextLine();

        System.out.println("Anotado. Agora para finalizar, preciso que informe o estado (somente as siglas): ");
        String uf = scanner.nextLine();

        Address clientAddress = new Address(client.getId(), address, addressNumber, city, uf);

        result = statement.executeQuery("SELECT * FROM Endereco WHERE id = '"+clientAddress.getId()+"' ");

        while(result.next()) {
            System.out.println("O endereco: " +
                    " ID: " + result.getString(1) +
                    " - Logradouro: " + result.getString(3) +
                    " - Numero: " + result.getString(4) +
                    " Cidade: " + result.getString(5) +
                    " UF: " + result.getString(6) +
                    "foi registrado para o usuário " + client.getName());
            System.out.println();
        }


        statement.close();
    }
}
