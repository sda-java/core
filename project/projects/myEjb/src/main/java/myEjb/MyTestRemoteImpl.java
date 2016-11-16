package myEjb;

import java.rmi.RemoteException;

import javax.ejb.Stateless;

//@SessionScoped
@Stateless(name = "myEjb2")
public class MyTestRemoteImpl implements MyTestRemote {
	@Override
	public String say(String x) throws RemoteException {
		System.out.println(x);

		return hashCode() + "-" + x;
	}
}
