package GRTensorJServer;

import java.io.*;
import java.net.*;

public class GRTensorJServer extends java.lang.Thread {
    public final static int DEFAULT_PORT = 4444;
    protected int port;
    protected ServerSocket listen_socket;

    public GRTensorJServer(int port) {
        if (port == 0) {
            port = DEFAULT_PORT;
        }
        this.port = port;
        try {
            listen_socket = new ServerSocket(port);
        }
        catch (IOException e) {
            System.err.println("GRTensorJServer: error while initiating server socket: " + e);
            System.exit(1);
        }
        System.out.println("GRTensorJServer: listening on port " + port);
        this.start();
    }

    public static void main(String[] args) {
        int port = 0;
        if (args.length == 1) {
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e) {
                port = 0;
            }
        }
        new GRTensorJServer(port);
    }

    public void run() {
        try {
            while(true) {
                Socket client_socket = listen_socket.accept();
                System.out.println("GRTensorJServer: connection established with client: " + client_socket.getRemoteSocketAddress().toString());
                new Server_ICM_Handler(client_socket);
            }
        }
        catch (IOException e) {
            System.err.println("GRTensorJServer: error while accepting client socket request: " + e);
            System.exit(1);
        }
    }
}
