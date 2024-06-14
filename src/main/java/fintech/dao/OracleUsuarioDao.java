package fintech.dao;

import fintech.bean.UsuarioModel;
import fintech.interfaces.IUsuario;
import fintech.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleUsuarioDao implements IUsuario {
    private Connection conexao;

    public OracleUsuarioDao(Connection conexao) {
        this.conexao = conexao;
    }

    public OracleUsuarioDao() {
        this.conexao = ConnectionFactory.getConnection();
    }

    @Override
    public void save(UsuarioModel usuario) {
        String query = "INSERT INTO T_FNT_USUARIO " +
                "(idusuario, cpf, nome, telefone, email, nascimento) " +
                "VALUES (idusuario.nextval, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setLong(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());
            ps.setLong(3, usuario.getTelefone());
            ps.setString(4, usuario.getEmail());
            ps.setDate(5, java.sql.Date.valueOf(usuario.getNascimento()));

            ps.executeUpdate();

            System.out.println("Registro inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UsuarioModel> getAllUsers() {
        List<UsuarioModel> listUsers = new ArrayList<>();

        String query = "SELECT * FROM T_FNT_USUARIO";

        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                UsuarioModel usuario = new UsuarioModel();

                usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
                usuario.setCpf(resultSet.getLong("NR_CPF"));
                usuario.setNome(resultSet.getString("NM_NOME_COMPLETO"));
                usuario.setTelefone(resultSet.getLong("NR_TELEFONE"));
                usuario.setEmail(resultSet.getString("NM_EMAIL"));
                usuario.setNascimento(resultSet.getDate("DT_Nascimento").toLocalDate());

                listUsers.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listUsers;
    }

    @Override
    public UsuarioModel findById(int id) {
        UsuarioModel usuario = null;
        String query = "SELECT * FROM T_FNT_USUARIO WHERE idusuario = ?";
        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new UsuarioModel();
                    usuario.setIdUsuario(resultSet.getInt("ID_USUARIO"));
                    usuario.setCpf(resultSet.getLong("NR_CPF"));
                    usuario.setNome(resultSet.getString("NM_NOME_COMPLETO"));
                    usuario.setTelefone(resultSet.getLong("NR_TELEFONE"));
                    usuario.setEmail(resultSet.getString("NM_EMAIL"));
                    usuario.setNascimento(resultSet.getDate("DT_Nascimento").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public boolean findByEmailAndPassword(String email, String senha) {
        boolean found = false;
        String query = "SELECT COUNT(*) FROM T_FNT_USUARIO WHERE email = ? AND senha = ?";
        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    found = count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }
}
