package fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fintech.bean.ContaModel;
import fintech.interfaces.IConta;

public class OracleContaDao implements IConta {

    private Connection conexao;

    public OracleContaDao() {
    }

    public OracleContaDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void createConta(ContaModel conta, long cpf) {
        String query = "INSERT INTO T_FNT_CONTA " 
                     + "values  (idconta.nextval, "
                     + "(select id_usuario from T_FNT_usuario where nr_cpf = ?), "
                     + "?,?,?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setLong(1, cpf);
            ps.setString(2, conta.getTipoConta());
            ps.setString(3, conta.getMoeda());
            ps.setDouble(4, conta.getSaldoConta());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ContaModel> getAllContas() {
        List<ContaModel> listConta = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_CONTA";

        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                ContaModel conta = new ContaModel();
                conta.setIdConta(resultSet.getInt("id_conta"));
                conta.setIdUsuario(resultSet.getInt("id_usuario"));
                conta.setTipoConta(resultSet.getString("nm_tipo"));
                conta.setMoeda(resultSet.getString("nm_moeda"));
                conta.setSaldoConta(resultSet.getDouble("vl_saldo"));
                listConta.add(conta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listConta;
    }

    @Override
    public ContaModel getContaById(int idConta) {
        ContaModel conta = null;

        String query = "SELECT * FROM T_FNT_CONTA WHERE id_conta = ?";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, idConta);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                conta = new ContaModel();
                conta.setIdConta(resultSet.getInt("id_conta"));
                conta.setIdUsuario(resultSet.getInt("id_usuario"));
                conta.setTipoConta(resultSet.getString("nm_tipo"));
                conta.setMoeda(resultSet.getString("nm_moeda"));
                conta.setSaldoConta(resultSet.getDouble("vl_saldo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conta;
    }
}
