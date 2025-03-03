package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Calendar;

public class CalculAgeImpl extends UnicastRemoteObject implements CalculAge {
    protected CalculAgeImpl() throws RemoteException {
        super();
    }

    @Override
    public int calculerAge(int anneeNaissance) throws RemoteException {
        int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);
        return anneeActuelle - anneeNaissance;
    }
}