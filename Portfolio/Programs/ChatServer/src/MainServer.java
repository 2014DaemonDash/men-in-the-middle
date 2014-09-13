import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.*;

public class MainServer {

  //Creates server socket
  private static ServerSocket serverSocket = null;
  //Creates client socket
  private static Socket clientSocket = null;

  //Will not take more than max clients
  private static final int maxClientsCount = 7;
  //Array of clientThreads
  private static final clientThread[] threads = new clientThread[maxClientsCount];

  private static String host;
  private static int portNumber;
  
  public static void main(String args[]) {

    //Creates the GUI, centers it on the screen, and makes it visible
    ServerGUI gui = new ServerGUI();
    gui.setLocationRelativeTo(null);
    gui.setVisible(true);
      
    /* 
     * Sets the default port number, can be really any 4 digit number above 1023
     * Any number below 1023 will require administrator priviledges on the computer you are using
     * 
     */
    portNumber = 2222;
    //Sets default host as localhost (only works on host computer)
    host = "localhost";

    //Gets the local InetAddress that the computer is connected to
    try{
        host = (InetAddress.getLocalHost().getHostAddress()).toString();
    }catch(Exception e){

    }

    //Adds the host and portNumber to the GUI for display
    gui.setServerIP(host);
    gui.setPortNumber(portNumber);

    //Opens a Server Socket with the port you set (2222 as default)
    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {

    }

    /*
     * Create a client socket for each connection and pass it to a new client
     * thread.
     */
    
    //Sits and waits for new clients to attempt to connect
    while (true) {
      try {
        //When a client connects it makes a new clientSocket
        clientSocket = serverSocket.accept();
        int i = 0;
        for (i = 0; i < maxClientsCount; i++) {
            //If no client on that thread, it creates a new thread for that client
            if (threads[i] == null) {
                (threads[i] = new clientThread(clientSocket, threads)).start();
                break;
                //Breaks once the connection is complete
            }
        }
        //If the server is at it's max number of clients, it won't let anyone else connect
        if (i == maxClientsCount) {
          PrintStream os = new PrintStream(clientSocket.getOutputStream());
          os.println("Too many clients. Go derp somewhere else.");
          os.close();
          //Closes the stream that the client made
          clientSocket.close();
        }
      } catch (IOException e) {

      }
    }
  }
  
  //Returns the host 
  public String getHostIP(){
      return host;
  }
  
  //Returns the port number
  public int getPort(){
      return portNumber;
  }
}