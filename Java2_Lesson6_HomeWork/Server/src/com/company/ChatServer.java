package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    DataInputStream inputStream;
    DataOutputStream outputStream;

    void chatServer() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("server started");
            Socket socket = serverSocket.accept();
            System.out.println("client connected");

            try {
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
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
            outputStream.writeUTF("Message from server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
