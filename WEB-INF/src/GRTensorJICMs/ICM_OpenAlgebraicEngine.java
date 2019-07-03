package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;

public class ICM_OpenAlgebraicEngine extends InterChangeModule {
    private String result;

    public void Execute(Server_ICM_Handler SessionManager) {
        if (SessionManager.getAPI().openAlgebraicEngine()) {
            result = "Algebraic engine opened successfully.";
        }
        else {
            result = "Unable to open algebraic engine.";
        }
    }

    public String getResult() {
        return result;
    }
}
