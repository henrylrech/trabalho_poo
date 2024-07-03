package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cliente  {
    private String nome;
    private String telefone;
    private String email;
    private String cartaoCredito;
    private Endereco endereco;
    private String senha;
    private List<ItemPedido> carrinho;
    private List<Pedido> pedidos;    
    private static int count = 0;
    private int id;
    
    public Cliente() {}

    public Cliente(String nome, String senha, String telefone, String email, String cartaoCredito, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cartaoCredito = cartaoCredito;
        this.endereco = endereco;
        this.senha = senha;
        this.carrinho = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.id = ++count;
    }

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Endereco getEndereco() { return this.endereco; }

    public void setRua(String rua) { this.endereco.setRua(rua); }

    public void setNumero(int numero) { this.endereco.setNumero(numero); }

    public void setBairro(String bairro) { this.endereco.setBairro(bairro); }

    public void setCep(String cep) { this.endereco.setCep(cep); }

    public void setCidade(String cidade) { this.endereco.setCidade(cidade); }

    public void setEstado(String estado) { this.endereco.setEstado(estado); }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ItemPedido> getCarrinho() {
        return carrinho;
    }

    public void adicionarAoCarrinho(ItemPedido item) {
        this.carrinho.add(item);
    }

    public double calcularTotalCarrinho() {
        double total = 0;
        for (ItemPedido item : carrinho) {
            total += item.getQuantidade() * item.getProduto().getPreco();
        }
        return total;
    }

    public void esvaziarCarrinho() {
        this.carrinho.clear();
    }
    
    public void finalizarPedido(Loja loja) {
        if (carrinho.isEmpty()) {
            System.out.println("--> Carrinho vazio. Adicione itens ao carrinho antes de finalizar o pedido.");
            return;
        }

        Pedido pedido = loja.criarPedido(this);
        this.pedidos.add(pedido);
        this.esvaziarCarrinho();
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }
}
