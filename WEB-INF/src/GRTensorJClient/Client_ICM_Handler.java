package GRTensorJClient;

import java.io.*;
import java.net.*;
import GRTensorJICMs.InterChangeModule;

public class Client_ICM_Handler extends java.lang.Object {
    private String server_address;
    private int server_port;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean link_status = false;

    public Client_ICM_Handler(String server_address, int server_port) {
        this.server_address = server_address;
        this.server_port = server_port;
        try {
            Socket s = new Socket(server_address, server_port);
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
            link_status = true;
        }
        catch (IOException e) {
            System.err.println("ClientICM: unable to establish connection with server: " + e);
            link_status = false;
        }
    }

    public String closeLink() {
        if (!isLinkActive()) {
            return "ClientICM: not connected to server";
        }
        else {
            try {
                out.close();
                in.close();
                link_status = false;
                return "ClientICM: connection to server terminated";
            }
            catch (Exception e) {
                return e.toString();
            }
        }
    }

    public InterChangeModule handle(InterChangeModule aICM) {
        try {
            out.writeObject(aICM);
            aICM = (InterChangeModule) in.readObject();
        }
        catch (Throwable e) {
            System.err.println("ClientICM: error while handling ICM: " + e);
        }
        return aICM;
    }

    public boolean isLinkActive() {
        return this.link_status;
    }
}
