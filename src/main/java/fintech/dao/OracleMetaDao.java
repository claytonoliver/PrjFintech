package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.Factory.ConnectionFactory;
import fintech.interfaces.IMeta;
import fintech.bean.MetaModel;

public class OracleMetaDao implements IMeta {

    private Connection conexao;

    public OracleMetaDao(Connection conexao) {
        this.conexao = conexao;
    }

    public OracleMetaDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void save(MetaModel meta, int idInvestimento) {
        String query = "INSERT INTO T_FNT_META "
                     + "(ID_META, ID_INVESTIMENTO, DT_PRAZO_INICIO, DT_PRAZO_FIM, NM_META, VL_META) "
                     + "VALUES (idmeta.nextval, "
                     + "(SELECT id_investimento FROM T_FNT_META WHERE id_investimento = ?), "
                     + "?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, idInvestimento);
            ps.setDate(2, Date.valueOf(meta.getPrazoInicio()));
            ps.setDate(3, Date.valueOf(meta.getPrazoFim()));
            ps.setString(4, meta.getNomeMeta());
            ps.setDouble(5, meta.getValorAlvo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MetaModel> getAll() {
        List<MetaModel> listMeta = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_INVESTIMENTO";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                MetaModel meta = new MetaModel();

                meta.setIdMeta(resultSet.getInt("ID_META"));
                meta.setIdInvestimento(resultSet.getInt("ID_INVESTIMENTO"));
                meta.setPrazoInicio(resultSet.getDate("DT_PRAZO_INICIO").toLocalDate());
                meta.setPrazoFim(resultSet.getDate("DT_PRAZO_FIM").toLocalDate());
                meta.setNomeMeta(resultSet.getString("NM_META"));
                meta.setValorAlvo(resultSet.getDouble("VL_META"));

                listMeta.add(meta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listMeta;
    }
}
