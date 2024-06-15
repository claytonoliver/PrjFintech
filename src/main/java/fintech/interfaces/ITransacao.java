package fintech.interfaces;

import java.util.List;
import fintech.bean.TransacaoModel;

public interface ITransacao {
    void createTransacao(TransacaoModel transacao, int idConta, int idCategoria);
    List<TransacaoModel> getAllTransacao();
}
