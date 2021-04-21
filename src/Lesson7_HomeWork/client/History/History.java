package Lesson7_HomeWork.client.History;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class History {
    public void doFileOutputStream(String message) {
        File file = new File("C:\\Users\\admin\\IdeaProjects\\Java_Level2\\src\\Lesson7_HomeWork\\client\\History\\ChatHistory.txt");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(message.getBytes());
            fos.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doFileWriter(String msg, int numOfClient) {
        File file = new File(String.format("C:\\Users\\admin\\IdeaProjects\\Java_Level2\\src\\Lesson7_HomeWork\\Client%s\\ChatHistory%s.txt",numOfClient,numOfClient));
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(msg);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
