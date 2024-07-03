package pkg.FunctionsAdministrador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import pkg.Cliente;
import pkg.Loja;

public class FunctionsPedido {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void EditaDataEntregaPedido(Loja loja) {
		MostraPedidos(loja, 1);
		
		System.out.println("Deseja editar a data de entrega do pedido com qual número?");
		int numPedido = sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("--> Informe a data de entrega nova (dd/MM/yyyy): ");
        String dataInicioStr = sc.nextLine();
        Calendar data;
        try {
            data = Calendar.getInstance();
            data.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioStr));
        } catch (ParseException e) {
            System.out.println("--> Formato de data inválido.");
            return;
        }
        
        loja.EditaDataEntregaPedido(numPedido, data);

	 }
	
	public static void MostraPedidos(Loja loja) {
		System.out.println("---CONSULTAR PEDIDOS---");
		System.out.println("--> Escolha a opção");
		System.out.println("1 - Mostrar todos");
		System.out.println("2 - Filtrar por cliente");
		System.out.println("3 - Filtrar por numero");
		int opcao = sc.nextInt();
		sc.nextLine();
		System.out.println("-------------------------");
		
		switch (opcao) {
		case 1:
			loja.MostraPedidos();
			break;
		case 2:
			System.out.println("--> Escolha o nome do cliente a ser buscado: ");
			String s = sc.nextLine();
			Cliente c = loja.buscarClientePorNome(s);
			loja.MostraPedidos(c);
			break;
		case 3:
			System.out.println("--> Escolha o numero do pedido a ser buscado: ");
			int id = sc.nextInt();
			sc.nextLine();
			loja.MostraPedidos(id);
			break;
		default:
			System.out.println("--> Opção inválida.");
			return;
		}
		sc.nextLine();
	}
	
	public static void MostraPedidos(Loja loja, int numero) {
		switch (numero) {
		case 1:
			loja.MostraPedidos();
			break;
		case 2:
			System.out.println("--> Escolha o nome do cliente a ser buscado: ");
			String s = sc.nextLine();
			Cliente c = loja.buscarClientePorNome(s);
			loja.MostraPedidos(c);
			break;
		case 3:
			System.out.println("--> Escolha o numero do pedido a ser buscado: ");
			int id = sc.nextInt();
			sc.nextLine();
			loja.MostraPedidos(id);
			break;
		default:
			System.out.println("--> Opção inválida.");
			return;
		}
	}
	 
	 public static void FinalizaPedido(Loja loja) {
		 MostraPedidos(loja);
			
		 System.out.println("Deseja finalizar o pedido com qual número?");
		 int numPedido = sc.nextInt();
		 sc.nextLine();
			
		 loja.FinalizaPedido(numPedido);
	 }
	 
	 public static void ExcluiPedido(Loja loja) {
		 MostraPedidos(loja);
			
		 System.out.println("Deseja excluir o pedido com qual número?");
		 int numPedido = sc.nextInt();
		 sc.nextLine();
			
		 loja.ExcluiPedido(numPedido);
	 }
}
