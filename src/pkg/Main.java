package pkg;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc;
	private Loja loja = new Loja();
	
	public static void main(String[] args) {
		Main main = new Main();
		main.MostraMenu();
	}
	
	public void MostraMenu() {
		int opcao = 0;
		sc = new Scanner(System.in);
		Fornecedor temp = new Fornecedor("Henry","Fornecedor","99999999","email@email.com");
		loja.IncluiFornecedor(temp);

		do {
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar um fornecedor");
			System.out.println(" 2 - Editar fornecedor");
			System.out.println(" 3 - Excluir fornecedor");
			System.out.println(" 4 - Consultar fornecedores");
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
			case 0:
				System.out.println("Saindo...");
				System.exit(0);
			}
			System.out.println("---------------------------------------------");
		} while (opcao != 0);
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
			return;
		}
		
		loja.MostraFornecedores();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja editar o fornecedor com qual indice?");
		int indice = sc.nextInt();
		
		if (indice < 0 || indice > loja.getQuantosFornecedores()) {
			System.out.println("Indice inválido.");
			return;
		}
		
		System.out.println("Escolha a opção");
		System.out.println("1 - Editar nome");
		System.out.println("2 - Editar descricao");
		System.out.println("3 - Editar telefone");
		System.out.println("4 - Editar email");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome novo: ");
			String nome = sc.nextLine();
			if (nome == "") { nome = sc.nextLine(); }
			loja.fornecedores[indice].setNome(nome);
			System.out.println("Nome atualizado!");
			break;
		case 2:
			System.out.println("Digite a descricao nova: ");
			String desc = sc.nextLine();
			while (desc == "") { desc = sc.nextLine(); }
			loja.fornecedores[indice].setDesc(desc);
			System.out.println("Descricao atualizada!");
			break;
		case 3:
			System.out.println("Digite o telefone novo: ");
			String tele = sc.nextLine();
			while (tele == "") { tele = sc.nextLine(); }
			loja.fornecedores[indice].setTelefone(tele);
			System.out.println("Telefone atualizado!");
			break;
		case 4:
			System.out.println("Digite o email novo: ");
			String email = sc.nextLine();
			while (email == "") { email = sc.nextLine(); }
			loja.fornecedores[indice].setEmail(email);
			System.out.println("Email atualizado!");
			break;
		}
		sc.nextLine();
	}

	private void ExcluiFornecedor() {
		if (loja.getQuantosFornecedores() == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		
		loja.MostraFornecedores();
		System.out.println("---------------------------------------------");
		System.out.println("Deseja excluir o fornecedor com qual indice?");
		int indice = sc.nextInt();
		
		if (indice < 0 || indice > loja.getQuantosFornecedores()) {
			System.out.println("Indice inválido.");
			return;
		}
		
		loja.ExcluirFornecedor(indice);
		sc.nextLine();
	}

	private void ConsultaFornecedores() {
		loja.MostraFornecedores();
		sc.nextLine();
	}

}
