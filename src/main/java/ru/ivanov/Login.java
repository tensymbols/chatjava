/*
 * Created by JFormDesigner on Thu Jan 19 01:28:16 MSK 2023
 */

package ru.ivanov;

import java.awt.*;
import java.awt.event.*;
import java.io.Serial;
import javax.swing.*;

/**
 * @author user
 */
public class Login extends JFrame  {
    @Serial
    private static final long serialVersionUID = -470263503702599534L;



    public Login() throws Exception{
        setSize(800,600);
        setVisible(true);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
        initComponents();

    }

    private void login(String name, String ip, String port){


        int port_;
        try{
            port_ = Integer.parseInt(port);
            JFrame client = new Client(name, ip, port_);
        }catch (Exception e){
            System.out.println("Wrong data or unable to create client");
            return;
        }

        dispose();

    }

    private void btnSend(ActionEvent e) {
        login(txtName.getText(), txtIP.getText(), txtPort.getText());

    }

    private void btnSend() {
        // TODO add your code here
    }

    private void txtName(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
            label1 = new JLabel();
            txtName = new JTextField();
            label2 = new JLabel();
            txtIP = new JTextField();
            label3 = new JLabel();
            txtPort = new JTextField();
            btnSend = new JButton();

            //======== this ========
            setResizable(false);
            var contentPane = getContentPane();

            //---- label1 ----
            label1.setText("Name:");

            //---- txtName ----
            txtName.addActionListener(e -> txtName(e));

            //---- label2 ----
            label2.setText("IP address:");

            //---- txtIP ----
            txtIP.setText("127.0.0.1");

            //---- label3 ----
            label3.setText("Port:");

            //---- txtPort ----
            txtPort.setText("7777");

            //---- btnSend ----
            btnSend.setText("Less go");
            btnSend.addActionListener(e -> {
			btnSend();
			btnSend(e);
		});

            GroupLayout contentPaneLayout = new GroupLayout(contentPane);
            contentPane.setLayout(contentPaneLayout);
            contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIP, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPort, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSend))
                        .addContainerGap(42, Short.MAX_VALUE))
            );
            contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(txtIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label3)
                            .addComponent(txtPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(btnSend)
                        .addContainerGap(8, Short.MAX_VALUE))
            );
            pack();
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField txtName;
    private JLabel label2;
    private JTextField txtIP;
    private JLabel label3;
    private JTextField txtPort;
    private JButton btnSend;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        try{

            JFrame login = new Login();


        }
        catch (Exception e){

        }
    }
}
