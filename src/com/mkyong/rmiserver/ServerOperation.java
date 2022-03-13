package com.mkyong.rmiserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.mkyong.rmiinterface.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 1L;

	protected ServerOperation() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String name) throws RemoteException{

		System.err.println(name + " is trying to contact!");
		return "Server says hello to " + name;

	}

	@Override
	public String howAreYouTo(String lastname) throws RemoteException {
		System.err.println(lastname + " >>>>>>>>>>> is following to contact! <<<<<<<<<<<");
		return "Server says hello again to " + lastname;
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException{

		try {

			Naming.rebind("//localhost/MyServer", new ServerOperation());            
			System.err.println("Server ready");

		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}
	}


}
