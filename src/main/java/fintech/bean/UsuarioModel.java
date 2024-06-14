package fintech.bean;

import java.time.LocalDate;

public class UsuarioModel {

	private int idUsuario;
	private long cpf;
	private String nome;
	private long telefone;
	private String email;
	private LocalDate nascimento;
	private EnderecoModel endereco;
	private String senha;
	private UsuarioAutenticaModel usuarioAutentica;
	
	public UsuarioModel() {
		
		
	}

	public UsuarioModel(int idUsuario, long cpf, String nome, long telefone, String email, LocalDate nascimento,
			EnderecoModel endereco, String senha, UsuarioAutenticaModel usuarioAutentica) {
		super();
		this.idUsuario = idUsuario;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.senha = senha;
		this.usuarioAutentica = usuarioAutentica;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getSenha() {
		return senha	;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	public EnderecoModel getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}

	public UsuarioAutenticaModel getUsuarioAutentica() {
		return usuarioAutentica;
	}

	public void setUsuarioAutentica(UsuarioAutenticaModel usuarioAutentica) {
		this.usuarioAutentica = usuarioAutentica;
	}

}
