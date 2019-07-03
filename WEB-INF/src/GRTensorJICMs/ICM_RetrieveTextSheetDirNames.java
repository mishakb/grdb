package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;

public class ICM_RetrieveTextSheetDirNames extends InterChangeModule {
    private String[] result;

    public void Execute(Server_ICM_Handler SessionManager) {
        result = SessionManager.getAPI().getTextSheetDirNames();
    }

    public String[] getResult() {
        return result;
    }
}
