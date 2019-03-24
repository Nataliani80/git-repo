package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class ChatServer {

    DataInputStream inputStream;
    DataOutputStream outputStream;
    boolean chatIsActiv = true;

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
            while (chatIsActiv) {
                try {
                    String incomingMessage = inputStream.readUTF();
                    if (incomingMessage.equalsIgnoreCase("/end")) {
                        System.out.println("Chat is closed");
                        chatIsActiv = false;
                    } else {
                        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())
                                + "\n" + "Message from client: " + incomingMessage);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    chatIsActiv = false;
                }
            }
            System.exit(0);
        });
        thread.start();
    }


    void processMessage() {
        while (chatIsActiv) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("/end")) {
                sendMessage(message);
                System.out.println("Chat is closed");
                chatIsActiv = false;
            } else if(!message.equals("")) {
                sendMessage(message);
            }
        }
        System.exit(0);
    }

    private void sendMessage(String message) {
        try {
            outputStream.writeUTF( message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
