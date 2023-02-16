package server;

public class ServerMain {
    private int port;
    private Server server;

    public ServerMain(int port){
        this.port = port;

        server = new Server(port);

    }
    public static void main(String[] args){
        int port;
        if(args.length >1){
            System.out.println("Use java -jar <filename>.jar [port]");
        }
        if(args.length>0) port = Integer.parseInt(args[0]);
        else port = 7777;
        new ServerMain(port);
    }
}
