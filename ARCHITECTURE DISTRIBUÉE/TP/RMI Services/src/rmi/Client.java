package rmi;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner Scanner = new Scanner(System.in)) {
            CalculAge stub = (CalculAge) Naming.lookup("CalculAgeService");
            System.out.println("Entrez votre année de naissance : ");
            int AgeScann = Scanner.nextInt();
            int age = stub.calculerAge(AgeScann);

            System.out.println("Vous avez " + age + " ans");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}