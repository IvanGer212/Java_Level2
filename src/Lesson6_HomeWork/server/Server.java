package Lesson6_HomeWork.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready...");
            System.out.println("Waiting connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection success "+accept);
            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());
            new Thread(()->{
            while (true) {
                try {
                    String msg = in.readUTF();
                    System.out.println(msg);
                } catch (IOException e) {
                    System.out.println("Client switched off");
                    System.out.println("Press ENTER to close the program ");
                    break;
                    //e.printStackTrace();
                }

            }
            }).start();
            while (true){
                Scanner scanner = new Scanner(System.in);
                try {
                    out.writeUTF(scanner.nextLine());
                }
                catch (IOException e){
                    //e.printStackTrace();
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
