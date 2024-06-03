package pkg;

public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(String rua, int numero, String bairro, String cep, String cidade, String estado){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
    public String getCidade(){
        return this.cidade;
    }
    public String MostrarEnderecoCompleto(){
        return "Endereco: \n"
                + "Rua: " + this.rua + "\n"
                + "Numero: " + this.numero + "\n"
                + "Bairro: " + this.bairro + "\n"
                + "Cep: " + this.cep + "\n"
                + "Cidade: " + this.cidade + "\n"
                + "Estado: " + this.estado + "\n";
    }
}
