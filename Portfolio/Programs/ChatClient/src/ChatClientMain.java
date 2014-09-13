import java.util.Scanner;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientMain implements Runnable {

  //Creates the client socket
  private static Socket clientSocket = null;
  //Creates the output stream
  private static PrintStream os = null;
  //Creates the input stream
  private static DataInputStream is = null;

  private static BufferedReader inputLine = null;
  private static boolean closed = false;

  private static Scanner console = new Scanner(System.in);
  
  public static void main(String[] args) {

    //Sets the default port (2222)
    int portNumber = 2222;
    //Sets the default host as localhost (only works on the local computer)
    String host = "localhost";
    
    //Prompts user to enter IP and Port Number
    System.out.print("Input Server IP: ");
    host = console.nextLine();
    System.out.print("Input Port Number: ");
    portNumber = console.nextInt();

    System.out.println("Connected to Server IP " + host + " | Port Number = " + portNumber);
    
    try {
    	
      //Opens the client's socket with the entered IP and Port Number
      clientSocket = new Socket(host, portNumber);
      //Initializes the BufferedReader
      inputLine = new BufferedReader(new InputStreamReader(System.in));
      //Initializes the output stream and the input stream
      os = new PrintStream(clientSocket.getOutputStream());
      is = new DataInputStream(clientSocket.getInputStream());
      
    } catch (UnknownHostException e) {
      System.err.println(host + " can't be found");
    } catch (IOException e) {
      System.err.println("Can't connect to: " + host);
    }

    /*
     * If everything has been initialized then we want to write some data to the
     * socket we have opened a connection to on the port portNumber.
     */
    
    //Checks to make sure everything is working and not null
    if (clientSocket != null && os != null && is != null) {
      try {


    	//Make a new thread of this ChatClientMain class
        new Thread(new ChatClientMain()).start();
        
        //Sends the user's input through the output stream as long as the thread is still open
        while (!closed) {
          os.println(inputLine.readLine().trim());
        }

        //Once the thread ends, the streams and socket are closed
        os.close();
        is.close();
        clientSocket.close();
      } catch (IOException e) {
        System.err.println("Derp, you got an error: " + e);
      }
    }
  }

  public void run() {
	  
    String responseLine;
    try {
    	
      //Keeps checking to see if something is sent in chat, if it is and not null it prints it for the client
      while ((responseLine = is.readLine()) != null) {
    	  
        System.out.println(responseLine);
        //If the server sends []Goodbye then it breaks
        if (responseLine.indexOf("[]Goodbye") != -1){
          break;
        }
        
      }
      //Enables the client to close the streams and socket
      closed = true;
      
    } catch (IOException e) {
      System.err.println("Derp:  " + e);
    }
  }
}