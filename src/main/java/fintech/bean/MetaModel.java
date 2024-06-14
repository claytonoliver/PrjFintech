package fintech.bean;

import java.time.LocalDate;

public class MetaModel {
	
private int idMeta;
private int idInvestimento;
private LocalDate prazoInicio;
private LocalDate prazoFim;
private String nomeMeta;
private double valorAlvo;

public MetaModel() {
	
}

public MetaModel(int idMeta, int idInvestimento, LocalDate prazoInicio, LocalDate prazoFim, String nomeMeta,
		double valorAlvo) {
	super();
	this.idMeta = idMeta;
	this.idInvestimento = idInvestimento;
	this.prazoInicio = prazoInicio;
	this.prazoFim = prazoFim;
	this.nomeMeta = nomeMeta;
	this.valorAlvo = valorAlvo;
}

public int getIdMeta() {
	return idMeta;
}

public void setIdMeta(int idMeta) {
	this.idMeta = idMeta;
}

public int getIdInvestimento() {
	return idInvestimento;
}

public void setIdInvestimento(int idInvestimento) {
	this.idInvestimento = idInvestimento;
}

public LocalDate getPrazoInicio() {
	return prazoInicio;
}

public void setPrazoInicio(LocalDate prazoInicio) {
	this.prazoInicio = prazoInicio;
}

public LocalDate getPrazoFim() {
	return prazoFim;
}

public void setPrazoFim(LocalDate prazoFim) {
	this.prazoFim = prazoFim;
}

public String getNomeMeta() {
	return nomeMeta;
}

public void setNomeMeta(String nomeMeta) {
	this.nomeMeta = nomeMeta;
}

public double getValorAlvo() {
	return valorAlvo;
}

public void setValorAlvo(double valorAlvo) {
	this.valorAlvo = valorAlvo;
}

}
