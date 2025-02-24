package rmi;

import java.rmi.remote;
import java.rmi.remoteException;

public interface CalculeAge extends Remote{
    int calculerAge(int AnneeNaissance) throws Remotexception;
}