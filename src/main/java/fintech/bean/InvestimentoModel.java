package fintech.bean;

import java.time.LocalDate;

public class InvestimentoModel {
	
	private int idInvestimento;
	private int idConta;
	private String nomeInvestimento;
	private String tipoInvestimento;
	private double valorInvestimento;
	private LocalDate dataCompra;
	private String descricao;
	private MetaModel metaModel;
	
	public InvestimentoModel() {
		
	}

	public InvestimentoModel(int idInvestimento, int idConta, String nomeInvestimento, String tipoInvestimento,
		double valorInvestimento, LocalDate dataCompra, String descricao, MetaModel metaModel) {
		super();
		this.idInvestimento = idInvestimento;
		this.idConta = idConta;
		this.nomeInvestimento = nomeInvestimento;
		this.tipoInvestimento = tipoInvestimento;
		this.valorInvestimento = valorInvestimento;
		this.dataCompra = dataCompra;
		this.descricao = descricao;
		this.metaModel = metaModel;
	}

	public int getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public String getNomeInvestimento() {
		return nomeInvestimento;
	}

	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}

	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public MetaModel getMetaModel() {
		return metaModel;
	}

	public void setMetaModel(MetaModel metaModel) {
		this.metaModel = metaModel;
	}
	
}
