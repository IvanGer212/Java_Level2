package Lesson7_HomeWork.server;

import Lesson7_HomeWork.client.ChatStarter;

public class ClientTwo {
    public static void main(String[] args) {
        ChatStarter.run("localhost", 8080);
    }
}
