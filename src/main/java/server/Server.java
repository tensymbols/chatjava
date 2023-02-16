package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

    private DatagramSocket socket;

    private List<ServerClient> clients = new ArrayList<>();


    boolean running = false;



    private Thread run, process, send, receive;


    private int port;
    public Server(int port){
        this.port = port;

        try {
            socket = new DatagramSocket(port, InetAddress.getByName("localhost"));
            System.out.println(socket.getLocalPort());
            System.out.println( socket.getLocalSocketAddress());
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }

        run = new Thread(this, "server");
        run.start();
        System.out.println("server has started");
    }

    @Override
    public void run() {
        running = true;
        processClients();
        receive();
    }

    private void processClients(){
        process = new Thread("Clients"){
            public void run(){
                while(running){

                }
            }
        };
        process.start();
    }
    private void receive(){
        receive = new Thread("Receive"){
            public void run (){
                while(running){
                    System.out.println("Receiving...");
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length);

                    try {
                        socket.receive(packet);
                    }
                    catch (Exception e){
                        System.out.println("+");
                    }

                    process(packet);
                    clients.add(new ServerClient("name",packet.getAddress() ,packet.getPort(), 228));

                    //System.out.println(s);
                    System.out.println(clients.size());
                }
            }
        };
        receive.start();
    }

    private void process(DatagramPacket packet) {
        String s = new String(packet.getData(), packet.getOffset(), packet.getLength());
        if(s.startsWith("/c/")) System.out.println("");
        if(s.startsWith("/d/")) ;
    }

    private void print(String s){

    }




}
