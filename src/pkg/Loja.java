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

	public void EditarFornecedor(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'F');

		if (campo.equals("nome")){
			this.fornecedores[indice].setNome(novo_campo);
			System.out.println("Nome atualizado!");
		}
		else if (campo.equals("desc")){
			this.fornecedores[indice].setDesc(novo_campo);
			System.out.println("Descricao atualizada!");
		}
		else if (campo.equals("telefone")){
			this.fornecedores[indice].setTelefone(novo_campo);
			System.out.println("Telefone atualizado!");
		}
		else if (campo.equals("email")){
			this.fornecedores[indice].setEmail(novo_campo);
			System.out.println("Email atualizado!");
		}
	}
	
	public void ExcluirFornecedor(int id) {
		int indice = BuscaIndice(id, 'F');

		System.out.println("Excluindo fornecedor (" + id + ") com nome (" + this.fornecedores[indice].getNome() + ")");
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
			int id = this.fornecedores[i].getId();
			String nome = this.fornecedores[i].getNome();
			String desc = this.fornecedores[i].getDesc();
			String tel = this.fornecedores[i].getTelefone();
			String email = this.fornecedores[i].getEmail();
			System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email);
		}
	}

	public void MostraFornecedores(int id) {
		int indice = BuscaIndice(id, 'F');

		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		Fornecedor f = this.fornecedores[indice];
		System.out.println("Id: " + f.getId() + " - Nome: " + f.getNome() + ", Descricao: " + f.getDesc() + ", Telefone: " + f.getTelefone() + ", Email: " + f.getEmail());
	}

	public void MostraFornecedores(String busca) {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosFornecedores; i++) {
			String nome = this.fornecedores[i].getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				int id = this.fornecedores[i].getId();
				String desc = this.fornecedores[i].getDesc();
				String tel = this.fornecedores[i].getTelefone();
				String email = this.fornecedores[i].getEmail();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email);
			}

		}
	}

	public int getQuantosFornecedores() {
		return quantosFornecedores;
	}

	//
	// PRODUTOS
	//

	public void EditaEstoqueProduto(int id, float quantidade) {
		int indice = BuscaIndice(id, 'P');

		if (indice == -1){
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

	public void EditarProduto(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'P');

		if (campo.equals("nome")){
			this.produtos[indice].setNome(novo_campo);
			System.out.println("Nome atualizado!");
		}
		else if (campo.equals("descricao")){
			this.produtos[indice].setDesc(novo_campo);
			System.out.println("Descricao atualizada!");
		}
	}

	public void EditarProduto(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'P');

		if (campo.equals("id_fornecedor")){
			this.produtos[indice].setId_fornecedor(novo_campo);
			System.out.println("Id de fornecedor atualizado!");
		}
	}

	public void ExcluirProduto(int id) {
		int indice = BuscaIndice(id, 'P');

		System.out.println("Excluindo produto (" + id + ") com nome (" + this.produtos[indice].getNome() + ")");
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
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				int id = this.produtos[i].getId();
				String desc = this.produtos[i].getDesc();
				float estoque = this.produtos[i].getEstoque();
				int id_fornecedor = this.fornecedores[BuscaIndice(this.produtos[i].getIdFornecedor(), 'F')].getId();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", ID Fornecedor: " + id_fornecedor);
			}
		}
	}

	public int getQuantosProdutos() { return quantosProdutos; }
	
	//
	// UTILITARIOS
	//
	
	private int BuscaIndice(int id, char tipo){
		int indice = 0;
		if (tipo == 'F') {
			for (int i = 0; i < this.quantosFornecedores; i++) {
				if (this.fornecedores[i].getId() == id) {
					return indice;
				}
			}
		}
		else if (tipo == 'P') {
			for (int i = 0; i < this.quantosProdutos; i++) {
				if (this.produtos[i].getId() == id) {
					return indice;
				}
			}
		}

		return -1;
	}
	
	public boolean IdValido(int id, char tipo) {
		
		if (tipo == 'F') {
			for(int i=0; i<this.quantosFornecedores; i++) {
				if (this.fornecedores[i].getId() == id) {
					return true;
				}
			}
		}
		else if (tipo == 'P') {
			for(int i=0; i<this.quantosProdutos; i++) {
				if (this.produtos[i].getId() == id) {
					return true;
				}
			}
		}
		
		return false;
	}
}
