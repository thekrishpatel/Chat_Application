# Chat Application

Welcome to the Chat Application repository! This project enables real-time text-based communication between users over a network. It's built using Java and socket programming, providing a practical introduction to networking, multi-threading, and error handling.

## Features

- **Seamless Connection:** Establish a connection between two computers for instant communication.
- **User-Friendly Interface:** Enjoy an intuitive interface for sending and receiving messages.
- **Real-Time Communication:** Messages are delivered instantly, creating a smooth and responsive chat experience.
- **Two-Way Communication:** Engage in two-way conversations with the other user.
- **Simple Setup:** Run the Java program on two computers, connecting through IP addresses and port numbers.
- **Multi-Threaded:** Multi-threading ensures concurrent handling of message sending and receiving.
- **Error Handling:** The application gracefully handles disconnections and network issues.

## How It Works

1. **Server:** One computer acts as the server, listening for incoming connections on a specified port.
2. **Client:** The second computer acts as the client, initiating a connection to the server's IP address and port number.
3. **Connection Established:** Both client and server exchange messages through input and output streams.
4. **Real-Time Chatting:** Users can send messages and see them appear on the other end in real-time.

## Usage

1. Clone this repository to your local machine.
2. Compile and run the `Server.java` file on one computer.
3. Compile and run the `Client.java` file on another computer.
4. Enter the server's IP address and port number in the client application to establish a connection.
5. Start chatting in real-time!

## Group Chat (Additional Feature)

This repository also includes a group chat feature that allows multiple users to join a chat room and communicate simultaneously. Here's how it works:

1. **Server:** One computer acts as the server, hosting the chat room.
2. **Clients:** Multiple clients can connect to the server's IP address and port number.
3. **Group Chat:** Users can send messages to the chat room, and all connected clients will receive and display the messages.

## Contributing

If you're interested in contributing to this project or exploring the code further, feel free to fork this repository and create a pull request. Your contributions are highly appreciated!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Created by Krish Patel
