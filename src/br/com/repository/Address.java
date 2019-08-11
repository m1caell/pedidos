package br.com.repository;

import br.com.bdConnection.MySqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {

    private int id;
    private int clientId;
    private String address;
    private int addressNumber;
    private String city;
    private String uf;

    public Address(int clientId, String address, int addressNumber, String city, String uf) throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();
        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT (id  + 1) AS id FROM Endereco ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }

        this.clientId = clientId;
        this.address = address;
        this.addressNumber = addressNumber;
        this.city = city;
        this.uf = uf;

        statement.close();
        saveData();
    }

    public void saveData() throws SQLException {
        java.sql.Connection conn = MySqlConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Endereco WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            statement.executeUpdate("INSERT INTO Endereco (idCliente, endereco, numero, cidade, uf) " +
                    "VALUES ('"+this.clientId+"', '"+this.address+"', '"+this.addressNumber+"', '"+this.city+"', '"+this.uf+"')");
        } else {
            statement.executeUpdate("UPDATE Endereco " +
                    "SET idCliente = '"+this.clientId+"', endereco =  '"+this.address+"', numero = '"+this.addressNumber+"', cidade = '"+this.city+"', uf = '"+this.uf+"' " +
                    "WHERE id = '"+this.id+"' ;");
        }

        statement.close();

    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
