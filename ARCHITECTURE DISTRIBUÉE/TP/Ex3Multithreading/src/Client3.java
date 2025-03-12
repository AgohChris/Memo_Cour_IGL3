import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client3 {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.println("Salut Serveur c'est Bédié Albéric");
            String response = input.readLine();
            System.out.println("Réponse du serveur : " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
