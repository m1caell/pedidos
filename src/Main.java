import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MysqlConnect conexao = MysqlConnect.getDbCon();

        try {
            ResultSet rs = conexao.query("select * from Produto");

            while (rs.next()) {
                int i = rs.getInt("id");
                String nome = rs.getString("nome");
                System.out.println("-> = " + i + " " + nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
