package myEjb;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.Stateless;

@Stateless(name = "myEjb1")
public class TestRemoteImpl implements MyTestRemote, Serializable {
	@Override
	public String say(String x) throws RemoteException {
		System.out.println(x);

		return hashCode() + "-" + x;
	}
}
