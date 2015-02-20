package hw02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;


/**
 * This client sends a lot of data to the server.
 * This should be a normal client but it is not
 * because it sends indeterminately data to the
 * server. It should cause slowness and service
 * denied if the server doesn't have threads 
 * implemented.  
 * 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class TCPEchoClientLotsData {

	  public static void main(String[] args) throws IOException {

		if ((args.length < 2) || (args.length > 3)) 
			  throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

		String server = args[0];
		
		byte[] data = args[1].getBytes();
		
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		
	    Socket socket = new Socket(server, servPort);

	    System.out.println("Connected to server...sending echo string");

	    InputStream in = socket.getInputStream();
	    OutputStream out = socket.getOutputStream();
	 
	    for (;;){
	    out.write(data);  // Send the encoded string to the server
	    
	    	
       
	    // Receive the same string back from the server
	    int totalBytesRcvd = 0;  // Total bytes received so far
	    int bytesRcvd;           // Bytes received in last read
	    while (totalBytesRcvd < data.length) {
	    	if ((bytesRcvd = in.read(data, totalBytesRcvd,  
	                        data.length - totalBytesRcvd)) == -1)
	    	  throw new SocketException("Connection closed prematurely");
	      	totalBytesRcvd += bytesRcvd;
	    	}  // data array is full
	
	    System.out.println("Received: " + new String(data));
	    try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	   //socket.close();  // Close the socket and its streams
	  }
	}