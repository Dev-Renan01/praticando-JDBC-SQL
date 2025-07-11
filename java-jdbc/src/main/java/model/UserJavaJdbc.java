package model;

public class UserJavaJdbc {//Clase que representa o modelo (Representa id, nome, email)
	
	
	private Long id;
	private String nome;
	private String email;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserJavaJdbc [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

}
