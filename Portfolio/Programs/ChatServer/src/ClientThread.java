import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;

class clientThread extends Thread {

  //Makes streams and sockets and stuff
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int maxClientsCount;

  //Gets the client's socket and the thread in the clientThread array
  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }

  public void run() {
    int maxClientsCount = this.maxClientsCount;
    clientThread[] threads = this.threads;

    //Giant try catch
    try {
        
      //Creates an input stream for this client
      is = new DataInputStream(clientSocket.getInputStream());
      //Creates an output stream for this client
      os = new PrintStream(clientSocket.getOutputStream());
      
      //Outputs this message then takes input then outputs some more
      os.println("Enter your name: ");
      String name = is.readLine().trim();
      os.println("Hello " + name + " this is the chat.\nTo leave the chat enter /Q");
      
      //Sends a message in the output stream to current users that someone new has joined
      //Does not send to the new user
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] != null && threads[i] != this) {
          //Sends it to each client in the threads list
          threads[i].os.println(name + " has joined chat!");
        }
      }
      
      while (true) {
        //Reads what the user enters
        String line = is.readLine();
        //Breaks out of the loop if the user enter /Q
        if (line.startsWith("/Q")) {
          break;
        }
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null) {
            //Sends the user's name and message through the output stream
            threads[i].os.println("[" + name + "] " + line);
          }
        }
      }
      
      //If the user leaves it sends this message to the other clients
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] != null && threads[i] != this) {
          threads[i].os.println(name + " has left chat.");
        }
      }
      
      os.println("[]Goodbye " + name + ".");

      //Makes this current thread null that way it becomes available for another client
      for (int i = 0; i < maxClientsCount; i++) {
        if (threads[i] == this) {
          threads[i] = null;
        }
      }

      //Closes the streams and the client's socket
      is.close();
      os.close();
      clientSocket.close();
    } catch (IOException e) {
        
    }
  }
}