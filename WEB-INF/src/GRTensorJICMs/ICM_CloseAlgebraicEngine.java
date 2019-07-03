package GRTensorJICMs;

import GRTensorJServer.Server_ICM_Handler;

public class ICM_CloseAlgebraicEngine extends InterChangeModule {
    private String result;

    public void Execute(Server_ICM_Handler SessionManager) {
        if (SessionManager.getAPI().closeAlgebraicEngine()) {
            result = "Algebraic engine closed successfully.";
        }
        else {
            result = "Unable to close algebraic engine.";
        }
    }

    public String getResult() {
        return result;
    }
}
