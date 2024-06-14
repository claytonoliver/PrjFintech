package fintech.bean;

import java.time.LocalDate;

public class UsuarioAutenticaModel {
	
	private int idAutentica;
	private int idUsuario;
	private LocalDate ultimoAcesso;
	private String login;
	private char falhaAutentica;
	private String senha;
	
	public UsuarioAutenticaModel() {

	}

	public UsuarioAutenticaModel(int idAutentica, int idUsuario, LocalDate ultimoAcesso, String login,
			char falhaAutentica, String senha) {
		super();
		this.idAutentica = idAutentica;
		this.idUsuario = idUsuario;
		this.ultimoAcesso = ultimoAcesso;
		this.login = login;
		this.falhaAutentica = falhaAutentica;
		this.senha = senha;
	}

	public int getIdAutentica() {
		return idAutentica;
	}

	public void setIdAutentica(int idAutentica) {
		this.idAutentica = idAutentica;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public LocalDate getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(LocalDate ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char getFalhaAutentica() {
		return falhaAutentica;
	}

	public void setFalhaAutentica(char falhaAutentica) {
		this.falhaAutentica = falhaAutentica;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
