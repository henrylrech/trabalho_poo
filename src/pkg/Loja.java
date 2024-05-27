package pkg;

public class Loja {
	private Fornecedor[] fornecedores;
	private Produto[] produtos;
	private int quantosFornecedores;
	private int quantosProdutos;
	
	public Loja() {
		this.fornecedores = new Fornecedor[100];
		this.produtos = new Produto[100];
		this.quantosFornecedores = 0;
		this.quantosProdutos = 0;
	}

	//
	// FORNECEDORES
	//
	
	public void IncluiFornecedor(Fornecedor f) {
		this.fornecedores[this.quantosFornecedores] = f;
		this.quantosFornecedores++;
		System.out.println("Fornecedor " + f.getNome() + " incluido!");
	}
	
	public void ExcluirFornecedor(int indice) {
		System.out.println("Excluindo fornecedor (" + indice + ") com nome (" + this.fornecedores[indice].getNome() + ")");
		Fornecedor[] novo_array = new Fornecedor[100];
		for (int i = 0, j = 0; i < this.quantosFornecedores; i++) {
            if (i != indice) {
                novo_array[j++] = this.fornecedores[i];
            }
        }
		this.fornecedores = novo_array;
		this.quantosFornecedores--;
		System.out.println("Fornecedor excluido!");
	}
	
	public void MostraFornecedores() {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosFornecedores; i++) {
			String nome = this.fornecedores[i].getNome();
			String desc = this.fornecedores[i].getDesc();
			String tel = this.fornecedores[i].getTelefone();
			String email = this.fornecedores[i].getEmail();
			System.out.println(i + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email);
		}
	}

	public void MostraFornecedores(int indice) {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		Fornecedor f = this.fornecedores[indice];
		System.out.println(indice + " - Nome: " + f.getNome() + ", Descricao: " + f.getDesc() + ", Telefone: " + f.getTelefone() + ", Email: " + f.getEmail());
	}

	public void MostraFornecedores(String busca) {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosFornecedores; i++) {
			String nome = this.fornecedores[i].getNome();
			if (nome.contains(busca)){
				String desc = this.fornecedores[i].getDesc();
				String tel = this.fornecedores[i].getTelefone();
				String email = this.fornecedores[i].getEmail();
				System.out.println(i + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email);
			}

		}
	}

	public int getQuantosFornecedores() {
		return quantosFornecedores;
	}

	public Fornecedor getFornecedor(int indice){
		return this.fornecedores[indice];
	}

	public void setFornecedor(int indice, Fornecedor temp){
		this.fornecedores[indice] = temp;
	}

	//
	// PRODUTOS
	//

	public void EditaEstoqueProduto(int id, float quantidade) {
		int indice = 0;
		boolean achou = false;
		for (int i = 0; i < this.quantosProdutos; i++) {
			if (this.produtos[i].getId() == id) {
				indice = i;
				achou = true;
				break;
			}
		}

		if (achou == false){
			System.out.println("Erro. Não foi encontrado produto com ID " + id);
			return;
		}

		if (this.produtos[indice].getEstoque() + quantidade < 0){
			System.out.println("Estoque insuciente. O produto " + this.produtos[indice].getId() + " tem estoque igual a " + this.produtos[indice].getEstoque());
			return;
		}
		float estoque_antigo = this.produtos[indice].getEstoque();
		this.produtos[indice].setEstoque(estoque_antigo + quantidade);

		System.out.println("Estoque alterado com sucesso. Estoque novo: " + this.produtos[indice].getEstoque());
	}

	public void IncluiProduto(Produto p) {
		this.produtos[this.quantosProdutos] = p;
		this.quantosProdutos++;
		System.out.println("Produto " + p.getNome() + " incluido!");
	}

	public void ExcluirProduto(int indice) {
		System.out.println("Excluindo produto (" + indice + ") com nome (" + this.produtos[indice].getNome() + ")");
		Produto[] novo_array = new Produto[100];
		for (int i = 0, j = 0; i < this.quantosProdutos; i++) {
			if (i != indice) {
				novo_array[j++] = this.produtos[i];
			}
		}
		this.produtos = novo_array;
		this.quantosProdutos--;
		System.out.println("Produto excluido!");
	}

	public void MostraProdutos() {
		if (this.quantosProdutos == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosProdutos; i++) {
			int id = this.produtos[i].getId();
			String nome = this.produtos[i].getNome();
			String desc = this.produtos[i].getDesc();
			float estoque = this.produtos[i].getEstoque();
			System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque);
		}
	}

	public void MostraProdutos(int busca) {
		if (this.quantosProdutos == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosProdutos; i++) {
			int id = this.produtos[i].getId();
			if (id == busca){
				String nome = this.produtos[i].getNome();
				String desc = this.produtos[i].getDesc();
				float estoque = this.produtos[i].getEstoque();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque);
			}
		}
	}

	public void MostraProdutos(String busca) {
		if (this.quantosProdutos == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosProdutos; i++) {
			String nome = this.produtos[i].getNome();
			if (nome.contains(busca)){
				int id = this.produtos[i].getId();
				String desc = this.produtos[i].getDesc();
				float estoque = this.produtos[i].getEstoque();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque);
			}
		}
	}

	public int getQuantosProdutos() { return quantosProdutos; }

	public Produto getProduto(int indice) { return this.produtos[indice]; }

	public void setProduto(int indice, Produto temp) { this.produtos[indice] = temp; }
}
