package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.PedidoDeReserva;
import view.MainView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    final private String filePath = "db.json";
    private static Main instance;
    private PedidoDeReserva pedido;

    Gson gson = new Gson();

    private Main() {
        initializeDbFile();
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    // Método para inicializar o arquivo de banco de dados se não existir
    private void initializeDbFile() {
        try {
            if (!Files.exists(Paths.get(filePath))) {
                try (FileWriter writer = new FileWriter(filePath)) {
                    writer.write("[]"); // Inicializa o arquivo como uma lista vazia
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createPedidoDeReserva(String usuario) {
        this.pedido = new PedidoDeReserva(usuario);
    }

    public void writePedidoDeReservaToFile() {
        List<PedidoDeReserva> pedidos = readAllPedidosDeReservaFromFile();
        pedidos.add(this.pedido); // Adiciona a nova reserva à lista
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(this.filePath)) {
            gsonPretty.toJson(pedidos, writer); // Grava a lista completa no arquivo com pretty printing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PedidoDeReserva> readAllPedidosDeReservaFromFile() {
        List<PedidoDeReserva> pedidos = new ArrayList<>();
        try (FileReader reader = new FileReader(this.filePath)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            if (jsonElement.isJsonArray()) {
                pedidos = gson.fromJson(jsonElement, new TypeToken<List<PedidoDeReserva>>(){}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public boolean isDateCollision(Date newCheckin, Date newCheckout) {
        List<PedidoDeReserva> pedidos = readAllPedidosDeReservaFromFile();
        for (PedidoDeReserva pedido : pedidos) {
            if (newCheckin.before(pedido.getDataFim()) && newCheckout.after(pedido.getDataInicio())) {
                return true;
            }
        }
        return false;
    }

    // Getter e Setter para Pedido
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
