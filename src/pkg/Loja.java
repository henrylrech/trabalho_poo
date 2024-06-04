package pkg;

public class Loja {
	private Fornecedor[] fornecedores;
	private Produto[] produtos;
	private Cliente[] cliente;
	private int quantosFornecedores;
	private int quantosProdutos;
	private int quantosClientes;
	
	public Loja() {
		this.fornecedores = new Fornecedor[100];
		this.produtos = new Produto[100];
		this.cliente = new Cliente[100];
		this.quantosFornecedores = 0;
		this.quantosProdutos = 0;
		this.quantosClientes = 0;
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

		switch (campo){
			case "nome":
				this.fornecedores[indice].setNome(novo_campo);
				System.out.println("Nome atualizado!");
				return;
			case "desc":
				this.fornecedores[indice].setDesc(novo_campo);
				System.out.println("Descrição atualizada!");
				return;
			case "telefone":
				this.fornecedores[indice].setTelefone(novo_campo);
				System.out.println("Telefone atualizado!");
				return;
			case "email":
				this.fornecedores[indice].setEmail(novo_campo);
				System.out.println("Email atualizado!");
				return;
			case "rua":
				this.fornecedores[indice].setRua(novo_campo);
				System.out.println("Rua atualizada!");
				return;
			case "bairro":
				this.fornecedores[indice].setBairro(novo_campo);
				System.out.println("Bairro atualizado!");
				return;
			case "cep":
				this.fornecedores[indice].setCep(novo_campo);
				System.out.println("CEP atualizado!");
				return;
			case "cidade":
				this.fornecedores[indice].setCidade(novo_campo);
				System.out.println("Cidade atualizada!");
				return;
			case "estado":
				this.fornecedores[indice].setEstado(novo_campo);
				System.out.println("Estado atualizado!");
				return;
			default:
				System.out.println("Campo inválido, erro ao atualizar.");
		}
	}

	public void EditarFornecedor(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'F');

		switch (campo){
			case "numero":
				this.fornecedores[indice].setNumero(novo_campo);
				System.out.println("Número atualizado!");
				return;
			default:
				System.out.println("Campo inválido, erro ao atualizar.");
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
			String endereco = this.fornecedores[i].getEndereco().MostrarEnderecoFormatado();
			System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
		}
	}

	public void MostraFornecedores(int id) {
		if (!IdValido(id, 'F')){
			System.out.println("Id inválido.");
			return;
		}

		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}

		int indice = BuscaIndice(id, 'F');
		Fornecedor f = this.fornecedores[indice];
		String endereco = this.fornecedores[indice].getEndereco().MostrarEnderecoFormatado();
		System.out.println("Id: " + f.getId() + " - Nome: " + f.getNome() + ", Descricao: " + f.getDesc() + ", Telefone: " + f.getTelefone() + ", Email: " + f.getEmail() + ", Endereço: " + endereco);
	}

	public void MostraFornecedores(String busca) {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.quantosFornecedores; i++) {
			String nome = this.fornecedores[i].getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				achou = true;
				int id = this.fornecedores[i].getId();
				String desc = this.fornecedores[i].getDesc();
				String tel = this.fornecedores[i].getTelefone();
				String email = this.fornecedores[i].getEmail();
				String endereco = this.fornecedores[i].getEndereco().MostrarEnderecoFormatado();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
			}

		}

		if (!achou) {
			System.out.println("Nenhum fornecedor encontrado.");
			return;
		}

	}

	public int getQuantosFornecedores() { return quantosFornecedores; }

	//
	// PRODUTOS
	//

	public void EditaEstoqueProduto(int id, float quantidade) {
		if (!IdValido(id, 'P')){
			System.out.println("Não foi encontrado produto com ID " + id);
			return;
		}

		int indice = BuscaIndice(id, 'P');

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
			return;
		}
		else if (campo.equals("descricao")){
			this.produtos[indice].setDesc(novo_campo);
			System.out.println("Descricao atualizada!");
			return;
		}
	}

	public void EditarProduto(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'P');

		if (campo.equals("id_fornecedor")){
			this.produtos[indice].setId_fornecedor(novo_campo);
			System.out.println("Id de fornecedor atualizado!");
			return;
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
			int id_forn = this.produtos[i].getIdFornecedor();
			System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn);
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
				int id_forn = this.produtos[i].getIdFornecedor();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn);
			}
		}
	}

	public void MostraProdutos(String busca) {
		if (this.quantosProdutos == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.quantosProdutos; i++) {
			String nome = this.produtos[i].getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				int id = this.produtos[i].getId();
				String desc = this.produtos[i].getDesc();
				float estoque = this.produtos[i].getEstoque();
				int id_forn = this.produtos[i].getIdFornecedor();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn);
			}
		}

		if (!achou) {
			System.out.println("Nenhum produto encontrado.");
			return;
		}
	}

	public int getQuantosProdutos() { return quantosProdutos; }
	
	//
	// UTILITARIOS
	//
	
	private int BuscaIndice(int id, char tipo){
		if (tipo == 'F') {
			for (int i = 0; i < this.quantosFornecedores; i++) {
				if (this.fornecedores[i].getId() == id) {
					return i;
				}
			}
		}
		else if (tipo == 'P') {
			for (int i = 0; i < this.quantosProdutos; i++) {
				if (this.produtos[i].getId() == id) {
					return i;
				}
			}
		}
		else if (tipo == 'C') {
			for (int i = 0; i < this.quantosClientes; i++) {
				if (this.cliente[i].getId() == id) {
					return i;
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
		else if (tipo == 'C') {
			for(int i=0; i<this.quantosClientes; i++) {
				if (this.cliente[i].getId() == id) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	//
	// CLIENTE
	//
	
	public void IncluiCliente(Cliente c) {
		this.cliente[this.quantosClientes] = c;
		this.quantosClientes++;
		System.out.println("Cliente " + c.getNome() + " incluido!");
	}

	public void EditarCliente(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'C');

		switch (campo){
			case "nome":
				this.cliente[indice].setNome(novo_campo);
				System.out.println("Nome atualizado!");
				return;
			case "telefone":
				this.cliente[indice].setTelefone(novo_campo);
				System.out.println("Telefone atualizado!");
				return;
			case "email":
				this.cliente[indice].setEmail(novo_campo);
				System.out.println("Email atualizado!");
				return;
			case "cc":
				this.cliente[indice].setCartaoCredito(novo_campo);
				System.out.println("Cartão de credito atualizado!");
				return;
			case "rua":
				this.cliente[indice].setRua(novo_campo);
				System.out.println("Rua atualizada!");
				return;
			case "bairro":
				this.cliente[indice].setBairro(novo_campo);
				System.out.println("Bairro atualizado!");
				return;
			case "cep":
				this.cliente[indice].setCep(novo_campo);
				System.out.println("CEP atualizado!");
				return;
			case "cidade":
				this.cliente[indice].setCidade(novo_campo);
				System.out.println("Cidade atualizada!");
				return;
			case "estado":
				this.cliente[indice].setEstado(novo_campo);
				System.out.println("Estado atualizado!");
				return;
			default:
				System.out.println("Campo inválido, erro ao atualizar.");
		}
	} 

	public void EditarCliente(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'C');

		switch (campo){
			case "numero":
				this.cliente[indice].setNumero(novo_campo);
				System.out.println("Número atualizado!");
				return;
			default:
				System.out.println("Campo inválido, erro ao atualizar.");
		}
	}
	
	public void ExcluirCliente(int id) {
		int indice = BuscaIndice(id, 'C');

		System.out.println("Excluindo Cliente (" + id + ") com nome (" + this.cliente[indice].getNome() + ")");
		Cliente[] novo_array = new Cliente[100];
		for (int i = 0, j = 0; i < this.quantosClientes; i++) {
            if (i != indice) {
                novo_array[j++] = this.cliente[i];
            }
        }
		this.cliente = novo_array;
		this.quantosClientes--;
		System.out.println("Cliente excluido!");
	} 
	
	public void MostraClientes() {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum cliente a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosClientes; i++) {
			int id = this.cliente[i].getId();
			String nome = this.cliente[i].getNome();
			String tel = this.cliente[i].getTelefone();
			String email = this.cliente[i].getEmail();
			String cc = this.cliente[i].getCartaoCredito();
			String endereco = this.cliente[i].getEndereco().MostrarEnderecoFormatado();
			System.out.println("Id: " + id + " - Nome: " + nome + ", Cartão de credito: " + cc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
		}
	}
	
	public void MostraClientes(int id) {
		if (!IdValido(id, 'C')){
			System.out.println("Id inválido.");
			return;
		}

		if (this.quantosClientes == 0) {
			System.out.println("Nenhum Cliente a ser exibido.");
			return;
		}

		int indice = BuscaIndice(id, 'C');
		Cliente c = this.cliente[indice];
		String endereco = this.cliente[indice].getEndereco().MostrarEnderecoFormatado();
		System.out.println("Id: " + c.getId() + " - Nome: " + c.getNome() + ", Cartão de credito: " + c.getCartaoCredito() + ", Telefone: " + c.getTelefone() + ", Email: " + c.getEmail() + ", Endereço: " + endereco);
	}

	public void MostraClientes(String busca) {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum cliente a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.quantosClientes; i++) {
			String nome = this.cliente[i].getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				achou = true;
				int id = this.cliente[i].getId();
				String cc = this.cliente[i].getCartaoCredito();
				String tel = this.cliente[i].getTelefone();
				String email = this.cliente[i].getEmail();
				String endereco = this.cliente[i].getEndereco().MostrarEnderecoFormatado();
				System.out.println("Id: " + id + " - Nome: " + nome + ", Cartão de credito: " + cc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
			}

		}

		if (!achou) {
			System.out.println("Nenhum cliente encontrado.");
			return;
		}

	}

	public int getQuantosClientes() { return quantosClientes; }
	
}
