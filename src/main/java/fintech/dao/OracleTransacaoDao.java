package fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.Factory.ConnectionFactory;
import fintech.bean.TransacaoModel;

public class OracleTransacaoDao {

    private Connection conexao;

    public OracleTransacaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public OracleTransacaoDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void createTransacao(TransacaoModel transacao, int idConta, int idCategoria) {
        String query = "INSERT INTO T_FNT_TRANSACAO (ID_TRANSACAO, ID_CONTA, ID_CATEGORIA, DT_TRANSACAO, VL_VALOR, NM_DESCRICAO, DS_DESCRICAO) "
                     + "VALUES (idtransacao.nextval, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, idConta);
            ps.setInt(2, idCategoria);
            ps.setDate(3, Date.valueOf(transacao.getDataTransacao()));
            ps.setDouble(4, transacao.getValorTransacao());
            ps.setString(5, transacao.getDestino());
            ps.setString(6, transacao.getDescricao());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TransacaoModel> getAllTransacao() {
        List<TransacaoModel> listTransacao = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_TRANSACAO";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTransacao;
    }
}
