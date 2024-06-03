package pkg;
import java.lang.String;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc;
	private Loja loja = new Loja();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.Inicia();
		main.MostraMenu();
	}

	private void Inicia() {
		Endereco e = new Endereco("Rua 1", 420, "Lagoinha", "12345-678", "Caxias do Sul", "RS");
		loja.IncluiFornecedor(new Fornecedor("Henry","Fornecedor","99999999","email@email.com", e));
		loja.IncluiProduto(new Produto("Café", "Café Preto", 100, 1));
	}

	private void MostraMenu() {
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

	private void MostraMenuFornecedor(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um fornecedor");
			System.out.println(" 2 - Editar fornecedor");
			System.out.println(" 3 - Excluir fornecedor");
			System.out.println(" 4 - Consultar fornecedores");
			System.out.println(" 9 - Voltar");
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
				case 9:
					MostraMenu();
					break;
				case 0:
					System.out.println("Saindo...");
					System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}

	private void MostraMenuProdutos(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um produto");
			System.out.println(" 2 - Editar produto");
			System.out.println(" 3 - Excluir produto");
			System.out.println(" 4 - Consultar produtos");
			System.out.println(" 5 - Alterar estoque de produto");
			System.out.println(" 9 - Voltar");
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
				case 9:
					MostraMenu();
					break;
				case 0:
					System.out.println("Saindo...");
					System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}

	//
	// FORNECEDOR
	//

	private void CriaFornecedor() {
		System.out.println("Diga o nome do fornecedor: ");
		String nome = sc.nextLine();
		System.out.println("Diga uma descrição sobre o fornecedor: ");
		String desc = sc.nextLine();
		System.out.println("Diga o telefone do fornecedor: ");
		String tele = sc.nextLine();
		System.out.println("Diga o email do fornecedor: ");
		String email = sc.nextLine();
		System.out.println("Diga o numero da casa/apartamento do fornecedor: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Diga a rua do fornecedor: ");
		String rua = sc.nextLine();
		System.out.println("Diga o bairro do fornecedor: ");
		String bairro = sc.nextLine();
		System.out.println("Diga o cep do fornecedor: ");
		String cep = sc.nextLine();
		System.out.println("Diga a cidade do fornecedor: ");
		String cidade = sc.nextLine();
		System.out.println("Diga o estado do fornecedor: ");
		String estado = sc.nextLine();
		
		Fornecedor f = new Fornecedor(nome,desc,tele,email,new Endereco(rua, numero, bairro, cep, cidade, estado));
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
		
		if (!loja.IdValido(id, 'F')) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar telefone");
		System.out.println("4 - Editar email");
		System.out.println("5 - Editar endereço");
		System.out.println("6 - Editar TODOS");
		int opcao = sc.nextInt();
		sc.nextLine();

		if (opcao < 1 || opcao > 6) {
			System.out.println("Opção inválida.");
			sc.nextLine();
			return;
		}

		String str;
		int num;

		switch (opcao) {
		case 1:
			System.out.println("Digite o nome novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "nome", str);
			break;
		case 2:
			System.out.println("Digite a descricao nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "desc", str);
			break;
		case 3:
			System.out.println("Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "telefone", str);
			break;
		case 4:
			System.out.println("Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "email", str);
			break;
		case 5:
			System.out.println("Escolha a opção");
			System.out.println("1 - Editar rua");
			System.out.println("2 - Editar numero");
			System.out.println("3 - Editar bairro");
			System.out.println("4 - Editar cep");
			System.out.println("5 - Editar cidade");
			System.out.println("6 - Editar estado");
			System.out.println("7 - Editar TODOS");
			opcao = sc.nextInt();

			switch (opcao){
				case 1:
					System.out.println("Digite a rua nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "rua", str);
					break;
				case 2:
					System.out.println("Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarFornecedor(id, "numero", num);
					break;
				case 3:
					System.out.println("Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "bairro", str);
					break;
				case 4:
					System.out.println("Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cep", str);
					break;
				case 5:
					System.out.println("Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cidade", str);
					break;
				case 6:
					System.out.println("Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "estado", str);
					break;
				case 7:
					System.out.println("Digite a rua nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "rua", str);

					System.out.println("Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarFornecedor(id, "numero", num);

					System.out.println("Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "bairro", str);

					System.out.println("Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cep", str);

					System.out.println("Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cidade", str);

					System.out.println("Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "estado", str);
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
			break;
		case 6:
			System.out.println("Digite o nome novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "nome", str);

			System.out.println("Digite a descricao nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "desc", str);

			System.out.println("Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "telefone", str);

			System.out.println("Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "email", str);

			System.out.println("Digite a rua nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "rua", str);

			System.out.println("Digite o numero novo: ");
			num = sc.nextInt();
			while (num == 0) { num = sc.nextInt(); }
			loja.EditarFornecedor(id, "numero", num);

			System.out.println("Digite o bairro novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "bairro", str);

			System.out.println("Digite o CEP novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "cep", str);

			System.out.println("Digite a cidade nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "cidade", str);

			System.out.println("Digite o estado novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "estado", str);
			break;

		default:
			System.out.println("Opção inválida.");
			break;
		}

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
		
		if (!loja.IdValido(id, 'F')) {
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
				sc.nextLine();
				loja.MostraFornecedores(id);
				break;
			default:
				System.out.println("Opção inválida.");
				return;
		}

		sc.nextLine();
	}

	//
	// PRODUTO
	//

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
		System.out.println("Diga o id do fornecedor responsável: ");
		int id_forn = sc.nextInt();

		while (!loja.IdValido(id_forn, 'F')) {
			System.out.println("Id de fornecedor inválido. Digite novamente. ");
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

		if (!loja.IdValido(id, 'P')) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}

		System.out.println("Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar fornecedor");
		System.out.println("4 - Editar TODOS");
		int opcao = sc.nextInt();
		sc.nextLine();

		if (opcao < 1 || opcao > 4) {
			System.out.println("Opção inválida.");
			sc.nextLine();
			return;
		}

		String str;
		int num;

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome novo: ");
				str = sc.nextLine();
				if (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "nome", str);
				break;
			case 2:
				System.out.println("Digite a descricao nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "desc", str);
				break;
			case 3:
				loja.MostraFornecedores();
				System.out.println("Digite o id de fornecedor novo: ");
				num = sc.nextInt();
				while (!loja.IdValido(num, 'F')) {
					System.out.println("Id de fornecedor inválido. Digite novamente. ");
					num = sc.nextInt();
				}
				loja.EditarProduto(id, "id_fornecedor", num);
				break;
			case 4:
				System.out.println("Digite o nome novo: ");
				str = sc.nextLine();
				if (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "nome", str);

				System.out.println("Digite a descricao nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "desc", str);

				loja.MostraFornecedores();
				System.out.println("Digite o id de fornecedor novo: ");
				num = sc.nextInt();
				while (!loja.IdValido(num, 'F')) {
					System.out.println("Id de fornecedor inválido. Digite novamente. ");
					num = sc.nextInt();
				}
				loja.EditarProduto(id, "id_fornecedor", num);
				break;
			default:
				System.out.println("Opção inválida.");
				return;
		}

		sc.nextLine();
	}

	private void ExcluiProduto() {
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}

		loja.MostraProdutos();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja excluir o produto com qual id?");
		int id = sc.nextInt();
		sc.nextLine();
		if (!loja.IdValido(id, 'P')) {
			System.out.println("Id inválido.");
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
		System.out.println("3 - Filtrar por Id");
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
				sc.nextLine();
				while (!loja.IdValido(id, 'P')) {
					System.out.println("Id inválido.");
					id = sc.nextInt();
				}
				loja.MostraProdutos(id);
				break;
			default:
				System.out.println("Opção inválida.");
				return;
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
		
		while (!loja.IdValido(id, 'P')) {
			System.out.println("Id inválido");
			id = sc.nextInt();
		}

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
			default:
				System.out.println("Opção inválida.");
				return;
		}
	}
}
