package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fintech.bean.*;

public class LogradouroDao {

	
	
public LogradouroDao() {

	}

private Connection conexao;
	
	public LogradouroDao(Connection conexao) {
			this.conexao = conexao;
		}
		
	public void createLogradouro(LogradouroModel logardouro) {
			
			String query = "INSERT INTO T_FNT_LOGRADOURO VALUES (idlogradouro.nextval, ?, ?, ?)";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(query);
				ps.setString(1, logardouro.getNome());
				ps.setLong(2, logardouro.getNumero());
				ps.setLong(3, logardouro.getCep());
				
				ps.execute();

				ps.close();

				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public List<LogradouroModel> getAllLogradouro() {
			
			List<LogradouroModel> listLogradouro = new ArrayList<>();
			
			String query = "SELECT * FROM T_FNT_LOGRADOURO";
			
			try {
				
				PreparedStatement ps = conexao.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					LogradouroModel logradouro = new LogradouroModel();
					
					logradouro.setId(resultSet.getInt("ID_LOGRADOURO"));
					logradouro.setNome(resultSet.getString("NM_RUA"));
					logradouro.setNumero(resultSet.getLong("NM_INVESTIMENTO"));
					logradouro.setCep(resultSet.getLong("NM_TIPO"));
					
					listLogradouro.add(logradouro);
				}
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listLogradouro;
			
		}
}
