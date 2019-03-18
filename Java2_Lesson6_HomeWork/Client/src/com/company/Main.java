package com.company;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();
        client.openConnection();
        client.initReceiver();
        while (true) {
            client.processMessage();
        }
    }
}
