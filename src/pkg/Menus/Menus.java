package pkg.Menus;

import java.util.Scanner;

import pkg.Loja;
import pkg.FunctionsAdministrador.FunctionsCliente;
import pkg.FunctionsAdministrador.FunctionsFornecedor;
import pkg.FunctionsAdministrador.FunctionsPedido;
import pkg.FunctionsAdministrador.FunctionsProduto;
import pkg.FunctionsCliente.FunctionsComprador;

public class Menus {
	
	private static Scanner sc;
	private Loja loja;
	
	public Menus(Loja loja) {
		this.loja = loja;
	}
	
	public void MenuClienteOuAdm() {
		int opcao = 0;
		sc = new Scanner(System.in);
		
		do {
			System.out.println("-----ACESSAR COMO CLIENTE OU ADM-----");
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Menu Administrador");
			System.out.println(" 2 - Menu Cliente");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					MostraMenuAdmin();
					break;
				case 2:
					MostraMenuComprador();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("-------------------------------------");
		} while (opcao != 0);
		sc.close();		
	}
	
	private void MostraMenuAdmin() {
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("-----OPÇÕES DE ADMINISTRADOR-----");
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Menu Fornecedor");
			System.out.println(" 2 - Menu Produtos");
			System.out.println(" 3 - Menu Cliente");
			System.out.println(" 4 - Menu Pedidos");
			System.out.println(" 9 - Voltar");
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
				case 3:
					MostraMenuCliente();
					break;
				case 4:
					MostraMenuPedidos();
					break;	
				case 9:
					MenuClienteOuAdm();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("-------------------------------");
		} while (opcao != 0);
		sc.close();
	}
	
	private void MostraMenuFornecedor(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("----MENU ADMIN FORNECEDORES----");
			System.out.println("--> Escolha a opção:");
			System.out.println(" 1 - Criar um fornecedor");
			System.out.println(" 2 - Editar fornecedor");
			System.out.println(" 3 - Excluir fornecedor");
			System.out.println(" 4 - Consultar fornecedores");
			System.out.println(" 5 - Mostra produtos do fornecedor");
			System.out.println(" 9 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					FunctionsFornecedor.CriaFornecedor(loja);
					break;
				case 2:
					FunctionsFornecedor.EditaFornecedor(loja);
					break;
				case 3:
					FunctionsFornecedor.ExcluiFornecedor(loja);
					break;
				case 4:
					FunctionsFornecedor.ConsultaFornecedores(loja);
					break;
				case 5:
					FunctionsFornecedor.MostraProdutosFornecedor(loja);
					break;	
				case 9:
					MostraMenuAdmin();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("-------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}
	
	private void MostraMenuProdutos(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("------MENU ADMIN PRODUTOS------");
			System.out.println("--> Escolha a opção:");
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
					FunctionsProduto.CriaProduto(loja);
					break;
				case 2:
					FunctionsProduto.EditaProduto(loja);
					break;
				case 3:
					FunctionsProduto.ExcluiProduto(loja);
					break;
				case 4:
					FunctionsProduto.ConsultaProdutos(loja);
					break;
				case 5:
					FunctionsProduto.EditaEstoque(loja);
					break;
				case 9:
					MostraMenuAdmin();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("-------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}
	
	private void MostraMenuCliente(){
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("-----MENU ADMIN CLIENTES------");
			System.out.println("--> Escolha a opção:");
			System.out.println(" 1 - Criar um cliente");
			System.out.println(" 2 - Editar cliente");
			System.out.println(" 3 - Excluir cliente");
			System.out.println(" 4 - Consultar cliente");
			System.out.println(" 9 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					FunctionsCliente.CriaCliente(loja);
					break;
				case 2:
					FunctionsCliente.EditaCliente(loja);
					break;
				case 3:
					FunctionsCliente.ExcluiCliente(loja);
					break;
				case 4:
					FunctionsCliente.ConsultaClientes(loja);
					break;
				case 9:
					MostraMenuAdmin();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}
	
	private void MostraMenuPedidos() {
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("-----MENU ADMIN PEDIDOS------");
			System.out.println("--> Escolha a opção:");
			System.out.println(" 1 - Mostrar pedidos");
			System.out.println(" 2 - Editar data de entrega");
			System.out.println(" 3 - Finalizar pedido");
			System.out.println(" 4 - Excluir pedido");
			System.out.println(" 9 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					FunctionsPedido.MostraPedidos(loja);
					break;
				case 2:
					FunctionsPedido.EditaDataEntregaPedido(loja);
					break;
				case 3:
					FunctionsPedido.FinalizaPedido(loja);
					break;
				case 4:
					FunctionsPedido.ExcluiPedido(loja);
					break;
				case 9:
					MostraMenuAdmin();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("------------------------");
		} while (opcao != 9 && opcao != 0);
		sc.close();
	}
	
	//
	// CLIENTE
	//

	private void MostraMenuComprador() {
		int opcao = 0;
		sc = new Scanner(System.in);

		do {
			System.out.println("-----OPÇÕES DE CLIENTE-----");
			System.out.println("Escolha a opção:");
			System.out.println(" 1 - Criar Conta");
			System.out.println(" 2 - Logar");
			System.out.println(" 9 - Voltar");
			System.out.println(" 0 - Sair ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
				case 1:
					FunctionsCliente.CriaCliente(loja);
					break;
				case 2:
					Login();
					break;
				case 9:
					MenuClienteOuAdm();
					break;
				case 0:
					SalvarDados();
					System.exit(0);
			}
			System.out.println("-------------------------------");
		} while (opcao != 0);
		sc.close();
	}
	
	//
	// COMPRADOR
	//
	
	private void Login() {
        System.out.println(" --> Qual o nome da sua conta");
        String nome = sc.nextLine();
        System.out.println(" --> Qual é sua senha: ");
        String senha = sc.nextLine();
        if(loja.NomeLogin(nome, senha)) {
        	loja.setUsuarioAtivo(nome);
        	MostraMenuCompradorPosLogin();
        } else {
            System.out.println(" --> Senha ou usuario incorretos!");
            System.out.println("Escolha a opção:");
            System.out.println(" 1 - Tentar novamente");
            System.out.println(" 2 - Voltar");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch(opcao) {
                case 1:
                    Login();                    
                    break;
                case 2:
                    MostraMenuComprador();
                    break;
            }
        }
    }
	
	private void MostraMenuCompradorPosLogin() {
        int opcao = 0;
        sc = new Scanner(System.in);

        do {
            System.out.println("-----MENU CLIENTE-----");
            System.out.println("Cliente: " + loja.getUsuarioAtivo());
            System.out.println("Escolha a opção:");
            System.out.println(" 1 - Editar Conta");
            System.out.println(" 2 - Fazer Pedido");
            System.out.println(" 3 - Visualizar Carrinho");
            System.out.println(" 4 - Visualizar Pedidos");
            System.out.println(" 9 - Voltar");
            System.out.println(" 0 - Sair ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                	FunctionsComprador.EditaComprador(loja);  
                    break;
                case 2:
                    FunctionsComprador.FazerPedido(loja);
                    break;
                case 3:
                	FunctionsComprador.visualizarCarrinho(loja);
                    break;
                case 4:
                	FunctionsComprador.visualizarPedidos(loja);
                    break;
                case 9:
                    MenuClienteOuAdm();
                    break;
                case 0:
                    SalvarDados();
                    System.exit(0);
            }
            System.out.println("-------------------------------");
        } while (opcao != 0);
        sc.close();
    }

	 
	 
	 private void SalvarDados() {
		 try {
			loja.SalvarDados();
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--> Saindo...");
	 }
}
