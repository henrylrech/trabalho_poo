package pkg.FunctionsAdministrador;

import java.util.Scanner;

import pkg.Cliente;
import pkg.Endereco;
import pkg.Loja;

public class FunctionsCliente {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void CriaCliente(Loja loja) {
		System.out.println("----CRIANDO CONTA----");
		System.out.println("--> Diga o nome da Conta: ");
		String nome = sc.nextLine();
		System.out.println("--> Diga a senha da Conta: ");
		String senha = sc.nextLine();
		System.out.println("--> Diga o telefone da Conta: ");
		String tele = sc.nextLine();
		System.out.println("--> Diga o email da Conta: ");
		String email = sc.nextLine();
		System.out.println("--> Diga o Cartão de Credito da Conta: ");
		String cc = sc.nextLine();
		System.out.println("--> Diga o numero da casa/apartamento da Conta: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("--> Diga a rua da Conta: ");
		String rua = sc.nextLine();
		System.out.println("--> Diga o bairro da Conta: ");
		String bairro = sc.nextLine();
		System.out.println("--> Diga o cep da Conta: ");
		String cep = sc.nextLine();
		System.out.println("--> Diga a cidade da Conta: ");
		String cidade = sc.nextLine();
		System.out.println("--> Diga o estado da Conta: ");
		String estado = sc.nextLine();
		System.out.println("----------------------");
		
		Cliente c = new Cliente(nome,senha,tele,email,cc,new Endereco(rua, numero, bairro, cep, cidade, estado));
		loja.IncluiCliente(c);
		sc.nextLine();
	}
	public static void ConsultaClientes(Loja loja) {
		System.out.println("----CONSULTAR CLIENTE----");
		System.out.println("Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por nome");
		System.out.println("3 - Filtrar por id");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");
		switch (opcao) {
			case 1:
				loja.MostraClientes();
				break;
			case 2:
				System.out.println("--> Escolha o nome a ser buscado: ");
				String busca = sc.nextLine();
				loja.MostraClientes(busca);
				break;
			case 3:
				System.out.println("--> Escolha o id a ser buscado: ");
				int id = sc.nextInt();
				sc.nextLine();
				loja.MostraClientes(id);
				break;
			default:
				System.out.println("--> Opção inválida.");
				return;
		}

		sc.nextLine();
	}
	public static void ExcluiCliente(Loja loja) {
		if (loja.getQuantosClientes() == 0) {
			System.out.println("--> Nenhum cliente a ser exibido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("-----EXCLUIR CLIENTE-----");
		loja.MostraClientes();
		System.out.println("- - - - - - - - - - - - ");
		System.out.println("--> Deseja excluir o cliente com qual id?");
		int id = sc.nextInt();
		System.out.println("-------------------------");
		
		if (!loja.IdValido(id, 'C')) {
			System.out.println("--> Id inválido.");
			sc.nextLine();
			return;
		}
		
		loja.ExcluirCliente(id);
		sc.nextLine();
	}
	
	public static void EditaCliente(Loja loja) {
		if (loja.getQuantosClientes() == 0) {
			System.out.println("--> Nenhum cliente a ser exibido.");
			sc.nextLine();
			return;
		}
		System.out.println("----EDITANDO CLIENTE----");
		loja.MostraClientes();
		System.out.println("- - - - - - - - - - - - ");
		System.out.println("--> Deseja editar o cliente com qual id?");
		int id = sc.nextInt();
		System.out.println("- - - - - - - - - - - - ");
		
		if (!loja.IdValido(id, 'C')) {
			System.out.println("--> Id inválido.");
			sc.nextLine();
			return;
		}
		
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar telefone");
		System.out.println("3 - Editar email");
		System.out.println("4 - Editar cartão de credito");
		System.out.println("5 - Editar endereço");
		System.out.println("6 - Editar TODOS");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------");
		String str;
		int num;

		switch (opcao) {
		case 1:
			System.out.println("--> Digite o nome novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "nome", str);
			break;
		case 2:
			System.out.println("--> Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "telefone", str);
			break;
		case 3:
			System.out.println("--> Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "email", str);
			break;
		case 4:
			System.out.println("--> Digite o cartão de credito novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "cc", str);
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
					loja.EditarCliente(id, "rua", str);
					break;
				case 2:
					System.out.println("--> Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarCliente(id, "numero", num);
					break;
				case 3:
					System.out.println("--> Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "bairro", str);
					break;
				case 4:
					System.out.println("--> Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "cep", str);
					break;
				case 5:
					System.out.println("--> Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "cidade", str);
					break;
				case 6:
					System.out.println("--> Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "estado", str);
					break;
				case 7:
					System.out.println("--> Digite a rua nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "rua", str);

					System.out.println("--> Digite o numero novo: ");
					num = sc.nextInt();
					sc.nextLine();
					while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
					loja.EditarCliente(id, "numero", num);

					System.out.println("--> Digite o bairro novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "bairro", str);

					System.out.println("--> Digite o CEP novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "cep", str);

					System.out.println("--> Digite a cidade nova: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "cidade", str);

					System.out.println("--> Digite o estado novo: ");
					str = sc.nextLine();
					while (str.isEmpty()) { str = sc.nextLine(); }
					loja.EditarCliente(id, "estado", str);
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
			loja.EditarCliente(id, "nome", str);

			System.out.println("--> Digite o telefone novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "telefone", str);

			System.out.println("--> Digite o email novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "email", str);
			
			System.out.println("--> Digite o cartão de credito novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "cc", str);

			System.out.println("--> Digite a rua nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "rua", str);

			System.out.println("--> Digite o numero novo: ");
			num = sc.nextInt();
			while (num == 0) { num = sc.nextInt(); }
			loja.EditarCliente(id, "numero", num);

			System.out.println("--> Digite o bairro novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "bairro", str);

			System.out.println("--> Digite o CEP novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "cep", str);

			System.out.println("--> Digite a cidade nova: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "cidade", str);

			System.out.println("--> Digite o estado novo: ");
			str = sc.nextLine();
			while (str.isEmpty()) { str = sc.nextLine(); }
			loja.EditarCliente(id, "estado", str);
			break;

		default:
			System.out.println("--> Opção inválida.");
			break;
		}

		sc.nextLine();
	}
}
