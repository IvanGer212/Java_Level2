package Lesson6_HomeWork.client;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(){
        try {
            Socket socket = new Socket("127.0.0.1",8080);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        //e.printStackTrace();
                        System.out.println("Server is off");
                        System.out.println("Connection closed");
                        break;
                    }
                }
            }).start();

            while (true){
                try {
                String msg = new String();
                msg = in.readUTF();
                System.out.println(msg);
                }
                catch (IOException e){
                System.out.println("Channel closed");
                break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
