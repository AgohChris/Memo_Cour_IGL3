import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLServer {

    public static void main(String[] args) {
        try {
            // Charger le keystore
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server.keystore"), "misterpy".toCharArray());

            // Initialiser le KeyManagerFactory
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, "misterpy".toCharArray());

            // Initialiser le SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Créer le SSLServerSocket sur un autre port, par exemple 5001
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(5001);

            System.out.println("Serveur SSL en attente de connexion...");

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client SSL connecté");
                new Thread(new ClientHandler(sslSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}