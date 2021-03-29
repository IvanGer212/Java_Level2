package Lesson6_HomeWork.client;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    Client(){
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
