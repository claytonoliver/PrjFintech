package fintech.interfaces;

import fintech.bean.CategoriaModel;
import java.util.List;

public interface ICategoria {
    void save(CategoriaModel categoria);
    List<CategoriaModel> getAllCategoria();
    CategoriaModel findById(int id);
}