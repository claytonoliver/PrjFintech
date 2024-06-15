package fintech.interfaces;

import java.util.List;
import fintech.bean.InvestimentoModel;

public interface IInvestimento {
    void createInvestimento(InvestimentoModel investimento, int idConta);
    List<InvestimentoModel> getAllInvestimento();
}
