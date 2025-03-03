package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculAge extends Remote {
    int calculerAge(int anneeNaissance) throws RemoteException;
}