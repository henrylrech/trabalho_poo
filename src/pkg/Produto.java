package pkg;

public class Produto {
    private static int count = 0;
    private int id;
    private int id_fornecedor;
    private String nome;
    private String desc;
    private float estoque;

    public Produto(String nome, String desc, float estoque, int id_fornecedor) {
        this.nome = nome;
        this.desc = desc;
        this.estoque = estoque;
        this.id_fornecedor = id_fornecedor;
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

    public void setId_fornecedor(int id_fornecedor) { this.id_fornecedor = id_fornecedor; }

    public int getId() { return this.id; }

}
