package Lesson7_HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    String name;

    public String getName() {
        return name;
    }

    public ClientHandler(Socket socket, Server server) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during client establishing",e);
        }

        doAuthentication(server);

    }

    private void doAuthentication(Server server){
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
                            break;
                        } else{
                            sendMessage(String.format("User with name %s is already logged",credentials.getName()));
                        }
                    }
                    else {
                        sendMessage("Incorrect login or password");
                    }
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during client authentication",e);
            }

        }
    }

    public void receivedMessage(){

    }
    public void sendMessage(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending a message.");
        }

    }
}
