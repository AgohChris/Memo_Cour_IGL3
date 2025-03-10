import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Message reçu : " + message);
            output.println("Message bien reçu !");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}