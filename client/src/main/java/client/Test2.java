package client;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import myEjb.MyTestRemote;

public class Test2 {
	public static void main(String[] args) throws NamingException {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		//props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
		//props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		// optional. Defaults to localhost. Only needed if web server is running
		// on a different host than the appserver
		// props.setProperty("org.omg.CORBA.ORBInitialHost", myServerAddress);
		// optional. Defaults to 3700. Only needed if target orb port is not
		// 3700.
		// props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		//Context ctx = new InitialContext(props);
		 InitialContext ctx = new
	             InitialContext(); 

		// java.util.Hashtable<String, String> hashTable = new Hashtable<String,
		// String>();
		// hashTable.put(Context.INITIAL_CONTEXT_FACTORY,
		// "com.sun.enterprise.naming.impl.SerialInitContextFactory");

		// InitialContext ctx = new InitialContext(hashTable);
		// EJBContainer.createEJBContainer();
//		 /EJBContainer.APP_NAME
		 
		Object ref = ctx.lookup(MyTestRemote.class.getName()); 
		System.out.println(ref instanceof MyTestRemote);
		MyTestRemote a = (MyTestRemote) ref;
		System.out.println(a.hashCode());
		System.out.println(a.getClass());
		try {
			a.say("x");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TestRemote example = (TestRemote)PortableRemoteObject.narrow(ref,TestRemote.class);
		//System.out.println(example.say());
	}
}