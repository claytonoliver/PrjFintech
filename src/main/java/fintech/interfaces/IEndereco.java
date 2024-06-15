package fintech.interfaces;

import java.util.List;
import fintech.bean.EnderecoModel;

public interface IEndereco {
    void createEndereco(EnderecoModel endereco, int idUsuario, int idLogradouro);
    List<EnderecoModel> getAllEnderecos();
}
