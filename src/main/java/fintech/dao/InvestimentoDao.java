package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fintech.bean.*;

public class InvestimentoDao {
	private Connection conexao;
	
	
	
	public InvestimentoDao() {

	}

	public InvestimentoDao(Connection conexao) {
			this.conexao = conexao;
		}
		
	public void createInvestimento(InvestimentoModel investimento, int idConta) {
			
			String query = "INSERT INTO T_FNT_INVESTIMENTO " 
			+ "values  (idinvestimento.nextval, "
			+ " (select id_conta from T_FNT_CONTA where id_conta = "+ idConta + ")," 
			+ "?,?,?,?,?);";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(query);
				ps.setString(1, investimento.getNomeInvestimento());
				ps.setString(2, investimento.getTipoInvestimento());
				ps.setDouble(3, investimento.getValorInvestimento());
				Date data = Date.valueOf(investimento.getDataCompra());
				ps.setDate(4, data);
				ps.setString(5, investimento.getDescricao());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public List<InvestimentoModel> getAllInvestimento() {
			
			List<InvestimentoModel> listInvestimento = new ArrayList<>();
			
			String query = "SELECT * FROM T_FNT_INVESTIMENTO";
			
			try {
				
				PreparedStatement ps = conexao.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					InvestimentoModel investimento = new InvestimentoModel();
					
					investimento.setIdInvestimento(resultSet.getInt("ID_INVESTIMENTO"));
					investimento.setIdConta(resultSet.getInt("ID_CONTA"));
					investimento.setNomeInvestimento(resultSet.getString("NM_INVESTIMENTO"));
					investimento.setTipoInvestimento(resultSet.getString("NM_TIPO"));
					investimento.setValorInvestimento(resultSet.getDouble("VL_VALOR"));
					investimento.setDataCompra(resultSet.getDate("DT_COMPRA").toLocalDate());
					investimento.setDescricao(resultSet.getString("DS_DESCRICAO"));
					
					listInvestimento.add(investimento);
				}
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listInvestimento;
			
		}
	}