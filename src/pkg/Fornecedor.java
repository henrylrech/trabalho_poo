package pkg;

public class Fornecedor {
	private static int count = 0;
	private int id;
	private String nome;
	private String desc;
	private String telefone;
	private String email;
	private Endereco endereco;
	
	public Fornecedor(String nome, String desc, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.desc = desc;
		this.telefone = telefone;
		this.email = email;
		this.id = ++count;
		this.endereco = endereco;
	}
	public int getId() { return id; }

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

	public Endereco getEndereco() { return this.endereco; }

	public void setRua(String rua) { this.endereco.setRua(rua); }

	public void setNumero(int numero) { this.endereco.setNumero(numero); }

	public void setBairro(String bairro) { this.endereco.setBairro(bairro); }

	public void setCep(String cep) { this.endereco.setCep(cep); }

	public void setCidade(String cidade) { this.endereco.setCidade(cidade); }

	public void setEstado(String estado) { this.endereco.setEstado(estado); }
}
