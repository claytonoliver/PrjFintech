package fintech.bean;

public class EnderecoModel {
	private int id_endereco;
	private int id_usuario;
	private int id_logradouro;
	private String nomeCidade;
	private String nomeEstado;
	private String complemento;
	private LogradouroModel logradouro;
	
	public EnderecoModel() {

	}

	public EnderecoModel(int id_endereco, int id_usuario, int id_logradouro, String nomeCidade, String nomeEstado,
			String complemento, LogradouroModel logradouro) {
		super();
		this.id_endereco = id_endereco;
		this.id_usuario = id_usuario;
		this.id_logradouro = id_logradouro;
		this.nomeCidade = nomeCidade;
		this.nomeEstado = nomeEstado;
		this.complemento = complemento;
		this.logradouro = logradouro;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_logradouro() {
		return id_logradouro;
	}

	public void setId_logradouro(int id_logradouro) {
		this.id_logradouro = id_logradouro;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public LogradouroModel getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(LogradouroModel logradouro) {
		this.logradouro = logradouro;
	}
	
	
}
