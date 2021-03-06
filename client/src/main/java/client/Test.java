package client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import myEjb.MyTestRemote;

public class Test {
	public static void main(String[] args) {

		java.util.Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.impl.SerialInitContextFactory");
		hashTable.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		hashTable.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
		Context ctx = null;
		try {
			ctx = new InitialContext(hashTable);
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			 InitialContext ic = new InitialContext();
			 MyTestRemote hb = (MyTestRemote) ctx.lookup("myEjb.TestLocal");
			//System.out.println(hb.say());
			 
			// java:global[/application name]/module name /enterprise bean
			// name[/interface name ]
			// ctx.list("java:module");

			// myEjb.TestLocal
			//TestLocal example2 = (TestLocal) ctx.lookup("java:module/myEjb.TestLocal");
			//System.out.println(example2.say());
			
			//Object ref = ctx.lookup("java:global/ear-1.0/ejbs-1.0/TestLocalImpl");
			//TestLocal example = (TestLocal)PortableRemoteObject.narrow(ref,TestLocal.class);
			//System.out.println(example.say());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
