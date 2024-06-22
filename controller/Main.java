package controller;

import model.PedidoDeReserva;
import view.MainView;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    final private String filePath = "./db.json";
    private static Main instance;
    private PedidoDeReserva pedido;

    Gson gson = new Gson();

    private Main() {}

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void createPedidoDeReserva(String usuario) {
        this.pedido = new PedidoDeReserva(usuario);
    }

    public void writePedidoDeReservaToFile() {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            gson.toJson(this.pedido, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PedidoDeReserva readPedidoDeReservaFromFile() {
        PedidoDeReserva pedido = null;
        try (FileReader reader = new FileReader(this.filePath)) {
            pedido = gson.fromJson(reader, PedidoDeReserva.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    // Getter and Setter para Pedido
    public PedidoDeReserva getPedido() {
        return this.pedido;
    }

    public void setPedido(PedidoDeReserva pedido) {
        this.pedido = pedido;
    }

    // Método principal para inicializar o programa
    public static void main(String[] args) {
        // Inicializa a GUI
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }
}
