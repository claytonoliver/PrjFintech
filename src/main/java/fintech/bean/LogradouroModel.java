package fintech.bean;

public class LogradouroModel {

	private int idLogradouro;
	private String nomeRua;
	private long numero;
	private long cep;
	
	
	public LogradouroModel() {

	}


	public LogradouroModel(int id, String nome, long numero, long cep) {
		super();
		this.idLogradouro = id;
		this.nomeRua = nome;
		this.numero = numero;
		this.cep = cep;
	}


	public int getId() {
		return idLogradouro;
	}


	public void setId(int id) {
		this.idLogradouro = id;
	}


	public String getNome() {
		return nomeRua;
	}


	public void setNome(String nome) {
		this.nomeRua = nome;
	}


	public long getNumero() {
		return numero;
	}


	public void setNumero(long numero) {
		this.numero = numero;
	}


	public long getCep() {
		return cep;
	}


	public void setCep(long cep) {
		this.cep = cep;
	}

	
}
