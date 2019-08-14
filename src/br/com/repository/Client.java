package br.com.repository;

import br.com.bdConnection.MySqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    private int id;
    private String name;
    private double saldo;

    public Client(String name, double saldo) throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT (id  + 1) AS id FROM Cliente ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }
        this.name = name;
        this.saldo = saldo;

        statement.close();

        saveData();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSaldo(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    public void remSaldo(double saldo) {
        this.saldo = this.saldo - saldo;
    }

    public void saveData() throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Cliente WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            statement.executeUpdate("INSERT INTO CLIENTE (nome, saldo) VALUES ('"+this.name+"', '"+this.saldo+"')");
        } else {
            statement.executeUpdate("UPDATE CLIENTE SET nome = '"+this.name+"', saldo =  '"+this.saldo+"' WHERE id = '"+this.id+"' ;");
        }

        statement.close();
    }
}
