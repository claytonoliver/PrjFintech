package fintech.bean;

public class CategoriaModel {
 private int idCategoria;
 private String nomeCategoria;
 private String tipoCategoria;
 
public CategoriaModel() {
	
}

public CategoriaModel(int idCategoria, String nomeCategoria, String tipoCategoria) {
	super();
	this.idCategoria = idCategoria;
	this.nomeCategoria = nomeCategoria;
	this.tipoCategoria = tipoCategoria;
}

public int getIdCategoria() {
	return idCategoria;
}

public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
}

public String getNomeCategoria() {
	return nomeCategoria;
}

public void setNomeCategoria(String nomeCategoria) {
	this.nomeCategoria = nomeCategoria;
}

public String getTipoCategoria() {
	return tipoCategoria;
}

public void setTipoCategoria(String tipoCategoria) {
	this.tipoCategoria = tipoCategoria;
}


}
