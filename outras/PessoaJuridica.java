package outras;

import model.Pessoa;

public class PessoaJuridica extends Pessoa {
    // Atributos privados
    private String razaoSocial;
    private String cnpj;

    // Construtor
    public PessoaJuridica(String nome, String endereco, String telefone, String email, String razaoSocial, String cnpj) {
        super(nome, endereco, telefone, email);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    // Métodos Getter
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }
}
