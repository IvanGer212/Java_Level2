package Lesson7_HomeWork.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private final AuthenticationService authenticationService;
    private final Set<ClientHandler> loggedClient;

    public Server() {
        try {
            authenticationService = new AuthenticationService();
            loggedClient = new HashSet<>();
            ServerSocket socket = new ServerSocket(8080);
            System.out.println("Server is ready...");
            System.out.println("Waiting connection...");
            Socket clientSocked = socket.accept();
            System.out.println("Connection success "+clientSocked);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong", e);
        }

    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public void subscribe(ClientHandler clientHandler){
        loggedClient.add(clientHandler);
    }

    public void unsubscribe (ClientHandler clientHandler){
        loggedClient.remove(clientHandler);
    }

    public void broadcast(String msg){
        for (ClientHandler clientHandler: loggedClient) {
            clientHandler.sendMessage(msg);

        }

    }

    public boolean isLoggedIn(String name){
       return loggedClient.stream()
                    .filter(client->client.getName().equals(name))
                    .findFirst().isPresent();
        /**Iterator<ClientHandler> iterator = loggedClient.iterator();
        while (iterator.hasNext()){
            ClientHandler client = iterator.next();
            if (client.getName.equals(name)){
                return true;
            }
        }
        return false;
    */
    }
}