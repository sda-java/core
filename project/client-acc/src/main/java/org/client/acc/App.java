package org.client.acc;

import javax.ejb.EJB;

import myEjb.TestRemote;

public class App {

	@EJB(lookup = "java:global/ear-1.0/ejbs-1.0/myEjb1")
	private TestRemote testRemote;

	public void doAction() {
		/*
		 * try { System.out.println(testRemote.say("eeeeeeeeee")); } catch
		 * (RemoteException e) { e.printStackTrace(); }
		 */
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		App app = new App();
		app.doAction();
	}
}
