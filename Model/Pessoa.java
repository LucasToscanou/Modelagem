package Model;

public class Pessoa {
    // Atributos protegidos
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String email;

    // Construtor
    public Pessoa(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Método para obter os detalhes
    public String getDetalhes() {
        return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nE-mail: " + email;
    }

    // Métodos Getter
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
