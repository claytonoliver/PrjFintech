package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fintech.bean.*;

public class MetaDao {

	
public MetaDao() {

	}

private Connection conexao;
	
	public MetaDao(Connection conexao) {
			this.conexao = conexao;
		}
		
	public void createMeta(MetaModel meta, int idInvestimento) {
			
			String query = "INSERT INTO T_FNT_META " 
			+ "values  (idmeta.nextval, "
			+ " (select id_investimento from T_FNT_META where id_investimento = "+ idInvestimento + ")," 
			+ "?,?,?,?);";
			
			try {
				PreparedStatement ps = conexao.prepareStatement(query);
				
				ps.setDate(4, Date.valueOf(meta.getPrazoFim()));
				ps.setDate(4, Date.valueOf(meta.getPrazoFim()));
				ps.setDouble(5, meta.getValorAlvo());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public List<MetaModel> getAllMeta() {
			
			List<MetaModel> listMeta = new ArrayList<>();
			
			String query = "SELECT * FROM T_FNT_INVESTIMENTO";
			
			try {
				
				PreparedStatement ps = conexao.prepareStatement(query);
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					MetaModel meta = new MetaModel();
					
					meta.setIdMeta(resultSet.getInt("ID_META"));
					meta.setIdInvestimento(resultSet.getInt("ID_INVESTIMENTO"));
					meta.setPrazoInicio(resultSet.getDate("DT_PRAZO_INICIO").toLocalDate());
					meta.setPrazoFim(resultSet.getDate("DT_PRAZO_FIM").toLocalDate());
					meta.setNomeMeta(resultSet.getString("NM_META"));
					meta.setValorAlvo(resultSet.getDouble("NM_META"));
					
					listMeta.add(meta);
				}
				
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listMeta;
			
		}
}
