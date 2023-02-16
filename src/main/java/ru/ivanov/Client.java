/*
 * Created by JFormDesigner on Thu Jan 19 04:48:08 MSK 2023
 */

package ru.ivanov;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serial;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.*;

/**
 * @author user
 */
public class Client extends JFrame {
    @Serial
    private static final long serialVersionUID = 5784232972407154498L;
    private Connection connection;

    private String address;
    private String name;

    private Thread send;

    private int port;
    public Client(String name, String address, int port) throws Exception {
        setSize(800,600);

        try {
            connection = new Connection(address, port);
        }
        catch (Exception e){
            System.err.println("Couldn't create connection!");
            return;
        }


        this.name = name;
        this.address = address;
        this.port = port;
        initComponents();
        send((name+" connected from "+address).getBytes() );
    }
    private String receive(){
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        try {

            connection.getSocket().receive(packet);
        }
        catch (Exception e){

        }
        return new String(packet.getData());
    }
    private void send(final byte[] data){
        send = new Thread("Send") {
            @Override
            public void run() {
                DatagramPacket packet = new DatagramPacket(data, data.length, connection.getIp(), connection.getPort());

                try
                {
                    connection.getSocket().send(packet);
                    System.out.println(new String(data));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
        send.start();
    }


    public void write(String msg){
        txtChat.append(msg+"\n");
    }
    private void print(){
        String msg = txtMessage.getText();
        if(msg.startsWith("/")) {
            processCommand(msg);
            txtMessage.setText("");
            return;
        }
        if(txtMessage.getText().length()>0){
            write(txtMessage.getText());
            send(txtMessage.getText().getBytes());
        }
        txtMessage.setText("");
    }

    private void processCommand(String s){
        switch(s){
            case "/exit":
                dispose();
                break;
            case "/help":
                write("There is no help.");
                break;
            default:
                write("No such command. use /help");
                break;

        }
    }


    private void btnSend(ActionEvent e) {
        print();
    }

    private void btnClear(ActionEvent e) {
        txtChat.setText("");
    }

    private void txtMessageKeyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            print();
        }
    }

    private void txtMessage(ActionEvent e) {
        // TODO add your code here
    }

    private void thisWindowClosed(WindowEvent e) {
        JFrame j = (JFrame)e.getSource();
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        txtChat = new JTextArea();
        btnClear = new JButton();
        txtMessage = new JTextField();
        btnSend = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 575, 99, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {49, 45, 336, 27, 34, 31, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== scrollPane1 ========
        {

            //---- txtChat ----
            txtChat.setEditable(false);
            scrollPane1.setViewportView(txtChat);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- btnClear ----
        btnClear.setText("Clear");
        btnClear.addActionListener(e -> btnClear(e));
        contentPane.add(btnClear, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- txtMessage ----
        txtMessage.addActionListener(e -> txtMessage(e));
        txtMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                txtMessageKeyPressed(e);
            }
        });
        contentPane.add(txtMessage, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- btnSend ----
        btnSend.setText("Send");
        btnSend.addActionListener(e -> btnSend(e));
        contentPane.add(btnSend, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        setVisible(true);
        setLocationRelativeTo(null);
        txtChat.setFont(txtChat.getFont().deriveFont(16.0f));
        txtMessage.setFont(txtChat.getFont().deriveFont(14.0f));
        txtMessage.requestFocusInWindow();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTextArea txtChat;
    private JButton btnClear;
    private JTextField txtMessage;
    private JButton btnSend;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
