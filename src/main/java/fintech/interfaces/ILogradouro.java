package fintech.interfaces;

import java.util.List;
import fintech.bean.LogradouroModel;

public interface ILogradouro {
    void createLogradouro(LogradouroModel logradouro);
    List<LogradouroModel> getAllLogradouro();
}
