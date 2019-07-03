package GRTensorJICMs;

import java.io.*;
import GRTensorJServer.Server_ICM_Handler;
import GRTensorJServer.ServerAPI;

public class ICM_CreateTextSheet extends InterChangeModule {
    private String filename;
    private String contents;
    private String result;

    public ICM_CreateTextSheet(String filename, String contents) {
        this.filename = filename;
        this.contents = contents;
    }

    public void Execute(Server_ICM_Handler SessionManager) {
        ServerAPI sAPI = SessionManager.getAPI();
        try {
            result = sAPI.createTextSheet(filename, contents);
        }
        catch (IOException e) {
            System.out.println("IOError while creating  " + "Custom/" + filename + "." + ".ts");
        }
    }

    public String getResult() {
        return result;
    }
}
