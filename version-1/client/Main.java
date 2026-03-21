import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Byte input = 0;
    try {
      Socket clientSocket = new Socket("127.0.0.1", 8080);
      System.out.println("connected");

      // create output stream
      OutputStream outputStream = clientSocket.getOutputStream();

      // start the client loop
      while (!clientSocket.isClosed()) {
        // receive input
        System.out.print("send message: ");
        input = scanner.nextByte();
        outputStream.write(input);
        outputStream.flush();

        // close connection if receive "quit"
        if (input == 0)
          clientSocket.close();
      }
      // ending message
      System.out.println("connection closed");

    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
