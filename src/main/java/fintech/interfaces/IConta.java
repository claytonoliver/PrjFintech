package fintech.interfaces;

import java.util.List;
import fintech.bean.ContaModel;

public interface IConta {
    void createConta(ContaModel conta, long cpf);
    List<ContaModel> getAllContas();
    ContaModel getContaById(int idConta);
}
