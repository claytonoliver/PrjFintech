package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.Factory.ConnectionFactory;
import fintech.bean.EnderecoModel;
import fintech.interfaces.IEndereco;

public class OracleEnderecoDao implements IEndereco {

    private Connection conexao;

    public OracleEnderecoDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public OracleEnderecoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void createEndereco(EnderecoModel endereco, int idUsuario, int idLogradouro) {
        String query = "INSERT INTO T_FNT_ENDERECO " +
                       "(ID_ENDERECO, ID_USUARIO, ID_LOGRADOURO, NM_CIDADE, NM_ESTADO, NM_COMPLEMENTO) " +
                       "VALUES (idconta.nextval, " +
                       "(SELECT id_usuario FROM T_FNT_usuario WHERE id_usuario = ?), " +
                       "(SELECT id_logradouro FROM T_FNT_LOGRADOURO WHERE id = ?), ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ps.setInt(2, idLogradouro);
            ps.setString(3, endereco.getNomeCidade());
            ps.setString(4, endereco.getNomeEstado());
            ps.setString(5, endereco.getComplemento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EnderecoModel> getAllEnderecos() {
        List<EnderecoModel> listEndereco = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_ENDERECO";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEndereco;
    }
}
