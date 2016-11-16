package myEjb;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Local
public interface MyTestRemote extends Serializable {
	String say(String x) throws RemoteException;
}
