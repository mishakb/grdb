package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;
import GRTensorJServer.ServerAPI;

public class ICM_ExecuteTextSheet extends InterChangeModule {
    private String sheetname;
    private String dirname;
    private String result;

    public ICM_ExecuteTextSheet(String dirname, String sheetname) {
        this.dirname = dirname;
        this.sheetname = sheetname;
    }

    public void Execute(Server_ICM_Handler SessionManager) {
        ServerAPI sAPI = SessionManager.getAPI();
        result = sAPI.executeTextSheet(dirname, sheetname);
    }

    public String getResult() {
        return result;
    }
}
