package pkg;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Loja {
	private List<Fornecedor> fornecedores;
	private List<Produto> produtos;
	private List<Cliente> clientes;
    private List<Pedido> pedidos;
    private String usuarioAtivo;
	
	public Loja() {
		this.fornecedores = new ArrayList<>();
		this.produtos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.pedidos = new ArrayList<>();
		this.CarregarDados();
	}

	//
	// FORNECEDORES
	//
	
	public void IncluiFornecedor(Fornecedor f) {
		this.fornecedores.add(f);
		System.out.println("--> Fornecedor " + f.getNome() + " incluido!");
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void EditarFornecedor(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'F');

		switch (campo){
			case "nome":
				this.fornecedores.get(indice).setNome(novo_campo);
				System.out.println("--> Nome atualizado!");
				return;
			case "desc":
				this.fornecedores.get(indice).setDesc(novo_campo);
				System.out.println("--> Descrição atualizada!");
				return;
			case "telefone":
				this.fornecedores.get(indice).setTelefone(novo_campo);
				System.out.println("--> Telefone atualizado!");
				return;
			case "email":
				this.fornecedores.get(indice).setEmail(novo_campo);
				System.out.println("--> Email atualizado!");
				return;
			case "rua":
				this.fornecedores.get(indice).setRua(novo_campo);
				System.out.println("--> Rua atualizada!");
				return;
			case "bairro":
				this.fornecedores.get(indice).setBairro(novo_campo);
				System.out.println("--> Bairro atualizado!");
				return;
			case "cep":
				this.fornecedores.get(indice).setCep(novo_campo);
				System.out.println("--> CEP atualizado!");
				return;
			case "cidade":
				this.fornecedores.get(indice).setCidade(novo_campo);
				System.out.println("--> Cidade atualizada!");
				return;
			case "estado":
				this.fornecedores.get(indice).setEstado(novo_campo);
				System.out.println("--> Estado atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	}

	public void EditarFornecedor(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'F');

		switch (campo){
			case "numero":
				this.fornecedores.get(indice).setNumero(novo_campo);
				System.out.println("--> Número atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	}
	
	public void ExcluirFornecedor(int id) {
		int indice = BuscaIndice(id, 'F');
		this.fornecedores.remove(indice);
		System.out.println("--> Fornecedor excluido!");
	}

	public void MostraFornecedores() {
		if (this.fornecedores.isEmpty()) {
			System.out.println("--> Nenhum fornecedor a ser exibido.");
			return;
		}
		for (int i=0; i<this.fornecedores.size(); i++) {
			int id = this.fornecedores.get(i).getId();
			String nome = this.fornecedores.get(i).getNome();
			String desc = this.fornecedores.get(i).getDesc();
			String tel = this.fornecedores.get(i).getTelefone();
			String email = this.fornecedores.get(i).getEmail();
			String endereco = this.fornecedores.get(i).getEndereco().MostrarEnderecoFormatado();
			System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
		}
	}

	public void MostraFornecedores(int id) {
		if (!IdValido(id, 'F')){
			System.out.println("--> Id inválido.");
			return;
		}

		if (this.fornecedores.isEmpty()) {
			System.out.println("--> Nenhum fornecedor a ser exibido.");
			return;
		}

		int indice = BuscaIndice(id, 'F');
		Fornecedor f = this.fornecedores.get(indice);
		String endereco = this.fornecedores.get(indice).getEndereco().MostrarEnderecoFormatado();
		System.out.println("--> Id: " + f.getId() + " - Nome: " + f.getNome() + ", Descricao: " + f.getDesc() + ", Telefone: " + f.getTelefone() + ", Email: " + f.getEmail() + ", Endereço: " + endereco);
	}

	public void MostraFornecedores(String busca) {
		if (this.fornecedores.isEmpty()) {
			System.out.println("--> Nenhum fornecedor a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.fornecedores.size(); i++) {
			String nome = this.fornecedores.get(i).getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				achou = true;
				int id = this.fornecedores.get(i).getId();
				String desc = this.fornecedores.get(i).getDesc();
				String tel = this.fornecedores.get(i).getTelefone();
				String email = this.fornecedores.get(i).getEmail();
				String endereco = this.fornecedores.get(i).getEndereco().MostrarEnderecoFormatado();
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
			}

		}

		if (!achou) {
			System.out.println("--> Nenhum fornecedor encontrado.");
			return;
		}

	}
	
	public void mostraProdutosFornecedor(int id) {
		int indice = BuscaIndice(id, 'F');
		
		this.fornecedores.get(indice).imprimeProdutos();
	}

	@JsonIgnore
	public int getQuantosFornecedores() { return this.fornecedores.size(); }

	//
	// PRODUTOS
	//

	public void EditaEstoqueProduto(int id, float quantidade) {
		if (!IdValido(id, 'P')){
			System.out.println("--> Não foi encontrado produto com ID " + id);
			return;
		}

		int indice = BuscaIndice(id, 'P');

		if (this.produtos.get(indice).getEstoque() + quantidade < 0){
			System.out.println("--> Estoque insuciente. O produto " + this.produtos.get(indice).getId() + " tem estoque igual a " + this.produtos.get(indice).getEstoque());
			return;
		}
		float estoque_antigo = this.produtos.get(indice).getEstoque();
		this.produtos.get(indice).setEstoque(estoque_antigo + quantidade);

		System.out.println("--> Estoque alterado com sucesso. Estoque novo: " + this.produtos.get(indice).getEstoque());
	}

	public void IncluiProduto(String nome, String desc, float estoque, int id_forn, double preco) {
		int indice_fornecedor = BuscaIndice(id_forn, 'F');
		
		Produto p = new Produto(nome, desc, this.fornecedores.get(indice_fornecedor), estoque, preco);
		this.produtos.add(p);
		this.fornecedores.get(indice_fornecedor).adicionaProduto(p);
		
		System.out.println("--> Produto " + p.getNome() + " incluido!");
	}

	public void EditarProduto(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'P');

		if (campo.equals("nome")){
			Produto p = this.produtos.get(indice);
			p.setNome(novo_campo);
			int indice_fornecedor = BuscaIndice(id, 'F');
			this.fornecedores.get(indice_fornecedor).editaProduto(p);
			this.produtos.set(indice, p);
			System.out.println("--> Nome atualizado!");
			return;
		}
		else if (campo.equals("descricao")){
			Produto p = this.produtos.get(indice);
			p.setDesc(novo_campo);
			int indice_fornecedor = BuscaIndice(id, 'F');
			this.fornecedores.get(indice_fornecedor).editaProduto(p);
			this.produtos.set(indice, p);
			System.out.println("--> Descricao atualizada!");
			return;
		}
	}

	public void EditarProduto(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'P');
		int indice_fornecedor = BuscaIndice(novo_campo, 'F');

		if (campo.equals("fornecedor")){
			Produto produto = this.produtos.get(indice);
			Fornecedor fornecedor = this.fornecedores.get(indice_fornecedor);
			produto.setFornecedor(fornecedor);
			fornecedor.editaProduto(produto);
			this.produtos.set(indice, produto);
			System.out.println("--> Id de fornecedor atualizado!");
			return;
		}
	}

	public void ExcluirProduto(int id) {
		int indice = BuscaIndice(id, 'P');
		try {
			int indice_fornecedor = BuscaIndice(this.produtos.get(indice).getIdFornecedor(), 'F');
			this.fornecedores.get(indice_fornecedor).removeProduto(this.produtos.get(indice));
		} catch (Exception e) {
			
		}
		
		this.produtos.remove(indice);
		
		System.out.println("--> Produto excluido!");
	}

	public void MostraProdutos() {
		if (this.produtos.isEmpty()) {
			System.out.println("--> Nenhum produto a ser exibido.");
			return;
		}
		for (int i=0; i<this.produtos.size(); i++) {
			int id = this.produtos.get(i).getId();
			String nome = this.produtos.get(i).getNome();
			String desc = this.produtos.get(i).getDesc();
			float estoque = this.produtos.get(i).getEstoque();
			int id_forn = 0;
			double preco = this.produtos.get(i).getPreco();
			try {
				id_forn = this.produtos.get(i).getIdFornecedor();
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn + " Preço: R$" + preco);
			}
			catch (Exception e)
			{
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: não existe" + " Preço: R$" + preco);
			}
			
			
		}
	}

	public void MostraProdutos(int busca) {
		if (this.produtos.size() == 0) {
			System.out.println("--> Nenhum produto a ser exibido.");
			return;
		}
		for (int i=0; i<this.produtos.size(); i++) {
			int id = this.produtos.get(i).getId();
			if (id == busca){
				String nome = this.produtos.get(i).getNome();
				String desc = this.produtos.get(i).getDesc();
				float estoque = this.produtos.get(i).getEstoque();
				int id_forn = this.produtos.get(i).getIdFornecedor();
				double preco = this.produtos.get(i).getPreco();
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn + " Preço: R$" + preco);
			}
		}
	}

	public void MostraProdutos(String busca) {
		if (this.produtos.size() == 0) {
			System.out.println("--> Nenhum produto a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.produtos.size(); i++) {
			String nome = this.produtos.get(i).getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				int id = this.produtos.get(i).getId();
				String desc = this.produtos.get(i).getDesc();
				float estoque = this.produtos.get(i).getEstoque();
				int id_forn = this.produtos.get(i).getIdFornecedor();
				double preco = this.produtos.get(i).getPreco();
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + ", Estoque: " + estoque + ", Fornecedor: " + id_forn + " Preço: R$" + preco);
			}
		}

		if (!achou) {
			System.out.println("--> Nenhum produto encontrado.");
			return;
		}
	}

	@JsonIgnore
	public int getQuantosProdutos() { return this.produtos.size(); }
	
	//
	// UTILITARIOS
	//
	
	private int BuscaIndice(int id, char tipo){
		if (tipo == 'F') {
			for (int i = 0; i < this.fornecedores.size(); i++) {
				if (this.fornecedores.get(i).getId() == id) {
					return i;
				}
			}
		}
		else if (tipo == 'P') {
			for (int i = 0; i < this.produtos.size(); i++) {
				if (this.produtos.get(i).getId() == id) {
					return i;
				}
			}
		}
		else if (tipo == 'C') {
			for (int i = 0; i < this.clientes.size(); i++) {
				if (this.clientes.get(i).getId() == id) {
					return i;
				}
			}
		}

		return -1;
	}
	
	public boolean IdValido(int id, char tipo) {
		if (tipo == 'F') {
			for(int i=0; i<this.fornecedores.size(); i++) {
				if (this.fornecedores.get(i).getId() == id) {
					return true;
				}
			}
		}
		else if (tipo == 'P') {
			for(int i=0; i<this.produtos.size(); i++) {
				if (this.produtos.get(i).getId() == id) {
					return true;
				}
			}
		}
		else if (tipo == 'C') {
			for(int i=0; i<this.clientes.size(); i++) {
				if (this.clientes.get(i).getId() == id) {
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
		this.clientes.add(c);
		System.out.println("--> Cliente " + c.getNome() + " incluido!");
	}

	public void EditarCliente(int id, String campo, String novo_campo){
		int indice = BuscaIndice(id, 'C');

		switch (campo){
			case "nome":
				this.clientes.get(indice).setNome(novo_campo);
				System.out.println("--> Nome atualizado!");
				return;
			case "telefone":
				this.clientes.get(indice).setTelefone(novo_campo);
				System.out.println("--> Telefone atualizado!");
				return;
			case "email":
				this.clientes.get(indice).setEmail(novo_campo);
				System.out.println("--> Email atualizado!");
				return;
			case "cc":
				this.clientes.get(indice).setCartaoCredito(novo_campo);
				System.out.println("--> Cartão de credito atualizado!");
				return;
			case "rua":
				this.clientes.get(indice).setRua(novo_campo);
				System.out.println("--> Rua atualizada!");
				return;
			case "bairro":
				this.clientes.get(indice).setBairro(novo_campo);
				System.out.println("--> Bairro atualizado!");
				return;
			case "cep":
				this.clientes.get(indice).setCep(novo_campo);
				System.out.println("--> CEP atualizado!");
				return;
			case "cidade":
				this.clientes.get(indice).setCidade(novo_campo);
				System.out.println("--> Cidade atualizada!");
				return;
			case "estado":
				this.clientes.get(indice).setEstado(novo_campo);
				System.out.println("--> Estado atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	} 

	public void EditarCliente(int id, String campo, int novo_campo){
		int indice = BuscaIndice(id, 'C');

		switch (campo){
			case "numero":
				this.clientes.get(indice).setNumero(novo_campo);
				System.out.println("--> Número atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	}
	
	public void ExcluirCliente(int id) {
		int indice = BuscaIndice(id, 'C');
		this.clientes.remove(indice);
		System.out.println("--> Cliente excluido!");
	} 
	
	public void MostraClientes() {
		if (this.fornecedores.size() == 0) {
			System.out.println("--> Nenhum clientes a ser exibido.");
			return;
		}
		for (int i=0; i<this.clientes.size(); i++) {
			int id = this.clientes.get(i).getId();
			String nome = this.clientes.get(i).getNome();
			String tel = this.clientes.get(i).getTelefone();
			String email = this.clientes.get(i).getEmail();
			String cc = this.clientes.get(i).getCartaoCredito();
			String endereco = this.clientes.get(i).getEndereco().MostrarEnderecoFormatado();
			System.out.println("--> Id: " + id + " - Nome: " + nome + ", Cartão de credito: " + cc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
		}
	}
	
	public void MostraClientes(int id) {
		if (!IdValido(id, 'C')){
			System.out.println("--> Id inválido.");
			return;
		}

		if (this.clientes.size() == 0) {
			System.out.println("--> Nenhum Cliente a ser exibido.");
			return;
		}

		int indice = BuscaIndice(id, 'C');
		Cliente c = this.clientes.get(indice);
		String endereco = this.clientes.get(indice).getEndereco().MostrarEnderecoFormatado();
		System.out.println("--> Id: " + c.getId() + " - Nome: " + c.getNome() + ", Cartão de credito: " + c.getCartaoCredito() + ", Telefone: " + c.getTelefone() + ", Email: " + c.getEmail() + ", Endereço: " + endereco);
	}

	public void MostraClientes(String busca) {
		if (this.fornecedores.size() == 0) {
			System.out.println("--> Nenhum clientes a ser exibido.");
			return;
		}

		boolean achou = false;

		for (int i=0; i<this.clientes.size(); i++) {
			String nome = this.clientes.get(i).getNome();
			if (nome.toLowerCase().contains(busca.toLowerCase())){
				achou = true;
				int id = this.clientes.get(i).getId();
				String cc = this.clientes.get(i).getCartaoCredito();
				String tel = this.clientes.get(i).getTelefone();
				String email = this.clientes.get(i).getEmail();
				String endereco = this.clientes.get(i).getEndereco().MostrarEnderecoFormatado();
				System.out.println("--> Id: " + id + " - Nome: " + nome + ", Cartão de credito: " + cc + ", Telefone: " + tel + ", Email: " + email + ", Endereço: " + endereco);
			}

		}

		if (!achou) {
			System.out.println("--> Nenhum clientes encontrado.");
			return;
		}

	}

	@JsonIgnore
	public int getQuantosClientes() { return this.clientes.size(); }
	
	//
	// PEDIDO
	//
	
	public void MostraPedidos() {
		if (this.pedidos.isEmpty()) {
			System.out.println("--> Nenhum pedido a ser exibido.");
            return;
		}
		
		boolean achou = false;
		
		for (int i=0;i < this.pedidos.size(); i++) {
			this.pedidos.get(i).exibirDetalhes();
			achou = true;
		}
		
		if (!achou) {
			System.out.println("--> Nenhum pedido encontrado...");
		}
	}
	
	public void MostraPedidos(Cliente cliente) {
		if (this.pedidos.isEmpty()) {
			System.out.println("--> Nenhum pedido a ser exibido.");
            return;
		}
		boolean achou = false;
		for (int i=0;i < this.pedidos.size(); i++) {
			if (this.pedidos.get(i).getCliente() == cliente) {
				this.pedidos.get(i).exibirDetalhes();
				achou = true;
			}
		}
		
		if (!achou) {
			System.out.println("--> Nenhum pedido encontrado...");
		}
	}
	
	public void MostraPedidos(int numero) {
		if (this.pedidos.isEmpty()) {
			System.out.println("--> Nenhum pedido a ser exibido.");
            return;
		}
		for (int i=0;i < this.pedidos.size(); i++) {
			if (this.pedidos.get(i).getNumero() == numero) {
				this.pedidos.get(i).exibirDetalhes();
				return;
			}
		}
		
		System.out.println("--> Nenhum pedido encontrado...");
	}
	
	public void ExcluiPedido(int numero) {
		for (int i=0;i < this.pedidos.size(); i++) {
			if (this.pedidos.get(i).getNumero() == numero) {
				this.pedidos.remove(i);
				System.out.println("--> Pedido " + numero + " deletado!");
				return;
			}
		}
	}
	
	public void FinalizaPedido(int numero) {
		for (int i=0;i < this.pedidos.size(); i++) {
			if (this.pedidos.get(i).getNumero() == numero) {
				this.pedidos.get(i).setDataEntrega(Calendar.getInstance());
				this.pedidos.get(i).setSituacao("Pedido entregue e finalizado.");
				System.out.println("--> Pedido " + numero + " finalizado!");
				return;
			}
		}
	}
	
	public void EditaDataEntregaPedido(int numero, Calendar dataNova) {
		for (int i=0;i < this.pedidos.size(); i++) {
			if (this.pedidos.get(i).getNumero() == numero) {
				this.pedidos.get(i).setDataEntrega(dataNova);
				System.out.println("--> Data de entrega do pedido " + numero + " alterada!");
			}
		}
	}
	
	public void MostraProdutosPedido() {
        if (this.produtos.isEmpty()) {
            System.out.println("--> Nenhum produto a ser exibido.");
            return;
        }
        for (int i = 0; i < this.produtos.size(); i++) {
            int id = this.produtos.get(i).getId();
            String nome = this.produtos.get(i).getNome();
            String desc = this.produtos.get(i).getDesc();
            double preco = this.produtos.get(i).getPreco();
            System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + " Preço: R$" + preco);
        }
    }

    public void MostraProdutosPedido(int busca) {
        if (this.produtos.size() == 0) {
            System.out.println("--> Nenhum produto a ser exibido.");
            return;
        }
        for (int i = 0; i < this.produtos.size(); i++) {
            int id = this.produtos.get(i).getId();
            if (id == busca) {
                String nome = this.produtos.get(i).getNome();
                String desc = this.produtos.get(i).getDesc();
                double preco = this.produtos.get(i).getPreco();
                System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + " Preço: R$" + preco);
            }
        }
    }

    public void MostraProdutosPedido(String busca) {
        if (this.produtos.size() == 0) {
            System.out.println("--> Nenhum produto a ser exibido.");
            return;
        }

        boolean achou = false;

        for (int i = 0; i < this.produtos.size(); i++) {
            String nome = this.produtos.get(i).getNome();
            if (nome.toLowerCase().contains(busca.toLowerCase())) {
                int id = this.produtos.get(i).getId();
                String desc = this.produtos.get(i).getDesc();
                double preco = this.produtos.get(i).getPreco();
                System.out.println("--> Id: " + id + " - Nome: " + nome + ", Descricao: " + desc + " Preço: R$" + preco);
                achou = true;
            }
        }

        if (!achou) {
            System.out.println("--> Nenhum produto encontrado.");
        }
    }

    public Produto buscarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().contains(nome)) {
                return produto;
            }
        }
        return null;
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().contains(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean NomeLogin(String busca, String senha) {
        if (this.clientes.size() == 0) {
            System.out.println("--> Nenhum Conta a ser exibida.");
            return false;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(busca)) {
                if (cliente.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Pedido criarPedido(Cliente cliente) {
        int numero = pedidos.size() + 1;
        Calendar dataPedido = Calendar.getInstance();
        Calendar dataEntrega = Calendar.getInstance(); // Ajustar data de entrega conforme necessidade
        dataEntrega.add(Calendar.DAY_OF_MONTH, 7); // Exemplo: 7 dias de entrega
        Pedido pedido = new Pedido(numero, dataPedido, dataEntrega, "Em processamento");
        pedido.setCliente(cliente);

        for (ItemPedido item : cliente.getCarrinho()) {
            pedido.adicionarItem(item);
        }

        pedidos.add(pedido);
        System.out.println("--> Pedido feito com sucesso. Número do pedido: " + numero);
        return pedido;
    }
    
    public List<Pedido> buscarPedidosPorCliente(Cliente cliente) {
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().equals(cliente)) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }
    public Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> buscarPedidosPorIntervalo(Calendar dataInicio, Calendar dataFim) {
        List<Pedido> pedidosIntervalo = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getDataPedido().after(dataInicio) && pedido.getDataPedido().before(dataFim)) {
                pedidosIntervalo.add(pedido);
            }
        }
        return pedidosIntervalo;
    }

    
	public void EditarComprador(String campo, String novo_campo){
		int indice = BuscaIndiceNome(usuarioAtivo);

		switch (campo){
			case "nome":
				this.clientes.get(indice).setNome(novo_campo);
				System.out.println("--> Nome atualizado!");
				return;
			case "telefone":
				this.clientes.get(indice).setTelefone(novo_campo);
				System.out.println("--> Telefone atualizado!");
				return;
			case "email":
				this.clientes.get(indice).setEmail(novo_campo);
				System.out.println("--> Email atualizado!");
				return;
			case "cc":
				this.clientes.get(indice).setCartaoCredito(novo_campo);
				System.out.println("--> Cartão de credito atualizado!");
				return;
			case "rua":
				this.clientes.get(indice).setRua(novo_campo);
				System.out.println("--> Rua atualizada!");
				return;
			case "bairro":
				this.clientes.get(indice).setBairro(novo_campo);
				System.out.println("--> Bairro atualizado!");
				return;
			case "cep":
				this.clientes.get(indice).setCep(novo_campo);
				System.out.println("--> CEP atualizado!");
				return;
			case "cidade":
				this.clientes.get(indice).setCidade(novo_campo);
				System.out.println("--> Cidade atualizada!");
				return;
			case "estado":
				this.clientes.get(indice).setEstado(novo_campo);
				System.out.println("--> Estado atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	} 

	public void EditarComprador(String campo, int novo_campo){
		int indice = BuscaIndiceNome(usuarioAtivo);

		switch (campo){
			case "numero":
				this.clientes.get(indice).setNumero(novo_campo);
				System.out.println("--> Número atualizado!");
				return;
			default:
				System.out.println("--> Campo inválido, erro ao atualizar.");
		}
	}
	
	private int BuscaIndiceNome(String nome){
			for (int i = 0; i < this.fornecedores.size(); i++) {
				if (this.fornecedores.get(i).getNome().equals(nome)) {
					return i;
				}
			}
			return 0;
	}			
    
    public String getUsuarioAtivo() {
        return usuarioAtivo;
    }

    public void setUsuarioAtivo(String usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }
    
    public void SalvarDados() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("fornecedores.json"), this.fornecedores);
        objectMapper.writeValue(new File("produtos.json"), this.produtos);
        objectMapper.writeValue(new File("clientes.json"), this.clientes);
        objectMapper.writeValue(new File("pedidos.json"), this.pedidos);
        System.out.println("Dados salvos no Json!");
    }

    public void CarregarDados() {
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		List<Fornecedor> fornecedores = objectMapper.readValue(new File("fornecedores.json"),
                    new TypeReference<List<Fornecedor>>() {});
            this.fornecedores.addAll(fornecedores);
            
            List<Produto> produtos = objectMapper.readValue(new File("produtos.json"),
                    new TypeReference<List<Produto>>() {});
            this.produtos.addAll(produtos);
            
            List<Cliente> clientes = objectMapper.readValue(new File("clientes.json"),
                    new TypeReference<List<Cliente>>() {});
            this.clientes.addAll(clientes);
            
            List<Pedido> pedidos = objectMapper.readValue(new File("pedidos.json"),
                    new TypeReference<List<Pedido>>() {});
            this.pedidos.addAll(pedidos);
            
            if (!this.fornecedores.isEmpty()) {
                for (int i = 0; i < this.fornecedores.size(); i++) {
                    Fornecedor fornecedor = this.fornecedores.get(i);
                    if (fornecedor != null && fornecedor.getProdutos() != null) {
                        for (int j = 0; j < fornecedor.getProdutos().size(); j++) {
                            Produto produto = fornecedor.getProdutos().get(j);
                            if (produto != null) {
                                produto.setFornecedor(fornecedor);
                            }
                        }
                    }
                }
            }
            if (!this.clientes.isEmpty())
            for (int i = 0; i < this.clientes.size(); i++) {
                Cliente cliente = this.clientes.get(i);
                if (cliente != null && cliente.getPedidos() != null) {
                    for (int j = 0; j < cliente.getPedidos().size(); j++) {
                        Pedido pedido = cliente.getPedidos().get(j);
                        if (pedido != null) {
                            pedido.setCliente(cliente);
                        }
                    }
                }
            }

            System.out.println("Dados importados do Json!");
    	}
    	catch (IOException e){
    		e.printStackTrace();
    	}
        
    }
}