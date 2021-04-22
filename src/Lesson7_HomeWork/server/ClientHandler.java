package Lesson7_HomeWork.server;

import Lesson7_HomeWork.DB.Users_Repository;
import Lesson7_HomeWork.client.History.History;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import java.util.TimerTask;
import java.util.Timer;



public class ClientHandler {
    private static final long TIMEOUT_TIMER = 100000;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;
    String name;
    private final History history = new History();

    public String getName() {
        return name;
    }

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during client establishing",e);
        }

        TimerTask timeout = new TimerTask() {
            @Override
            public void run() {
                if(!server.isLoggedIn(name)){
                    sendMessage("Timeout authentication. Please try to connect later.");
                    closeConnection(true);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timeout, TIMEOUT_TIMER);

        new Thread(()->{
        doAuthentication();
        listen();})
                .start();

    }

    public void listen(){
            receivedMessage();
    }

    private void doAuthentication(){
        sendMessage("Welcome! Please do authentication.");
        while (true){
            try {

                String msg = in.readUTF();
                /**
                 -auth l1 p1
                 */
                if (msg.startsWith("-auth")){
                    String[] credentialsStruct = msg.split("\\s");
                    String login = credentialsStruct[1];
                    String password = credentialsStruct[2];
                    Optional<AuthenticationService.Entry> mayBeCredentials = server.getAuthenticationService()
                            .getEntryByCredentials(login, password);

                    if (mayBeCredentials.isPresent()){
                        AuthenticationService.Entry credentials = mayBeCredentials.get();
                        if (!server.isLoggedIn(credentials.getName())){
                            name = credentials.getName();
                            server.broadcast(String.format("User[%s] entered the chat", name));
                            server.subscribe(this);
                            int id = credentials.getId();
                            sendMessage(history.readLastNLines(new File("C:\\Users\\admin\\IdeaProjects\\Java_Level2\\src\\Lesson7_HomeWork\\Client1\\ChatHistory1.txt")));

                            break;
                        } else{
                            sendMessage(String.format("User with name %s is already logged",credentials.getName()));
                        }
                    }
                    else {
                        sendMessage("Incorrect login or password");
                    }
                }
                else {
                    sendMessage("Authentication incorrect. \nPlease use valid command (-auth your_login your_password)");
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during client authentication",e);
            }

        }
    }

    public void receivedMessage(){
        while (true){
            try {
                String msg = in.readUTF();
                if (msg.startsWith("/w")){
                    StringBuilder concatMsg = new StringBuilder();
                    String[] privatMsg = msg.split("\\s");
                    String destinationName = privatMsg[1];
                    for (int i = 2; i < privatMsg.length; i++) {
                        concatMsg.append(privatMsg[i]+" ");
                    }
                    server.privatSendMessage(String.format("[priv] User %s: %s",name,concatMsg.toString()),destinationName,this.name);
                }
                else if (msg.startsWith("-ChangeName")){
                    // Command : -ChangeName Name1 to Name2
                    String[] changeNameCommand = msg.split("\\s");
                    String oldName = changeNameCommand[1];
                    String newName = changeNameCommand[3];
                    if (!server.changeClientName(oldName, newName)){
                        this.sendMessage(String.format("User with name %s not find",oldName));
                    }
                }
                else {
                server.broadcast(String.format("User %s: %s",name,msg));
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during receiving a message.",e);
            }
        }
    }
    public void sendMessage(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending a message.");
        }

    }

    public void closeConnection(boolean timeout) {
        server.unsubscribe(this);
        if(!timeout){
            server.broadcast(name + " вышел из чата");
        }
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHistory(String msg){
        Users_Repository users_repository = new Users_Repository();
        Optional<AuthenticationService.Entry> entryFromName = users_repository.findEntryFromName(this.getName());
        history.doFileWriter(msg,entryFromName.get().getId());
    }

    public void readHistory(String msg){
        sendMessage(msg);
    }
}
