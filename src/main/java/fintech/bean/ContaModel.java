package fintech.bean;

public class ContaModel {
	
private int idConta;
private int idUsuario;
private String tipoConta;
private String moeda;
private double saldoConta;
private InvestimentoModel investimentoModel;
public ContaModel() {
	
}
public ContaModel(int idConta, int idUsuario, String tipoConta, String moeda, double saldoConta,
		InvestimentoModel investimentoModel) {
	super();
	this.idConta = idConta;
	this.idUsuario = idUsuario;
	this.tipoConta = tipoConta;
	this.moeda = moeda;
	this.saldoConta = saldoConta;
	this.investimentoModel = investimentoModel;
}
public int getIdConta() {
	return idConta;
}
public void setIdConta(int idConta) {
	this.idConta = idConta;
}
public int getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}
public String getTipoConta() {
	return tipoConta;
}
public void setTipoConta(String tipoConta) {
	this.tipoConta = tipoConta;
}
public String getMoeda() {
	return moeda;
}
public void setMoeda(String moeda) {
	this.moeda = moeda;
}
public double getSaldoConta() {
	return saldoConta;
}
public void setSaldoConta(double saldoConta) {
	this.saldoConta = saldoConta;
}
public InvestimentoModel getInvestimentoModel() {
	return investimentoModel;
}
public void setInvestimentoModel(InvestimentoModel investimentoModel) {
	this.investimentoModel = investimentoModel;
}

}
