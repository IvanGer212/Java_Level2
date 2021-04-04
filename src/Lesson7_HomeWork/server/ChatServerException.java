package Lesson7_HomeWork.server;

public class ChatServerException extends RuntimeException {
    public ChatServerException(String message) {
        super(message);
    }

    public ChatServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
