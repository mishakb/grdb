package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;
import GRTensorJServer.ServerAPI;

public class ICM_RetrieveTextSheetNames extends InterChangeModule {
    private String dirname;
    private String[] result;

    public ICM_RetrieveTextSheetNames(String dirname) {
        this.dirname = dirname;
    }

    public void Execute(Server_ICM_Handler SessionManager) {
        ServerAPI sAPI = SessionManager.getAPI();
        result = sAPI.getTextSheetNames(dirname);
    }

    public String[] getResult() {
        return result;
    }
}
