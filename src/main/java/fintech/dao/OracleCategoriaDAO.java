package fintech.dao;

import fintech.Factory.ConnectionFactory;
<<<<<<< Updated upstream
import fintech.interfaces.ICategoria;
import fintech.bean.CategoriaModel;
=======
import fintech.bean.CategoriaModel;
import fintech.interfaces.ICategoria;
>>>>>>> Stashed changes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleCategoriaDao implements ICategoria {

    private Connection conexao;

    public OracleCategoriaDao(Connection conexao) {
        this.conexao = conexao;
    }

    public OracleCategoriaDao() {
        this.conexao = ConnectionFactory.getConnection();
    }


    @Override
    public void save(CategoriaModel categoria) {
        String sql = "INSERT INTO categorias (id, nome, descricao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getNomeCategoria());
            ps.setString(3, categoria.getTipoCategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<CategoriaModel> getAllCategoria() {
        List<CategoriaModel> listCategoria = new ArrayList<>();
        String query = "SELECT * FROM T_FNT_CATEGORIA";
        
        try (PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
             
            while (resultSet.next()) {
                CategoriaModel categoria = new CategoriaModel();
                categoria.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
                categoria.setNomeCategoria(resultSet.getString("NR_NOME"));
                categoria.setTipoCategoria(resultSet.getString("NM_TIPO"));
                listCategoria.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listCategoria;
    }

    @Override
    public CategoriaModel findById(int id) {
        String query = "SELECT * FROM T_FNT_CATEGORIA WHERE ID_CATEGORIA = ?";
        try (PreparedStatement ps = conexao.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    CategoriaModel categoria = new CategoriaModel();
                    categoria.setIdCategoria(resultSet.getInt("ID_CATEGORIA"));
                    categoria.setNomeCategoria(resultSet.getString("NR_NOME"));
                    categoria.setTipoCategoria(resultSet.getString("NM_TIPO"));
                    return categoria;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}