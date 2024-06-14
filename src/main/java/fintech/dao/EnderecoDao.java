package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fintech.bean.*;

public class EnderecoDao {

	
public EnderecoDao() {

	}

private Connection conexao;
	
public EnderecoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
public void createEnderecop(EnderecoModel endereco, int idUsuario, int idLogradouro) {
		
		String query = "INSERT INTO T_FNT_Endereco " 
		+ "values  (idconta.nextval, "
		+ " (select id_usuario from T_FNT_usuario where nr_cpf = "+ idUsuario + "),"
		+ "(selelect id_logradouro from T_fnt_logradouro where id = " + idLogradouro +")," 
		+ "?,?,?);";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setString(1, endereco.getNomeCidade());
			ps.setString(2, endereco.getNomeEstado());
			ps.setString(3, endereco.getComplemento());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public List<EnderecoModel> getAllEnderecos() {
		
		List<EnderecoModel> listEndereco = new ArrayList<>();
		
		String query = "SELECT * FROM T_FNT_ENDERECO";
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				EnderecoModel endereco = new EnderecoModel();
				
				endereco.setId_endereco(resultSet.getInt("id_endereco"));
				endereco.setId_usuario(resultSet.getInt("id_usuario"));
				endereco.setId_logradouro(resultSet.getInt("id_logradouro"));
				endereco.setNomeCidade(resultSet.getString("nm_cidade"));
				endereco.setNomeEstado(resultSet.getString("nm_estado"));
				endereco.setComplemento(resultSet.getString("nm_complemento"));

				listEndereco.add(endereco);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listEndereco;
		
	}
}
