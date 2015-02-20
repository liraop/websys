package hw02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;



/**
 * This class is to handle clients on a thread.
 * It implements the echo server functionality.
 * 
 * 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class ClientHandlerEcho extends Thread{	
	private Socket client;
	private int BUFSIZE = 32;
	
	public ClientHandlerEcho (Socket c){
		this.client = c;
	}
	
	public void run(){
		int recvMsgSize;   // Size of received message
	    byte[] receiveBuf = new byte[BUFSIZE];  // Receive buffer

		try {
		SocketAddress clientAddress = client.getRemoteSocketAddress();
		System.out.println("Handling client at " + clientAddress);

		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();

		// Receive until client closes connection, indicated by -1 return
		while ((recvMsgSize = in.read(receiveBuf)) != -1) {
		   out.write(receiveBuf, 0, recvMsgSize);
		}
		
	      client.close();  // Close the socket.  We are done with this client!
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
		
	
}