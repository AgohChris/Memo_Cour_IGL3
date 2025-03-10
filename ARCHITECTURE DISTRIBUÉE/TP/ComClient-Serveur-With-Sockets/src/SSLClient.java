import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLClient {

    public static void main(String[] args) {
        try {
            // Load the truststore
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("client.truststore"), "truststore_password".toCharArray());

            // Initialize the TrustManagerFactory
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(trustStore);

            // Initialize the SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create the SSLSocket
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 5001);

            PrintWriter output = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            output.println("Bonjour Serveur SSL !");
            String response = input.readLine();
            System.out.println("Réponse du serveur : " + response);

            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}