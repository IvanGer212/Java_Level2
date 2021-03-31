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


    public ClientHandler(Socket socket, AuthenticationService authenticationService) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during client establishing",e);
        }

        doAuthentication(authenticationService);

    }

    private void doAuthentication(AuthenticationService authenticationService){
        while (true){
            try {

                String msg = in.readUTF();
                /**
                 -auth l1 p1
                 */
                if (msg.startsWith("-auth")){
                    String[] credentials = msg.split("\\s");
                    String login = credentials[1];
                    String password = credentials[2];
                    authenticationService.getEntryByCredentials(login, password)
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during client authentication",e);
            }

        }
    }
}
