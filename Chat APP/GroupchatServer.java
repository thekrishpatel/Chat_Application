import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

class Server {
    // Socket port for serrver
    private static final int SERVER_PORT = 7778;
    // To manage all people who joined chat
    private static final List<BufferedWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running...");
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                clientWriters.add(out);

                String name;
                name = in.readLine();
                broadcastMessage(name + " has joined the chat.");

                String message;
                while (!(message = in.readLine()).equalsIgnoreCase("Bye")) {
                    System.out.println(name + ": " + message);
                    broadcastMessage(name + ": " + message);
                }

                System.out.println(name + " has left the chat.");
                broadcastMessage(name + " has left the chat.");
            } catch (IOException e) {
                // e.printStackTrace();
            } finally {
                if (out != null) {
                    clientWriters.remove(out);
                    try {
                        out.close();
                    } catch (IOException e) {
                        // e.printStackTrace();
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            for (BufferedWriter writer : clientWriters) {
                try {
                    writer.write(message + "\n");
                    writer.flush();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        }
    }
}
