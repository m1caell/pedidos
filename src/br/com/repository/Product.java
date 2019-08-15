package br.com.repository;

import br.com.bdConnection.MysqlConnect;
import br.com.enums.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public abstract class Product {

    private Integer id;
    private String name;
    private Double unitPrice;
    private Integer stockQuantity;
    private Date dhCreated;
    private Date dhValid;
    private String desc;
    private ProductType type;

    public Product(String name,
                   Double unitPrice,
                   Integer stockQuantity,
                   Date dhCreated,
                   Date dhValid,
                   String desc,
                   ProductType type) throws SQLException {

        this.name = name;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.dhCreated = dhCreated;
        this.dhValid = dhValid;
        this.desc = desc;
        this.type = type;

        MysqlConnect conn = MysqlConnect.getDbCon();

        ResultSet result = conn.query("SELECT (id  + 1) AS id FROM Produto ORDER BY id DESC LIMIT 1");

        while (result.next()) {
            this.id = Integer.parseInt(result.getString(1));
        }

        saveData();
    }

    private void saveData() throws SQLException {
        MysqlConnect conn = MysqlConnect.getDbCon();
        ResultSet result = conn.query("SELECT * FROM Produto WHERE id = '"+this.id+"' ");

        if(!result.next()) {
            conn.insert("INSERT INTO Produto (Nome, ValorUnit, Saldo, DataFabricacao, DataValidade, Descricao) " +
                    "VALUES ('"+this.name+"', '"+this.unitPrice+"', '"+this.stockQuantity+"', '"+this.dhCreated+"', '"+this.dhValid+"', '"+this.desc+"' )");
        } else {
            conn.insert("UPDATE Produto " +
                    "SET nome = '"+this.name+"', ValorUnit = '"+this.unitPrice+"', Saldo = '"+this.stockQuantity+"', DataFabricacao = '"+this.dhCreated+"', DataValidade = '"+this.dhValid+"', Descricao = '"+this.desc+"'" +
                    "WHERE id = '"+this.id+"' ");
        }
    }

}
