package myEjb;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
@Local
public interface TestRemote extends Serializable {
	String say(String x) throws RemoteException;
}
