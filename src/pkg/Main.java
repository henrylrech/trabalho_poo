package pkg;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc;
	private Loja loja = new Loja();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.Inicia();
		main.MostraMenu();
	}

	public void Inicia() {
		loja.IncluiFornecedor(new Fornecedor("Henry","Fornecedor","99999999","email@email.com"));
		loja.IncluiProduto(new Produto("Café", "Café Preto", 100, 1));
	}

	public void MostraMenu() {
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Menu Fornecedor");
			System.out.println(" 2 - Menu Produtos");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					MostraMenuFornecedor();
					break;
				case 2:
					MostraMenuProdutos();
					break;
				case 0:
					System.out.println("Saindo...");
					System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 0);
		sc.close();
	}

	public void MostraMenuFornecedor(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um fornecedor");
			System.out.println(" 2 - Editar fornecedor");
			System.out.println(" 3 - Excluir fornecedor");
			System.out.println(" 4 - Consultar fornecedores");
			System.out.println(" 5 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					CriaFornecedor();
					break;
				case 2:
					EditaFornecedor();
					break;
				case 3:
					ExcluiFornecedor();
					break;
				case 4:
					ConsultaFornecedores();
					break;
				case 5:
					MostraMenu();
					break;
				case 0:
					System.out.println("Saindo...");
					System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 5 && opcao != 0);
		sc.close();
	}

	public void MostraMenuProdutos(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um produto");
			System.out.println(" 2 - Editar produto");
			System.out.println(" 3 - Excluir produto");
			System.out.println(" 4 - Consultar produtos");
			System.out.println(" 5 - Alterar estoque de produto");
			System.out.println(" 6 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					CriaProduto();
					break;
				case 2:
					EditaProduto();
					break;
				case 3:
					ExcluiProduto();
					break;
				case 4:
					ConsultaProdutos();
					break;
				case 5:
					EditaEstoque();
					break;
				case 6:
					MostraMenu();
					break;
				case 0:
					System.out.println("Saindo...");
					System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 6 && opcao != 0);
		sc.close();
	}

	private void CriaFornecedor() {
		System.out.println("Diga o nome do fornecedor: ");
		String nome = sc.nextLine();
		System.out.println("Diga uma descrição sobre o fornecedor: ");
		String desc = sc.nextLine();
		System.out.println("Diga o telefone do fornecedor: ");
		String tele = sc.nextLine();
		System.out.println("Diga o email do fornecedor: ");
		String email = sc.nextLine();
		
		Fornecedor f = new Fornecedor(nome,desc,tele,email);
		loja.IncluiFornecedor(f);
		sc.nextLine();
	}

	private void EditaFornecedor() {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			sc.nextLine();
			return;
		}
		
		loja.MostraFornecedores();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja editar o fornecedor com qual id?");
		int id = sc.nextInt();
		
		if (id < 0 || id > loja.getQuantosFornecedores()) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar telefone");
		System.out.println("4 - Editar email");
		int opcao = sc.nextInt();
		sc.nextLine();

		if (opcao < 1 || opcao > 4) {
			System.out.println("Opção inválida.");
			sc.nextLine();
			return;
		}

		Fornecedor temp = loja.getFornecedor(id);
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome novo: ");
			String nome = sc.nextLine();
			if (nome.isEmpty()) { nome = sc.nextLine(); }
			temp.setNome(nome);
			System.out.println("Nome atualizado!");
			break;
		case 2:
			System.out.println("Digite a descricao nova: ");
			String desc = sc.nextLine();
			while (desc.isEmpty()) { desc = sc.nextLine(); }
			temp.setDesc(desc);
			System.out.println("Descricao atualizada!");
			break;
		case 3:
			System.out.println("Digite o telefone novo: ");
			String tele = sc.nextLine();
			while (tele.isEmpty()) { tele = sc.nextLine(); }
			temp.setTelefone(tele);
			System.out.println("Telefone atualizado!");
			break;
		case 4:
			System.out.println("Digite o email novo: ");
			String email = sc.nextLine();
			while (email.isEmpty()) { email = sc.nextLine(); }
			temp.setEmail(email);
			System.out.println("Email atualizado!");
			break;
		}

		loja.setFornecedor(id, temp);

		sc.nextLine();
	}

	private void ExcluiFornecedor() {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			sc.nextLine();
			return;
		}
		
		loja.MostraFornecedores();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja excluir o fornecedor com qual id?");
		int id = sc.nextInt();
		
		if (id < 0 || id > loja.getQuantosFornecedores()) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}
		
		loja.ExcluirFornecedor(id);
		sc.nextLine();
	}

	private void ConsultaFornecedores() {
		System.out.println("---------------------------------------------");
		System.out.println("Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por nome");
		System.out.println("3 - Filtrar por id");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch (opcao) {
			case 1:
				loja.MostraFornecedores();
				break;
			case 2:
				System.out.println("Escolha o nome a ser buscado: ");
				String busca = sc.nextLine();
				loja.MostraFornecedores(busca);
				break;
			case 3:
				System.out.println("Escolha o id a ser buscado: ");
				int id = sc.nextInt();
				loja.MostraFornecedores(id);
				break;
		}

		sc.nextLine();
	}

	private void CriaProduto() {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("É preciso pelo menos um fornecedor para adicionar produto.");
			sc.nextLine();
			return;
		}

		System.out.println("Diga o nome do produto: ");
		String nome = sc.nextLine();
		System.out.println("Diga uma descrição sobre o produto: ");
		String desc = sc.nextLine();
		System.out.println("Diga o estoque inicial do produto: ");
		float estoque = sc.nextFloat();
		loja.MostraFornecedores();
		System.out.println("Diga o indice do fornecedor responsável: ");
		int id_forn = sc.nextInt();

		while (id_forn < 0 || id_forn > loja.getQuantosFornecedores() - 1) {
			System.out.println("Indice de fornecedor inválido. Digite novamente. ");
			id_forn = sc.nextInt();
		}

		Produto p = new Produto(nome, desc, estoque, id_forn);
		loja.IncluiProduto(p);
		sc.nextLine();
	}

	private void EditaProduto(){
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}

		loja.MostraProdutos();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja editar o produto com qual id?");
		int id = sc.nextInt();

		if (id < 0 || id > loja.getQuantosFornecedores()) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}

		System.out.println("Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar fornecedor");
		int opcao = sc.nextInt();
		sc.nextLine();

		if (opcao < 1 || opcao > 4) {
			System.out.println("Opção inválida.");
			sc.nextLine();
			return;
		}

		Produto temp = loja.getProduto(id);

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome novo: ");
				String nome = sc.nextLine();
				if (nome.isEmpty()) { nome = sc.nextLine(); }
				temp.setNome(nome);
				System.out.println("Nome atualizado!");
				break;
			case 2:
				System.out.println("Digite a descricao nova: ");
				String desc = sc.nextLine();
				while (desc.isEmpty()) { desc = sc.nextLine(); }
				temp.setDesc(desc);
				System.out.println("Descricao atualizada!");
				break;
			case 3:
				loja.MostraFornecedores();
				System.out.println("Digite o id de fornecedor novo: ");
				int id_fornecedor = sc.nextInt();
				while (id_fornecedor < 0 || id_fornecedor > loja.getQuantosFornecedores() - 1) {
					System.out.println("Id de fornecedor inválido. Digite novamente. ");
					id_fornecedor = sc.nextInt();
				}
				temp.setId_fornecedor(id_fornecedor);
				System.out.println("Id de fornecedor atualizado!");
				break;
		}

		loja.setProduto(id, temp);

		sc.nextLine();
	}

	private void ExcluiProduto() {
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}

		loja.MostraFornecedores();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja excluir o produto com qual id?");
		int id = sc.nextInt();

		if (id < 0 || id > loja.getQuantosProdutos()) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}

		loja.ExcluirProduto(id);
		sc.nextLine();
	}

	private void ConsultaProdutos() {
		System.out.println("---------------------------------------------");
		System.out.println("Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por nome");
		System.out.println("3 - Filtrar por índice");
		int opcao = sc.nextInt();
		sc.nextLine();

		switch (opcao) {
			case 1:
				loja.MostraProdutos();
				break;
			case 2:
				System.out.println("Escolha o nome a ser buscado: ");
				String busca = sc.nextLine();
				loja.MostraProdutos(busca);
				break;
			case 3:
				System.out.println("Escolha o id a ser buscado: ");
				int id = sc.nextInt();
				loja.MostraProdutos(id);
				break;
		}

		sc.nextLine();
	}

	private void EditaEstoque() {
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}

		loja.MostraProdutos();
		System.out.println("Digite o ID do produto: ");
		int id = sc.nextInt();

		System.out.println("Escolha a opção");
		System.out.println("1 - Adicionar ao estoque");
		System.out.println("2 - Remover do estoque");
		int opcao = sc.nextInt();
		sc.nextLine();

		float quantidade;
		switch (opcao){
			case 1:
				System.out.println("Deseja adicionar quanto ao estoque? ");
				quantidade = sc.nextFloat();
				loja.EditaEstoqueProduto(id, quantidade);
				break;
			case 2:
				System.out.println("Deseja remover quanto do estoque? ");
				quantidade = sc.nextFloat();
				quantidade = quantidade * -1;
				loja.EditaEstoqueProduto(id, quantidade);
				break;
		}
	}
}
