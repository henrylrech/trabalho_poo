package pkg.FunctionsAdministrador;

import java.util.Scanner;

import pkg.Endereco;
import pkg.Fornecedor;
import pkg.Loja;

public class FunctionsFornecedor {
	private static Scanner sc = new Scanner(System.in);
	
	public static void CriaFornecedor(Loja loja) {
		System.out.println("---CRIANDO FORNECEDOR---");
		System.out.println("--> Diga o nome do fornecedor: ");
		String nome = sc.nextLine();
		System.out.println("--> Diga uma descrição sobre o fornecedor: ");
		String desc = sc.nextLine();
		System.out.println("--> Diga o telefone do fornecedor: ");
		String tele = sc.nextLine();
		System.out.println("--> Diga o email do fornecedor: ");
		String email = sc.nextLine();
		System.out.println("--> Diga o numero da casa/apartamento do fornecedor: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("--> Diga a rua do fornecedor: ");
		String rua = sc.nextLine();
		System.out.println("--> Diga o bairro do fornecedor: ");
		String bairro = sc.nextLine();
		System.out.println("--> Diga o cep do fornecedor: ");
		String cep = sc.nextLine();
		System.out.println("--> Diga a cidade do fornecedor: ");
		String cidade = sc.nextLine();
		System.out.println("--> Diga o estado do fornecedor: ");
		String estado = sc.nextLine();
		System.out.println("-------------------------");
		
		Fornecedor f = new Fornecedor(nome,desc,tele,email,new Endereco(rua, numero, bairro, cep, cidade, estado));
		loja.IncluiFornecedor(f);
		sc.nextLine();
	}
	
	public static void EditaFornecedor(Loja loja) {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("--> Nenhum fornecedor a ser exibido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("---EDITANDO FORNECEDOR---");
		loja.MostraFornecedores();
		System.out.println("--> Deseja editar o fornecedor com qual id?");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");
		
		if (!loja.IdValido(id, 'F')) {
			System.out.println("--> Id inválido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar telefone");
		System.out.println("4 - Editar email");
		System.out.println("5 - Editar endereço");
		System.out.println("6 - Editar TODOS");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");

		String str;
		int num;

		switch (opcao) {
		case 1:
			System.out.println("--> Digite o nome novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "nome", str);
			break;
		case 2:
			System.out.println("--> Digite a descricao nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "desc", str);
			break;
		case 3:
			System.out.println("--> Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "telefone", str);
			break;
		case 4:
			System.out.println("--> Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "email", str);
			break;
		case 5:
			System.out.println("--> Escolha a opção");
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
					System.out.println("--> Digite a rua nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "rua", str);
					break;
				case 2:
					System.out.println("--> Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarFornecedor(id, "numero", num);
					break;
				case 3:
					System.out.println("--> Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "bairro", str);
					break;
				case 4:
					System.out.println("--> Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cep", str);
					break;
				case 5:
					System.out.println("--> Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cidade", str);
					break;
				case 6:
					System.out.println("--> Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "estado", str);
					break;
				case 7:
					System.out.println("--> Digite a rua nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "rua", str);

					System.out.println("--> Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarFornecedor(id, "numero", num);

					System.out.println("--> Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "bairro", str);

					System.out.println("--> Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cep", str);

					System.out.println("--> Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "cidade", str);

					System.out.println("--> Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarFornecedor(id, "estado", str);
					break;
				default:
					System.out.println("--> Opção inválida.");
					break;
			}
			break;
		case 6:
			System.out.println("--> Digite o nome novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "nome", str);

			System.out.println("--> Digite a descricao nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "desc", str);

			System.out.println("--> Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "telefone", str);

			System.out.println("--> Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "email", str);

			System.out.println("--> Digite a rua nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "rua", str);

			System.out.println("--> Digite o numero novo: ");
			num = sc.nextInt();
			while (num == 0) { num = sc.nextInt(); }
			loja.EditarFornecedor(id, "numero", num);

			System.out.println("--> Digite o bairro novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "bairro", str);

			System.out.println("--> Digite o CEP novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "cep", str);

			System.out.println("--> Digite a cidade nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "cidade", str);

			System.out.println("--> Digite o estado novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarFornecedor(id, "estado", str);
			break;

		default:
			System.out.println("--> Opção inválida.");
			break;
		}

		sc.nextLine();
	}
	
	public static void ExcluiFornecedor(Loja loja) {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("--> Nenhum fornecedor a ser exibido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("---EXCLUIR FORNECEDOR---");
		loja.MostraFornecedores();
		System.out.println("--> Deseja excluir o fornecedor com qual id?");
		int id = sc.nextInt();
		System.out.println("------------------------");
		
		if (!loja.IdValido(id, 'F')) {
			System.out.println("-->Id inválido.");
			sc.nextLine();
			return;
		}
		
		loja.ExcluirFornecedor(id);
		sc.nextLine();
	}
	
	public static void ConsultaFornecedores(Loja loja) {
		System.out.println("---CONSULTAR FORNECEDOR---");
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por nome");
		System.out.println("3 - Filtrar por id");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");
		switch (opcao) {
			case 1:
				loja.MostraFornecedores();
				break;
			case 2:
				System.out.println("--> Escolha o nome a ser buscado: ");
				String busca = sc.nextLine();
				loja.MostraFornecedores(busca);
				break;
			case 3:
				System.out.println("--> Escolha o id a ser buscado: ");
				int id = sc.nextInt();
				sc.nextLine();
				loja.MostraFornecedores(id);
				break;
			default:
				System.out.println("--> Opção inválida.");
				return;
		}

		sc.nextLine();
	}
	
	public static void MostraProdutosFornecedor(Loja loja) {
		System.out.println("---MOSTRA PRODUTOS DO FORNECEDOR---");
		loja.MostraFornecedores();
		System.out.println("--> Deseja ver os produtos do fornecedor com qual id?");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");
		
		loja.mostraProdutosFornecedor(id);
	}
}
