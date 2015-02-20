package hw02;

import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class represents a client that just connects
 * to the server but sends no data. It is a bad client
 * because on the previous version of the server (non-threaded)
 * just one client could connect at time. 
 * 
 * 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class TCPEchoClientNoData {

	public static void main(String[] args) throws IOException {

		if ((args.length < 2) || (args.length > 3)) 
			throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

		String server = args[0];

		byte[] data = args[1].getBytes();

		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;


		Socket socket = new Socket(server, servPort);

		System.out.println("Connected to server...sending echo string");

	    InputStream in = socket.getInputStream();

	    while (!(in.read(data,0,1) == -1)){
	    	
	    }
	}
}
