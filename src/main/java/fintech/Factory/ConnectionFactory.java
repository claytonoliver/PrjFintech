package fintech.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection conexao;

    private ConnectionFactory() {

    }

    public static Connection getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) {
                String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
                String usuario = "RM552854";
                String senha = "fiap24";


                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

                conexao = DriverManager.getConnection(url, usuario, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
}
