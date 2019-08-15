package br.com.repository;
import br.com.bdConnection.MysqlConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {

    private Integer id;
    private Integer clientId;
    private String address;
    private Integer addressNumber;
    private String city;
    private String uf;

    public Address(Integer clientId, String address, Integer addressNumber, String city, String uf) throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet result = conn.query("SELECT (id  + 1) AS id FROM Endereco ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }

        this.clientId = clientId;
        this.address = address;
        this.addressNumber = addressNumber;
        this.city = city;
        this.uf = uf;

        saveData();
    }

    public void saveData() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet result = conn.query("SELECT * FROM Endereco WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            conn.insert("INSERT INTO Endereco (idCliente, endereco, numero, cidade, uf) " +
                    "VALUES ('"+this.clientId+"', '"+this.address+"', '"+this.addressNumber+"', '"+this.city+"', '"+this.uf+"')");
        } else {
            conn.insert("UPDATE Endereco " +
                    "SET idCliente = '"+this.clientId+"', endereco =  '"+this.address+"', numero = '"+this.addressNumber+"', cidade = '"+this.city+"', uf = '"+this.uf+"' " +
                    "WHERE id = '"+this.id+"' ;");
        }
    }

    public Integer getId() {
        return id;
    }

    public Integer getClientId() {
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

    public Integer getAddressNumber() {
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
