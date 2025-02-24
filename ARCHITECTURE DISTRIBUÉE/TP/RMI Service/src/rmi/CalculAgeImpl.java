package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Calendar;



public class CalculAgeImpl extends UnicastRemoteObject implements CalculeAge{

    protected CalculAgeImpl() throws RemoteException{
        super();
    }
    @Override
    public int CalculerAge(int anneeNaissance) throws RemoteException {
        int anneeActuelle = Calendar.getInstance().gat(Calendar.YEAR);

        return anneeActuelle - anneeNaissancence;
    }
}