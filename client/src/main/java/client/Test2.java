package client;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import myEjb.MyTestRemote;

public class Test2 {
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		// props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");

		// glassfish default port value will be 3700,
		// but im using tcpviewer to redirect my 50005 port to 3700
		// props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		InitialContext ctx = new InitialContext(props);

		// Object ref0 = ctx.lookup(MyTestRemoteImpl.class.getName());
		// Object ref =
		// System.out.println(ref instanceof MyTestRemote);
		MyTestRemote a = (MyTestRemote) ctx.lookup("java:global/ear-1.0/ejbs-1.0/myEjb1!myEjb.MyTestRemote");
		System.out.println(a.hashCode());
		System.out.println(a.getClass());
		try {
			a.say("x");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
