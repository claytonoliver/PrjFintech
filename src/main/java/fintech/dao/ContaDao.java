package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.bean.*;

public class ContaDao {

	
	public ContaDao() {

	}

	private Connection conexao;
	
	public ContaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createConta(ContaModel conta, long cpf) {
		
		String query = "INSERT INTO T_FNT_CONTA " + "values  (idconta.nextval, (select id_usuario from T_FNT_usuario where nr_cpf = "+ cpf + "),"
				+ "?,?,?);";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setString(1, conta.getTipoConta());
			ps.setString(2, conta.getMoeda());
			ps.setDouble(3, conta.getSaldoConta());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public List<ContaModel> getAllContas() {
		
		List<ContaModel> listConta = new ArrayList<>();
		
		String query = "SELECT * FROM T_FNT_CONTAS";
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				ContaModel conta = new ContaModel();
				
				conta.setIdConta(resultSet.getInt("id_conta"));
				conta.setIdUsuario(resultSet.getInt("id_usuario"));
				conta.setTipoConta(resultSet.getString("nm_tipo"));
				conta.setMoeda(resultSet.getString("nm_moeda"));
				conta.setSaldoConta(resultSet.getDouble("vl_saldo"));

				listConta.add(conta);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listConta;
		
	}
	
}
