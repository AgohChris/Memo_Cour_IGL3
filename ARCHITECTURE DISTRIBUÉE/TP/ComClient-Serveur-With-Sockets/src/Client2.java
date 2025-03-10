import java.io.*;
import java.net.*;


public class Client2 {

    public static void main(String[] args){

        try (Socket socket = new Socket("localhost", 5000)) {
// Création des flux de sortie et d'entrée
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Envoyer un message au serveur output.println("Bonjour Serveur !");
// Lire la réponse du serveur
            String response = input.readLine(); System.out.println("Réponse du serveur : " + response);
        } catch (IOException e) { e.printStackTrace();

        }
    }

}
