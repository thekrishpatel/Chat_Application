import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final String SERVER_IP = "192.168.0.124";
        final int SERVER_PORT = 7778;
        try (Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                Scanner sc = new Scanner(System.in);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            Thread sender = new Thread(() -> {
                while (true) {
                    String msg = sc.nextLine();
                    try {
                        if (msg.equalsIgnoreCase("Bye"))
                            System.exit(0);
                        out.write(msg);
                        out.newLine();
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            sender.start();

            Thread receiver = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        if (msg.equalsIgnoreCase("Bye")) {
                            System.out.println("Server says: byeeeeee");
                            System.exit(0);
                        }
                        System.out.println("Server says: " + msg);
                    }
                    System.out.println("Server out of service");
                } catch (IOException e) {
                    System.out.println("Server Disconnected");
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