package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            CalculAge calcAge = new CalculAgeImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("CalculAgeService", calcAge);
            System.out.println("Serveur prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}