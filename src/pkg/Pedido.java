package pkg;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pedido {
	public Pedido() {}
	
    public static double getIcms() {
		return ICMS;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	private int numero;
    private Calendar dataPedido;
    private Calendar dataEntrega;
    private String situacao;
    private List<ItemPedido> itens;
    
    @JsonIgnore
    private Cliente cliente;
    private static final double ICMS = 0.17;

    public Pedido(int numero, Calendar dataPedido, Calendar dataEntrega, String situacao) {
        this.numero = numero;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.situacao = situacao;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public String getSituacao() {
        return situacao;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
        item.getProduto().reduzirEstoque(item.getQuantidade());
    }

    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }

    @JsonIgnore
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double calcularTotalComICMS() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total * (1 + ICMS);
    }

    public void exibirDetalhes() {
        System.out.println("--> Pedido número: " + this.numero);
        System.out.println("    Data do pedido: " + this.dataPedido.getTime());
        System.out.println("    Data de entrega: " + this.dataEntrega.getTime());
        System.out.println("    Situação: " + this.situacao);
        System.out.println("    Itens:");
        for (ItemPedido item : this.itens) {
            Produto produto = item.getProduto();
            System.out.println("    - Produto: " + produto.getNome() + ", Quantidade: " + item.getQuantidade() + ", Preço: R$" + produto.getPreco() + ", Total: R$" + (item.getQuantidade() * produto.getPreco()));
        }
        System.out.println("    Total com ICMS: R$" + calcularTotalComICMS());
    }
}