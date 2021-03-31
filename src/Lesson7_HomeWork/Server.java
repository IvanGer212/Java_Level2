package Lesson7_HomeWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final AuthenticationService authenticationService;

    public Server() {
        try {
            authenticationService = new AuthenticationService();
            ServerSocket socket = new ServerSocket(8080);
            Socket clientSocked = socket.accept();
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong", e);
        }

    }
}