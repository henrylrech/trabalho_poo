package pkg.FunctionsAdministrador;

import java.util.Scanner;

import pkg.Loja;

public class FunctionsProduto {
	
	private static Scanner sc = new Scanner(System.in);

	public static void CriaProduto(Loja loja) {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("--> É preciso pelo menos um fornecedor para adicionar produto.");
			sc.nextLine();
			return;
		}
		System.out.println("------CRIANDO PRODUTO------");
		System.out.println("--> Diga o nome do produto: ");
		String nome = sc.nextLine();
		System.out.println("--> Diga uma descrição sobre o produto: ");
		String desc = sc.nextLine();
		System.out.println("--> Diga o estoque inicial do produto: ");
		float estoque = sc.nextFloat();
		loja.MostraFornecedores();
		System.out.println("--> Diga o id do fornecedor responsável: ");
		int id_forn = sc.nextInt();
		System.out.println("--> Diga o preço de venda desse produto: ");
		double preco = sc.nextDouble();

		while (!loja.IdValido(id_forn, 'F')) {
			System.out.println("--> Id de fornecedor inválido. Digite novamente. ");
			id_forn = sc.nextInt();
			System.out.println("------------------------");
		}

		loja.IncluiProduto(nome, desc, estoque, id_forn, preco);
		sc.nextLine();
	}

	public static void EditaProduto(Loja loja){
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("--> Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}
		System.out.println("----EDITANDO PRODUTO----");
		loja.MostraProdutos();
		System.out.println("- - - - - - - - - - - - ");
		System.out.println("Deseja editar o produto com qual id?");
		int id = sc.nextInt();
		System.out.println("- - - - - - - - - - - - ");

		if (!loja.IdValido(id, 'P')) {
			System.out.println("Id inválido.");
			sc.nextLine();
			return;
		}
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar fornecedor");
		System.out.println("4 - Editar TODOS");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------");

		String str;
		int num;

		switch (opcao) {
			case 1:
				System.out.println("--> Digite o nome novo: ");
				str = sc.nextLine();
				if (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "nome", str);
				break;
			case 2:
				System.out.println("--> Digite a descricao nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "desc", str);
				break;
			case 3:
				loja.MostraFornecedores();
				System.out.println("--> Digite o id de fornecedor novo: ");
				num = sc.nextInt();
				while (!loja.IdValido(num, 'F')) {
					System.out.println("--> Id de fornecedor inválido. Digite novamente. ");
					num = sc.nextInt();
				}
				loja.EditarProduto(id, "id_fornecedor", num);
				break;
			case 4:
				System.out.println("--> Digite o nome novo: ");
				str = sc.nextLine();
				if (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "nome", str);

				System.out.println("--> Digite a descricao nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarProduto(id, "desc", str);

				loja.MostraFornecedores();
				System.out.println("--> Digite o id de fornecedor novo: ");
				num = sc.nextInt();
				while (!loja.IdValido(num, 'F')) {
					System.out.println("--> Id de fornecedor inválido. Digite novamente. ");
					num = sc.nextInt();
				}
				loja.EditarProduto(id, "fornecedor", num);
				break;
			default:
				System.out.println("--> Opção inválida.");
				return;
		}

		sc.nextLine();
	}

	public static void ExcluiProduto(Loja loja) {
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("--> Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}
		System.out.println("----EXCLUIR PRODUTO----");
		loja.MostraProdutos();
		System.out.println("- - - - - - - - - - - - ");
		System.out.println("--> Deseja excluir o produto com qual id?");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("-----------------------");
		if (!loja.IdValido(id, 'P')) {
			System.out.println("--> Id inválido.");
			return;
		}

		loja.ExcluirProduto(id);
		sc.nextLine();
	}

	public static void ConsultaProdutos(Loja loja) {
		System.out.println("----CONSULTAR PRODUTO----");
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por nome");
		System.out.println("3 - Filtrar por Id");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------");

		switch (opcao) {
			case 1:
				loja.MostraProdutos();
				break;
			case 2:
				System.out.println("--> Escolha o nome a ser buscado: ");
				String busca = sc.nextLine();
				loja.MostraProdutos(busca);
				break;
			case 3:
				System.out.println("--> Escolha o id a ser buscado: ");
				int id = sc.nextInt();
				sc.nextLine();
				while (!loja.IdValido(id, 'P')) {
					System.out.println("--> Id inválido.");
					id = sc.nextInt();
				}
				loja.MostraProdutos(id);
				break;
			default:
				System.out.println("--> Opção inválida.");
				return;
		}
		sc.nextLine();
	}

	public static void EditaEstoque(Loja loja) {
		if (loja.getQuantosProdutos() == 0) {
			System.out.println("--> Nenhum produto a ser exibido.");
			sc.nextLine();
			return;
		}
		System.out.println("----EDITANDO ESTOQUE----");
		loja.MostraProdutos();
		System.out.println("- - - - - - - - - - - - ");
		System.out.println("--> Digite o ID do produto: ");
		int id = sc.nextInt();
		
		while (!loja.IdValido(id, 'P')) {
			System.out.println("--> Id inválido");
			id = sc.nextInt();
		}

		System.out.println("--> Escolha a opção");
		System.out.println("1 - Adicionar ao estoque");
		System.out.println("2 - Remover do estoque");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------");
		
		float quantidade;
		switch (opcao){
			case 1:
				System.out.println("--> Deseja adicionar quanto ao estoque? ");
				quantidade = sc.nextFloat();
				loja.EditaEstoqueProduto(id, quantidade);
				break;
			case 2:
				System.out.println("--> Deseja remover quanto do estoque? ");
				quantidade = sc.nextFloat();
				quantidade = quantidade * -1;
				loja.EditaEstoqueProduto(id, quantidade);
				break;
			default:
				System.out.println("--> Opção inválida.");
				return;
		}
	}
}
