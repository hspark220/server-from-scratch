import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    try {
      Socket clientSocket = new Socket("127.0.0.1", 8080);
      System.out.println("connected");

      // create output stream
      OutputStream outputStream = clientSocket.getOutputStream();

      // start the client loop
      while (!clientSocket.isClosed()) {
        // receive input
        System.out.print("send message: ");
        input = scanner.nextLine();

        // send the length of input first... then the message
        outputStream.write((byte) input.length());
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        outputStream.write(inputBytes);
        outputStream.flush();

        // close connection if receive "quit"
        if (input.equals("quit"))
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
