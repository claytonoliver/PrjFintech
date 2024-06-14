package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fintech.bean.*;

public class TransacaoDao {

private Connection conexao;
	
	

	public TransacaoDao() {

}

	public TransacaoDao(Connection conexao) {
			this.conexao = conexao;
		}
		
	public void createTransacao(TransacaoModel transacao, int idConta, int idCategoria) {
			
			String query = "INSERT INTO T_FNT_TRANSACAO " 
			+ "values  (idinvestimento.nextval, "
			+ " (select id_conta from T_FNT_CONTA where id_conta = "+ idConta + "),"
			+ " (select id_categoria from T_FNT_CATEGORIA where id_categoria = "+ idCategoria + "),"
			+ "?,?,?,?);";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(query);
				Date data = Date.valueOf(transacao.getDataTransacao());
				ps.setDate(1, data);
				ps.setDouble(2, transacao.getValorTransacao());
				ps.setString(3, transacao.getDestino());
				ps.setString(4, transacao.getDescricao());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public List<TransacaoModel> getAllTransacao() {
			
			List<TransacaoModel> listTransacao = new ArrayList<>();
			
			String query = "SELECT * FROM T_FNT_TRANSACAO";
			
			try {
				
				PreparedStatement ps = conexao.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					TransacaoModel transacao = new TransacaoModel();
					
					transacao.setIdTransacao(resultSet.getInt("ID_TRANSACAO"));
					transacao.setIdConta(resultSet.getInt("ID_CONTA"));
					transacao.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
					transacao.setDataTransacao(resultSet.getDate("DT_TRANSACAO").toLocalDate());
					transacao.setValorTransacao(resultSet.getDouble("VL_VALOR"));
					transacao.setDestino(resultSet.getString("NM_DESCRICAO"));
					transacao.setDescricao(resultSet.getString("DS_DESCRICAO"));
					
					listTransacao.add(transacao);
				}
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listTransacao;
			
		}
}
