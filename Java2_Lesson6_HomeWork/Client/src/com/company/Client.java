package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8080;
    DataInputStream inputStream;
    DataOutputStream outputStream;

    void openConnection() {
        try {
            Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("connection initialized");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    void initReceiver() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String incomingMessage = inputStream.readUTF();
                    System.out.println(incomingMessage);
                    if (incomingMessage.equalsIgnoreCase("/end")) {
                        System.out.println("Chat is closed");
                        break;
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    void processMessage() {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        if(!message.equals(" ")) {
            sendMessage(message);
        }

    }

    void sendMessage(String message) {
        try {
            outputStream.writeUTF("Message from client: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
