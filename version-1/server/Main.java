import java.net.*;
import java.io.*;
import java.util.Scanner;

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
            // loop to receive inputs from user... (attempt to create a echo server first)
            while (true) {
                // receive message from client
                System.out.println("listening for message...");
                receivedMessage = inputStream.read();
                System.out.println("message receieved: " + receivedMessage);

                // if client sends quit message (-1) close server
                if (receivedMessage == 0)
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