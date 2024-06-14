package fintech.bean;

import java.time.LocalDate;

public class TransacaoModel {
	
	private int idTransacao;
	private int idConta;
	private int idCategoria;
	private LocalDate dataTransacao;
	private double valorTransacao;
	private String destino;
	private String descricao;
	private CategoriaModel categoriaModel;
	
	public TransacaoModel() {
		
	}

	public TransacaoModel(int idTransacao, int idConta, int idCategoria, LocalDate dataTransacao, double valorTransacao,
			String destino, String descricao, CategoriaModel categoriaModel) {
		super();
		this.idTransacao = idTransacao;
		this.idConta = idConta;
		this.idCategoria = idCategoria;
		this.dataTransacao = dataTransacao;
		this.valorTransacao = valorTransacao;
		this.destino = destino;
		this.descricao = descricao;
		this.categoriaModel = categoriaModel;
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public LocalDate getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaModel getCategoriaModel() {
		return categoriaModel;
	}

	public void setCategoriaModel(CategoriaModel categoriaModel) {
		this.categoriaModel = categoriaModel;
	}
	
}
