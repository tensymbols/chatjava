package ru.ivanov;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Connection implements AutoCloseable{
    private InetAddress ip;
    private int port;
    private DatagramSocket socket;

    public InetAddress getIp() {
        return ip;
    }

    public DatagramSocket getSocket() {
        return socket;
    }
    public int getPort(){
        return port;
    }

    public Connection(String address, int port) throws Exception{
        this.port = port;
        this.ip = InetAddress.getByName(address);

        this.socket = new DatagramSocket();

        System.out.println( socket.getInetAddress());
    }
    @Override
    public void close() throws IOException {
        System.out.println("Closing connection!");
    }
}
