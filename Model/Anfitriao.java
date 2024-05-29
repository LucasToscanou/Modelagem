package Model;

import java.util.ArrayList;
import java.util.List;

public class Anfitriao {
    // Atributos privados
    private String username;
    private String senha;
    private List<Residencia> residencias;

    // Construtor
    public Anfitriao(String username, String senha) {
        this.username = username;
        this.senha = senha;
        this.residencias = new ArrayList<>();
    }

    // Métodos Getter e Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Residencia> getResidencias() {
        return residencias;
    }

    // Método para autenticar o anfitrião
    public boolean autenticar() {
        // Lógica de autenticação (aqui podemos assumir que é bem simples)
        return !username.isEmpty() && !senha.isEmpty();
    }

    // Método para adicionar uma residência à lista
    public void addResidencia(Residencia residencia) {
        residencias.add(residencia);
    }

    // Método para remover uma residência da lista
    public void removeResidencia(Residencia residencia) {
        residencias.remove(residencia);
    }
}
