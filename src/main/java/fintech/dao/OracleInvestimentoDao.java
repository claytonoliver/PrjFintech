package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.Factory.ConnectionFactory;
import fintech.bean.InvestimentoModel;
import fintech.interfaces.IInvestimento;

public class OracleInvestimentoDao implements IInvestimento {

    private Connection conexao;

    public OracleInvestimentoDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public OracleInvestimentoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void createInvestimento(InvestimentoModel investimento, int idConta) {
        String query = "INSERT INTO T_FNT_INVESTIMENTO " +
                       "(ID_INVESTIMENTO, ID_CONTA, NM_INVESTIMENTO, NM_TIPO, VL_VALOR, DT_COMPRA, DS_DESCRICAO) " +
                       "VALUES (idinvestimento.nextval, " +
                       "(SELECT id_conta FROM T_FNT_CONTA WHERE id_conta = ?), ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, idConta);
            ps.setString(2, investimento.getNomeInvestimento());
            ps.setString(3, investimento.getTipoInvestimento());
            ps.setDouble(4, investimento.getValorInvestimento());
            ps.setDate(5, Date.valueOf(investimento.getDataCompra()));
            ps.setString(6, investimento.getDescricao());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InvestimentoModel> getAllInvestimento() {
        List<InvestimentoModel> listInvestimento = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_INVESTIMENTO";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listInvestimento;
    }
}
