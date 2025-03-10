import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Serveur en attente de connexion...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}