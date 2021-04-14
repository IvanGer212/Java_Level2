package Lesson7_HomeWork.server;

import Lesson7_HomeWork.DB.Users_Repository;

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
            while (true) {
                System.out.println("Waiting connection...");
                Socket clientSocked = socket.accept();
                System.out.println("Connection success " + clientSocked);
                new ClientHandler(clientSocked, this);
            }
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

    public void privatSendMessage(String msg, String name,String nameClient){
        int count=0;
        for (ClientHandler clientHandler: loggedClient) {
            if (clientHandler.getName().equals(name)){
                clientHandler.sendMessage(msg);
                count++;
            }
        }
        if (count==0) {
            for (ClientHandler clientHandler: loggedClient) {
                if (clientHandler.getName().equals(nameClient)){
                   clientHandler.sendMessage("Client with this name not logged or absent");
                }
            }
        }
    }

    /**public void changeClienName (String name) {
        Users_Repository users_repository = new Users_Repository();
        for (ClientHandler clientHandler : loggedClient) {
            if (clientHandler.getName().equals(name)) {
                users_repository.update(authenticationService.get());
            }
        }
    }
     */
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