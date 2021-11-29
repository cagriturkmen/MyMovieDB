package com.bilgeadam.mymoviedatabase.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientTsv {
	
	public Object run(String searchKey) {
		Object tempList = null;
		try (Socket socket = new Socket("localhost", 5555)) {
			
			System.out.println("Server almaya hazır");
			
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(searchKey);
			
			tempList = objectInputStream.readObject();
			
			System.out.println("Cevab alındı");
			Thread.sleep(2000);
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Client : " + tempList);
		return tempList;
		
	}
	
}
