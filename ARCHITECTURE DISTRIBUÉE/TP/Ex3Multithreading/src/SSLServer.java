import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLServer {
    public static void main(String[] args) {
        try {
            // Charger le keystore
            char[] keystorePassword = "1234567".toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream("myserver.keystore"), keystorePassword);

            // Initialiser le KeyManagerFactory avec le keystore
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, keystorePassword);

            // Initialiser le SSLContext avec le KeyManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, null);

            // Créer un SSLServerSocketFactory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Créer un SSLServerSocket
            try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5000)) {
                System.out.println("Serveur SSL en attente de connexion...");
                while (true) {
                    SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                    System.out.println("Client connecté");
                    new Thread(new SSLClientHandler(sslSocket)).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SSLClientHandler implements Runnable {
    private SSLSocket sslSocket;

    public SSLClientHandler(SSLSocket sslSocket) {
        this.sslSocket = sslSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter output = new PrintWriter(sslSocket.getOutputStream(), true);
            String message = input.readLine();
            System.out.println("Message reçu : " + message);
            output.println("Message bien reçu !");
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}