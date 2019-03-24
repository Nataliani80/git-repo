package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8080;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    boolean chatIsActiv = true;


    void openConnection() {
        try {
            Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("connection initialized");
        } catch (Exception exception) {
            exception.printStackTrace();
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
                                + "\n" + "Message from server: " + incomingMessage);
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
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
