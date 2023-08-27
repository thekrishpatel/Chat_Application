import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7778);
                Socket clientSocket = serverSocket.accept();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Scanner sc = new Scanner(System.in)) {

            Thread sender = new Thread(() -> {
                while (true) {
                    String msg = sc.nextLine();
                    try {
                        out.write(msg);
                        out.newLine();
                        out.flush();
                    } catch (IOException e) {
                    }
                }
            });
            sender.start();

            Thread receiver = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        if (msg.equals("Bye")) {
                            System.exit(0);
                        }
                        System.out.println("Client: " + msg);
                    }
                    System.out.println("Client Disconnected");
                } catch (IOException e) {
                    System.out.println("Client Disconnected");
                }
            });
            receiver.start();
            sender.join();
            receiver.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}