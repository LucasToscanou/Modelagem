package Model;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos privados
    private String username;
    private String senha;
    private String tipoUsuario;
    private List<CartaoDeCredito> cartaoDeCredito;

    // Construtor
    public Usuario(String username, String senha, String tipoUsuario) {
        this.username = username;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.cartaoDeCredito = new ArrayList<>();
    }

    // Método para autenticar o usuário
    public boolean autenticar() {
        // Lógica para autenticação (pode ser implementada posteriormente)
        return true; // Retornando true para fins de exemplo
    }

    // Métodos para adicionar e remover cartões de crédito
    public void addCartaoDeCredito(CartaoDeCredito cartao) {
        cartaoDeCredito.add(cartao);
    }

    public void removeCartaoDeCredito(CartaoDeCredito cartao) {
        cartaoDeCredito.remove(cartao);
    }

    // Método para obter a lista de cartões de crédito
    public List<CartaoDeCredito> getCartoesDeCredito() {
        return cartaoDeCredito;
    }
}