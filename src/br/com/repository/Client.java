package br.com.repository;

import br.com.bdConnection.MysqlConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private Integer id;
    private String name;
    private Double balance;

    public Client(String name, Double balance) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        ResultSet result = conn.query("SELECT (id  + 1) AS id FROM Cliente ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }
        this.name = name;
        this.balance = balance;

        saveData();
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getSaldo() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSaldo(double saldo) {
        this.balance = this.balance + saldo;
    }

    public void remSaldo(double saldo) {
        this.balance = this.balance - saldo;
    }

    private void saveData() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet result = conn.query("SELECT * FROM Cliente WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            conn.insert("INSERT INTO Cliente (nome, saldo) VALUES ('"+this.name+"', '"+this.balance+"')");
        } else {
            conn.insert("UPDATE Cliente SET nome = '"+this.name+"', saldo =  '"+this.balance+"' WHERE id = '"+this.id+"' ;");
        }
    }
}
