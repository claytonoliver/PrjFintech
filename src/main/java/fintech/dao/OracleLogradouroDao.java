package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.Factory.ConnectionFactory;
import fintech.bean.LogradouroModel;
import fintech.interfaces.ILogradouro;

public class OracleLogradouroDao implements ILogradouro {

    private Connection conexao;

    public OracleLogradouroDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public OracleLogradouroDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void createLogradouro(LogradouroModel logradouro) {
        String query = "INSERT INTO T_FNT_LOGRADOURO (ID_LOGRADOURO, NM_RUA, NM_NUMERO, NM_CEP) VALUES (idlogradouro.nextval, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setString(1, logradouro.getNome());
            ps.setLong(2, logradouro.getNumero());
            ps.setLong(3, logradouro.getCep());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LogradouroModel> getAllLogradouro() {
        List<LogradouroModel> listLogradouro = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_LOGRADOURO";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                LogradouroModel logradouro = new LogradouroModel();
                logradouro.setId(resultSet.getInt("ID_LOGRADOURO"));
                logradouro.setNome(resultSet.getString("NM_RUA"));
                logradouro.setNumero(resultSet.getLong("NM_NUMERO"));
                logradouro.setCep(resultSet.getLong("NM_CEP"));

                listLogradouro.add(logradouro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listLogradouro;
    }
}
