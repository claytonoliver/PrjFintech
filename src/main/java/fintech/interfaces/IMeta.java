package fintech.interfaces;

import java.util.List;

import fintech.bean.MetaModel;

public interface IMeta {
	void save(MetaModel meta, int idInvestimento);
	List<MetaModel> getAll();
	
}
