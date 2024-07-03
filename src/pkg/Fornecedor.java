package pkg;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
	private static int count = 0;
	private int id;
	private String nome;
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Fornecedor.count = count;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	private String desc;
	private String telefone;
	private String email;	
	private Endereco endereco;
	private List<Produto> produtos;
	
	public Fornecedor() {} /* necessario para o Jackson (Json) funcionar */
	
	public Fornecedor(String nome, String desc, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.desc = desc;
		this.telefone = telefone;
		this.email = email;
		this.id = ++count;
		this.endereco = endereco;
		this.produtos = new ArrayList<>();
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
	
	public int quantosProdutos() {
		return this.produtos.size();
	}
	
	public void imprimeProdutos() {
		for (int i=0; i<this.produtos.size(); i++) {
			int id = this.produtos.get(i).getId();
			String nome = this.produtos.get(i).getNome();
			String desc = this.produtos.get(i).getDesc();
			float estoque = this.produtos.get(i).getEstoque();
			System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque);
		}
	}
	
	public void adicionaProduto(Produto p) {
		this.produtos.add(p);
	}
	
	public void editaProduto(Produto p) {
		//acha id e substitui com o produto editado
		for (int i=0; i<produtos.size(); i++) {
			if (this.produtos.get(i).getId() == p.getId()) {
				this.produtos.set(i, p);
				return;
			}
		}
	}
	
	public void removeProduto(Produto p) {
		this.produtos.remove(p);
	}
}
