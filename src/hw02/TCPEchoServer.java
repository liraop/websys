package hw02;

import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

/**
 * The first problem with the initial implementation
 * of the tcp echo server was that only one client
 * could connect at time because it was not threaded.
 * 
 * Now the server * uses threads * and more than one client can connect.
 * 
 *  The second problem the server should avoid is
 *  overflow of data. If a client sends too much
 *  data, the server needs to be sure of handle it all
 *  without degrading other client's service. 
 *  
 *  The threaded server also solves this problem. 
 *  
 * 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class TCPEchoServer {

  private static final int BUFSIZE = 32;   // Size of receive buffer

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    // Create a server socket to accept client connection requests
    ServerSocket servSock = new ServerSocket(servPort);
    System.out.println("Server is running!");

    while (true) { // Run forever, accepting and servicing connections
      Socket clntSock = servSock.accept();     // Get client connection
      ClientHandlerEcho ch = new ClientHandlerEcho(clntSock);
      ch.run();     
    }
    /* NOT REACHED */
  }
}