package GRTensorJServer;

import java.net.*;
import java.io.*;
import GRTensorJICMs.InterChangeModule;

public class Server_ICM_Handler extends java.lang.Thread {
    private Socket client;
    private ServerAPI API = new ServerAPI();
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Server_ICM_Handler (Socket client_socket) {
        this.client = client_socket;
        try {
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
        }
        catch (IOException e) {
            try {
                client.close();
            }
            catch (IOException e2) {
                System.err.println("ServerICM: unable to close client: " + e2);
            }
            System.err.println("ServerICM: error while getting socket streams: " + e);
        }
        this.start();
    }

    public void endSession() {
        try {
            client.close();
            System.out.println("ServerICM: client session terminated");
        }
        catch (IOException e2) {
            // System.out.println(e2);
            System.err.println("ServerICM: unable to close client: " + e2);
        }
        if (API.closeAlgebraicEngine()) {
            System.out.println("ServerICM: algebraic engine session closed");
        }
        this.stop();
    }

    public ServerAPI getAPI() {
        return this.API;
    }

    public void run() {
        InterChangeModule ICM;
        while (true) {
            try {
                if (in == null) {
                    endSession();
                }
                else {
                    ICM = (InterChangeModule) in.readObject();
                    System.out.println("ServerICM: executing ICM: " + ICM);
                    ICM.Execute(this);
                    out.writeObject(ICM);
                }
            }
            catch (Exception e) {
                System.err.println("ServerICM: error while executing client request: " + e);
                endSession();
            }
        }
    }
}
