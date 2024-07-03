package pkg;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produto {
    private static int count = 0;
    private int id;
    
    @JsonIgnore
    private Fornecedor fornecedor;

	private String nome;
    private String desc;
    private float estoque;
    private double preco;
    
    public Produto() {}

    public Produto(String nome, String desc, Fornecedor f, float estoque, double preco) {
        this.nome = nome;
        this.desc = desc;
        this.fornecedor = f;
        this.estoque = estoque;
        this.preco = preco;
        this.id = ++count;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getEstoque() { return this.estoque; }

    public void setEstoque(float estoque) { this.estoque = estoque; }

    @JsonIgnore
    public void setFornecedor(Fornecedor f) { this.fornecedor = f; }

    public int getId() { return this.id; }
    
    @JsonIgnore
    public Fornecedor getFornecedor() { return this.fornecedor; }
    
    @JsonIgnore
    public int getIdFornecedor() { return this.fornecedor.getId(); }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }        

    @JsonIgnore
    public boolean isDisponivel() {
        return this.estoque > 0;
    }
    
    public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Produto.count = count;
	}

	public void setId(int id) {
		this.id = id;
	}

    public void reduzirEstoque(float quantidade) {
        if (quantidade <= this.estoque) {
            this.estoque -= quantidade;
        }
    }
}