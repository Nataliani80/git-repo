package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageWindow extends JFrame {

    public MessageWindow() {
        setTitle("Messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        
        JPanel correspondenceField = new JPanel();
        correspondenceField.setBackground(Color.LIGHT_GRAY);
        correspondenceField.setLayout(new BoxLayout(correspondenceField, BoxLayout.Y_AXIS));
        add(correspondenceField, BorderLayout.CENTER);

        JTextArea messages = new JTextArea();
        messages.setBackground(Color.LIGHT_GRAY);
        messages.setEditable(false);
        JScrollPane jsp = new JScrollPane(messages);
        correspondenceField.add(jsp);

        JPanel inputMessageContainer = new JPanel();
        inputMessageContainer.setBackground(Color.WHITE);
        add(inputMessageContainer, BorderLayout.PAGE_END);
        inputMessageContainer.setPreferredSize(new Dimension(400,60));
        inputMessageContainer.setLayout(new BoxLayout(inputMessageContainer, BoxLayout.X_AXIS));

        JTextField inputMessage = new JTextField();

        JButton sendButton = new JButton("Отправить");
        inputMessageContainer.add(inputMessage);
        inputMessageContainer.add(sendButton);

        inputMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.append(inputMessage.getText() + "\n\r");
                inputMessage.setText(null);
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.append(inputMessage.getText() + "\n\r");
                inputMessage.setText(null);
            }
        });

        setVisible(true);
    }
}
