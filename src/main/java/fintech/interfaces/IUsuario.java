package fintech.interfaces;

import fintech.bean.UsuarioModel;

import java.util.List;

public interface IUsuario {
    void save(UsuarioModel usuario);
    List<UsuarioModel> getAllUsers();
    UsuarioModel findById(int id);
    boolean findByEmailAndPassword(String email, String senha);
}