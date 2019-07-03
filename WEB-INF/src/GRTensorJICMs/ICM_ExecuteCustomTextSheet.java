package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;
import GRTensorJServer.ServerAPI;

public class ICM_ExecuteCustomTextSheet extends InterChangeModule {
    private String name;
    private String contents;
    private String result;

    public ICM_ExecuteCustomTextSheet(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public void Execute(Server_ICM_Handler SessionManager) {
        boolean gotit = false;
        try {
            ServerAPI sAPI = SessionManager.getAPI();
            gotit = true;
            this.result = sAPI.executeCustomTextSheet(this.name, this.contents);
        }
        catch (Throwable e) {
            System.out.println("Error in Execute: " + e + "\n Gotit: " + String.valueOf(gotit));
        }
    }

    public String getResult() {
        return this.result;
    }

    public String getName() {
        return this.name;
    }
}
