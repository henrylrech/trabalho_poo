package pkg;

public class Loja {
	public Fornecedor[] fornecedores;
	public int quantosFornecedores;
	
	public Loja() {
		this.fornecedores = new Fornecedor[100];
		this.quantosFornecedores = 0;
	}
	
	public void IncluiFornecedor(Fornecedor f) {
		this.fornecedores[this.quantosFornecedores] = f;
		this.quantosFornecedores++;
		System.out.println("Fornecedor " + f.nome + " incluido!");
	}
	
	public void ExcluirFornecedor(int indice) {
		System.out.println("Excluindo fornecedor (" + indice + ") com nome (" + this.fornecedores[indice].nome + ")");
		Fornecedor[] novo_array = new Fornecedor[100];
		for (int i = 0, j = 0; i < this.quantosFornecedores; i++) {
            if (i != indice) {
                novo_array[j++] = this.fornecedores[i];
            }
        }
		this.fornecedores = novo_array;
		this.quantosFornecedores--;
		System.out.println("Fornecedor excluido!");
	}
	
	public void MostraFornecedores() {
		if (this.quantosFornecedores == 0) {
			System.out.println("Nenhum fornecedor a ser exibido.");
			return;
		}
		for (int i=0; i<this.quantosFornecedores; i++) {
			String nome = this.fornecedores[i].nome;
			String desc = this.fornecedores[i].desc;
			String tel = this.fornecedores[i].telefone;
			String email = this.fornecedores[i].email;
			System.out.println(i + " - Nome: " + nome + ", Descricao: " + desc + ", Telefone: " + tel + ", Email: " + email);
		}
	}

	public int getQuantosFornecedores() {
		return quantosFornecedores;
	}
}
