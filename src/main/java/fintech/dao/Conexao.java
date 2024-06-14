package fintech.dao;
  
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  
  public class Conexao{
  
	  private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	  private static final String USUARIO = "RM552854";
	  private static final String SENHA = "fiap24";
	  
	  public static Connection abrirConexao() {
		  		  
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		}catch (ClassNotFoundException e ) {
			
			System.out.println("Erro de conexão com o BD");
			
		}catch (SQLException e) {
			System.out.println("Erro de conexão! Url, usuario e senha incorretos");
		}
		
		return conexao;
		  
    }
  }