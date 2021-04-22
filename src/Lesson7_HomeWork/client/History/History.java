package Lesson7_HomeWork.client.History;

import java.io.*;

public class History {

    public void doFileWriter(String msg, int numOfClient) {
        File file = new File(String.format("C:\\Users\\admin\\IdeaProjects\\Java_Level2\\src\\Lesson7_HomeWork\\Client%s\\ChatHistory%s.txt",numOfClient,numOfClient));
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(msg);
            fw.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLastNLines(File file) {
        int readLines = 0;
        StringBuilder sb = new StringBuilder();

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long fileLength = file.length() - 1;
            raf.seek(fileLength);

            for (long ptr = fileLength; ptr >= 0 ; ptr--) {
                raf.seek(ptr);
                char ch = (char) raf.readByte();
                if (ch == '\n') {
                    readLines++;
                    if (readLines == 100) {
                        break;
                    }
                }
                sb.append(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sb.reverse();
        return sb.toString();

    }
}
