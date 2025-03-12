import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLClient {
    public static void main(String[] args) {
        try {
            // Charger le truststore (si nécessaire)
            char[] truststorePassword = "1234567".toCharArray();
            KeyStore ts = KeyStore.getInstance("JKS");
            ts.load(new FileInputStream("myserver.keystore"), truststorePassword);

            // Initialiser le TrustManagerFactory avec le truststore
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ts);

            // Initialiser le SSLContext avec le TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Créer un SSLSocketFactory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Créer un SSLSocket
            try (SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 5000)) {
                PrintWriter output = new PrintWriter(sslSocket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                output.println("Bonjour Serveur sécurisé je suis Py !");
                String response = input.readLine();
                System.out.println("Réponse du serveur : " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}