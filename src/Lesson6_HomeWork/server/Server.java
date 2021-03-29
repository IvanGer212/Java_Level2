package Lesson6_HomeWork.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
