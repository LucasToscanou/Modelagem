package Controller;
import Model.PedidoDeReserva;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Main {
    final private String filePath = "./db.json";

    private static Main instance;

    private Main() {

    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void createPedidoDeReserva(String usuario) {
        PedidoDeReserva pedido = new PedidoDeReserva(usuario);
    }

    public void writePedidoDeReservaToFile(PedidoDeReserva pedido) {
        try (FileOutputStream fileOut = new FileOutputStream(this.filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pedido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PedidoDeReserva readPedidoDeReservaFromFile() {
        PedidoDeReserva pedido = null;
        try (FileInputStream fileIn = new FileInputStream(this.filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pedido = (PedidoDeReserva) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pedido;
    }
}
