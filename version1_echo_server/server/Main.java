import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // created to receive input from user...
        Scanner scanner = new Scanner(System.in);
        int receivedMessage = 0;
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            System.out.println("client connected: " + socket.toString());

            // define inputstream
            InputStream inputStream = socket.getInputStream();
            // loop to receive inputs from user...
            while (true) {
                // receive message from client
                System.out.println("listening for message...");
                // take in the length of the message first
                receivedMessage = inputStream.read();
                byte[] messageBytes = new byte[receivedMessage];

                // receive the rest of message and convert into string
                receivedMessage = inputStream.read(messageBytes, 0, messageBytes.length);
                String messageString = new String(messageBytes, StandardCharsets.UTF_8);
                System.out.println("message receieved: " + messageString);

                // if client sends "quit" message close server
                if (messageString.equals("quit"))
                    break;
            }

            serverSocket.close();
            System.out.println("server closed");
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
}