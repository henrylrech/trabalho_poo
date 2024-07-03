package pkg.FunctionsCliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import pkg.Cliente;
import pkg.ItemPedido;
import pkg.Loja;
import pkg.Pedido;
import pkg.Produto;

public class FunctionsComprador {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void FazerPedido(Loja loja) {
        System.out.println("---CONSULTAR PRODUTO-----");
        System.out.println("--> Escolha a opção");
        System.out.println("1 - Mostrar todos");
        System.out.println("2 - Filtrar por nome");
        System.out.println("3 - Filtrar por id");
        int opcao = sc.nextInt();
        sc.nextLine();
        System.out.println("-------------------------");
        Produto produto = null;
        switch (opcao) {
            case 1:
                loja.MostraProdutosPedido();
                System.out.println("--> Escolha o id do produto a ser adicionado ao carrinho: ");
                int id = sc.nextInt();
                sc.nextLine();
                produto = loja.buscarProdutoPorId(id);
                break;
            case 2:
                System.out.println("--> Escolha o nome do produto a ser buscado: ");
                String busca = sc.nextLine();
                loja.MostraProdutosPedido(busca);
                System.out.println("--> Escolha o id do produto a ser adicionado ao carrinho: ");
                int id2 = sc.nextInt();
                sc.nextLine();
                produto = loja.buscarProdutoPorId(id2);
                break;
            case 3:
                System.out.println("--> Escolha o id a ser buscado: ");
                id = sc.nextInt();
                sc.nextLine();
                produto = loja.buscarProdutoPorId(id);
                break;
            default:
                System.out.println("--> Opção inválida.");
                return;
        }

        if (produto == null) {
            System.out.println("--> Produto não encontrado.");
            return;
        }

        System.out.println("--> Informe a quantidade desejada: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        double totalItem = quantidade * produto.getPreco();
        System.out.println("--> Total do item: R$" + totalItem);
        System.out.println("--> Confirmar adição ao carrinho? (S/N)");
        String confirmacao = sc.nextLine();
        if (confirmacao.equalsIgnoreCase("S")) {
            Cliente cliente = loja.buscarClientePorNome(loja.getUsuarioAtivo());
            if (cliente != null) {
                cliente.adicionarAoCarrinho(new ItemPedido(produto, quantidade));
                System.out.println("--> Produto adicionado ao carrinho.");
            } else {
                System.out.println("--> Cliente não encontrado.");
            }
        } else {
            System.out.println("--> Produto não adicionado ao carrinho.");
        }
    }

	 public static void visualizarCarrinho(Loja loja) {
	        Cliente cliente = loja.buscarClientePorNome(loja.getUsuarioAtivo());
	        if (cliente == null) {
	            System.out.println("--> Cliente não encontrado.");
	            return;
	        }
	        
	        if (cliente.getCarrinho().isEmpty()) {
	        	System.out.println("--> Carrinho vazio.");
	        	sc.nextLine();
	            return;
	        }

	        System.out.println("---CARRINHO DE COMPRAS---");
	        double totalCarrinho = cliente.calcularTotalCarrinho();
	        for (ItemPedido item : cliente.getCarrinho()) {
	            Produto produto = item.getProduto();
	            System.out.println("--> Produto: " + produto.getNome() + ", Quantidade: " + item.getQuantidade() + ", Preço: R$" + produto.getPreco() + ", Total: R$" + (item.getQuantidade() * produto.getPreco()));
	        }
	        System.out.println("--> Total do carrinho com ICMS: R$" + (totalCarrinho + (totalCarrinho * 0.17)));
	        
	        System.out.println("-------------------------");

	        System.out.println("--> Deseja finalizar o pedido? (S/N)");
	        String confirmacao = sc.nextLine();
	        if (confirmacao.equalsIgnoreCase("S")) {
	            cliente.finalizarPedido(loja);
	        } else {
	            System.out.println("--> Pedido não finalizado.");
	        }
	    }

	 public static void visualizarPedidos(Loja loja) {
	        Cliente cliente = loja.buscarClientePorNome(loja.getUsuarioAtivo());
	        if (cliente == null) {
	            System.out.println("--> Cliente não encontrado.");
	            return;
	        }

	        System.out.println("---CONSULTAR PEDIDOS---");
	        System.out.println("--> Escolha a opção");
	        System.out.println("1 - Consultar por número do pedido");
	        System.out.println("2 - Consultar por intervalo de datas");
	        int opcao = sc.nextInt();
	        sc.nextLine();

	        switch (opcao) {
	            case 1:
	                List<Pedido> pedidosCliente = loja.buscarPedidosPorCliente(cliente);
	                if (pedidosCliente.isEmpty()) {
	                    System.out.println("--> Nenhum pedido encontrado.");
	                    return;
	                }

	                System.out.println("--> Lista de pedidos:");
	                for (Pedido p : pedidosCliente) {
	                    System.out.println("Número do pedido: " + p.getNumero() + ", Data do pedido: " + new SimpleDateFormat("dd/MM/yyyy").format(p.getDataPedido().getTime()));
	                }

	                System.out.println("--> Informe o número do pedido: ");
	                int numero = sc.nextInt();
	                sc.nextLine();
	                Pedido pedido = loja.buscarPedidoPorNumero(numero);
	                if (pedido != null && pedido.getCliente().equals(cliente)) {
	                    pedido.exibirDetalhes();
	                } else {
	                    System.out.println("--> Pedido não encontrado ou não pertence a este cliente.");
	                }
	                break;

	            case 2:
	                System.out.println("--> Informe a data de início (dd/MM/yyyy): ");
	                String dataInicioStr = sc.nextLine();
	                System.out.println("--> Informe a data de fim (dd/MM/yyyy): ");
	                String dataFimStr = sc.nextLine();

	                try {
	                    Calendar dataInicio = Calendar.getInstance();
	                    dataInicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioStr));
	                    Calendar dataFim = Calendar.getInstance();
	                    dataFim.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataFimStr));

	                    List<Pedido> pedidos = loja.buscarPedidosPorIntervalo(dataInicio, dataFim);
	                    for (Pedido p : pedidos) {
	                        if (p.getCliente().equals(cliente)) {
	                            p.exibirDetalhes();
	                        }
	                    }
	                } catch (ParseException e) {
	                    System.out.println("--> Formato de data inválido.");
	                }
	                break;

	            default:
	                System.out.println("--> Opção inválida.");
	                break;
	        }
	    }
	 
	 public static void EditaComprador(Loja loja) {
			
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
				loja.EditarComprador("nome", str);
				break;
			case 2:
				System.out.println("--> Digite o telefone novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("telefone", str);
				break;
			case 3:
				System.out.println("--> Digite o email novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("email", str);
				break;
			case 4:
				System.out.println("--> Digite o cartão de credito novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("cc", str);
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
						loja.EditarComprador("rua", str);
						break;
					case 2:
						System.out.println("--> Digite o numero novo: ");
						num = sc.nextInt();
						sc.nextLine();
						while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
						loja.EditarComprador("numero", num);
						break;
					case 3:
						System.out.println("--> Digite o bairro novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("bairro", str);
						break;
					case 4:
						System.out.println("--> Digite o CEP novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("cep", str);
						break;
					case 5:
						System.out.println("--> Digite a cidade nova: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("cidade", str);
						break;
					case 6:
						System.out.println("--> Digite o estado novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("estado", str);
						break;
					case 7:
						System.out.println("--> Digite a rua nova: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("rua", str);

						System.out.println("--> Digite o numero novo: ");
						num = sc.nextInt();
						sc.nextLine();
						while (num == 0) { num = sc.nextInt(); sc.nextLine(); }
						loja.EditarComprador("numero", num);

						System.out.println("--> Digite o bairro novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("bairro", str);

						System.out.println("--> Digite o CEP novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("cep", str);

						System.out.println("--> Digite a cidade nova: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("cidade", str);

						System.out.println("--> Digite o estado novo: ");
						str = sc.nextLine();
						while (str.isEmpty()) { str = sc.nextLine(); }
						loja.EditarComprador("estado", str);
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
				loja.EditarComprador("nome", str);

				System.out.println("--> Digite o telefone novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("telefone", str);

				System.out.println("--> Digite o email novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("email", str);
				
				System.out.println("--> Digite o cartão de credito novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("cc", str);

				System.out.println("--> Digite a rua nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("rua", str);

				System.out.println("--> Digite o numero novo: ");
				num = sc.nextInt();
				while (num == 0) { num = sc.nextInt(); }
				loja.EditarComprador("numero", num);

				System.out.println("--> Digite o bairro novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("bairro", str);

				System.out.println("--> Digite o CEP novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("cep", str);

				System.out.println("--> Digite a cidade nova: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("cidade", str);

				System.out.println("--> Digite o estado novo: ");
				str = sc.nextLine();
				while (str.isEmpty()) { str = sc.nextLine(); }
				loja.EditarComprador("estado", str);
				break;

			default:
				System.out.println("--> Opção inválida.");
				break;
			}

			sc.nextLine();
		}
    
}
