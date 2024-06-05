package outras;

import Model.Pessoa;

public class PessoaFisica extends Pessoa {
    // Atributos privados
    private String identidade;
    private String cpf;

    // Construtor
    public PessoaFisica(String nome, String endereco, String telefone, String email, String identidade, String cpf) {
        super(nome, endereco, telefone, email);
        this.identidade = identidade;
        this.cpf = cpf;
    }

    // Métodos Getter
    public String getIdentidade() {
        return identidade;
    }

    public String getCpf() {
        return cpf;
    }
}
