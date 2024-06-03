package pkg;

public class Cliente  {
    private String nome;
    private String telefone;
    private String email;
    private String cartaoCredito;
    private Endereco endereco;
	private static int count = 0;
	private int id;

    public Cliente(String nome, String telefone, String email, String cartaoCredito, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cartaoCredito = cartaoCredito;
        this.endereco = endereco;
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


}
