package br.com.repository;

import br.com.bdConnection.MySqlConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    private Long id;
    private String name;
    private double saldo;

    public Client(String name, double saldo) throws SQLException {
        this.name = name;
        this.saldo = saldo;

        java.sql.Connection conn = MySqlConnection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO CLIENTE (nome, saldo) VALUES ('"+this.name+"', '"+this.saldo+"')");
    }

    public Long getId() {
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
}
