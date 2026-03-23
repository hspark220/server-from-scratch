import java.net.*;
import java.io.*;

public class Server {
  private int portNumber;

  public Server(int portNumber) {
    this.portNumber = portNumber;
  }

  public void run() {
    try {
      ServerSocket serverSocket = new ServerSocket(this.portNumber);
      Socket socket = serverSocket.accept();
      System.out.println("client connected");
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
