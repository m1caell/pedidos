package br.com.repository;

import br.com.bdConnection.MysqlConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private int id;
    private String name;
    private double saldo;

    public Client(String name, double saldo) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();

        ResultSet result = conn.query("SELECT (id  + 1) AS id FROM Cliente ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }
        this.name = name;
        this.saldo = saldo;

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
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet result = conn.query("SELECT * FROM Cliente WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            conn.insert("INSERT INTO Cliente (nome, saldo) VALUES ('"+this.name+"', '"+this.saldo+"')");
        } else {
            conn.insert("UPDATE Cliente SET nome = '"+this.name+"', saldo =  '"+this.saldo+"' WHERE id = '"+this.id+"' ;");
        }
    }
}
