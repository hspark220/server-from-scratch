import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server {
  private int portNumber;

  public Server(int portNumber) {
    this.portNumber = portNumber;
  }

  public void run() {
    try {
      // initial setup for server
      ServerSocket serverSocket = new ServerSocket(portNumber);
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();

      byte[] inputBytes = new byte[2464];
      String inputString;

      while (!socket.isClosed()) {
        inputStream.read(inputBytes);
        inputString = new String(inputBytes, StandardCharsets.UTF_8);
        System.out.println(inputString);

      }

      serverSocket.close();

    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
