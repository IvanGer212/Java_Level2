package Lesson7_HomeWork.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatCommunication {
    DataInputStream in;
    DataOutputStream out;
    public ChatCommunication() {
            try {
                Socket socket = new Socket("localhost", 8080);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                /**new Thread(()->{
                    Scanner scanner = new Scanner(System.in);
                    while (true){
                        try {
                            out.writeUTF(scanner.nextLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                while (true){
                    System.out.println(in.readUTF());

                } */
            } catch (IOException e) {
                throw new RuntimeException("Error occurred during connection establishing.", e);
            }

        }

    public void transmit(String data) {
        try {
            out.writeUTF(data);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during data transmitting.", e);
        }
    }

    public String receive() {
        try {
            return in.readUTF();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during data receiving.", e);
        }
    }
}

