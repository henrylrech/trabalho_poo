package pkg;

public class Fornecedor {
	String nome;
	String desc;
	String telefone;
	String email;
	
	private Fornecedor() {
	}
	
	public Fornecedor(String nome, String desc, String telefone, String email) {
		this();
		this.nome = nome;
		this.desc = desc;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
