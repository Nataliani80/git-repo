package com.company;

public class Main {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.chatServer();
        chatServer.initReceiver();
        chatServer.processMessage();

    }
}
