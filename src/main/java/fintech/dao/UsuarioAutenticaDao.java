package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.bean.*;

public class UsuarioAutenticaDao {

	
	
public UsuarioAutenticaDao() {

	}

private Connection conexao;
	
	public UsuarioAutenticaDao(Connection conexao) {
			this.conexao = conexao;
		}
		
	public void createInvestimento(UsuarioAutenticaModel autentica, int idUsuario) {
			
			String query = "INSERT T_FNT_USUARIO_AUTENTICA " 
			+ "values  (idUsuarioautentica.nextval, "
			+ " (select id_usuario from T_FNT_USUARIO where id_conta = "+ idUsuario + ")," 
			+ "?,?,?,?);";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(query);
				Date data = Date.valueOf(autentica.getUltimoAcesso());
				ps.setDate(1, data);
				ps.setString(2, autentica.getLogin());
				ps.setInt(3, autentica.getFalhaAutentica());
				ps.setString(4, autentica.getSenha());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public List<UsuarioAutenticaModel> getAllUsuarioAutentica() {
			
			List<UsuarioAutenticaModel> listAutentica = new ArrayList<>();
			
			String query = "SELECT * FROM T_FNT_USUARIO_AUTENTICA";
			
			try {
				
				PreparedStatement ps = conexao.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					UsuarioAutenticaModel autentica = new UsuarioAutenticaModel();
					
					autentica.setIdAutentica(resultSet.getInt("ID_AUTENTICA"));
					autentica.setIdUsuario(resultSet.getInt("ID_USUARIO"));
					autentica.setUltimoAcesso(resultSet.getDate("DT_ULTIMO_ACESSO").toLocalDate());
					autentica.setLogin(resultSet.getString("NM_LOGIN"));
					autentica.setFalhaAutentica(resultSet.getString("NR_FALHAS_AUTENTICA").charAt(0));
					autentica.setSenha(resultSet.getString("senha"));
					
					listAutentica.add(autentica);
				}
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listAutentica;
			
		}
}
