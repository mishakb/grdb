package GRTensorJClient;

import GRTensorJICMs.*;
import java.util.Hashtable;

public class ClientAPI extends java.lang.Object {
    private Client_ICM_Handler ICM_Handler;
    private Hashtable CustomTextSheets = null;

    public ClientAPI() {}

    public String closeAlgebraicEngine() {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return "Not connected to server";
        }
        return ((ICM_CloseAlgebraicEngine)ICM_Handler.handle(new ICM_CloseAlgebraicEngine())).getResult();
    }

    // executeTextSheet
    public String executeTextSheet(String dirname, String sheetname) {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return "Not connected to server";
        }
        return ((ICM_ExecuteTextSheet)ICM_Handler.handle(new ICM_ExecuteTextSheet(dirname,sheetname))).getResult();
    }

    // executeCustomTextSheet
    public String executeCustomTextSheet(String Name) {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return "Not connected to the server";
        }
        return ((ICM_ExecuteCustomTextSheet)ICM_Handler.handle((ICM_ExecuteCustomTextSheet)CustomTextSheets.get(Name))).getResult();
    }

    // create a new textsheet
    //public String createTextSheet(String filename, String contents) {
    // if (ICM_Handler == null || !ICM_Handler.isLinkActive()) return "Not connected to the server.\n";
    // else return ((ICM_CreateTextSheet)ICM_Handler.handle(new ICM_CreateTextSheet(filename,contents))).getResult();
    //}

    public String createTextSheet(String Name, String Contents) {
        try {
            if (CustomTextSheets == null) CustomTextSheets = new Hashtable();
            CustomTextSheets.put(Name, new ICM_ExecuteCustomTextSheet(Name, Contents));
        }
        catch (Throwable e) {
            return "Error adding to custom Textsheets collection: " + e.getMessage();
        }
        return "New Custom Textsheet added: " + Name;
    }

    public boolean CustomTextSheetExists(String Name) {
        try {
            ICM_ExecuteCustomTextSheet temp = (ICM_ExecuteCustomTextSheet)CustomTextSheets.get(Name);
        }
        catch (Throwable e) {
            return false;
        }
        return true;
    }

    public String initiateLinkWithServer(String host_address, int host_port) {
        if (ICM_Handler != null && ICM_Handler.isLinkActive()) {
            return "Already connected to server";
        }
        ICM_Handler = new Client_ICM_Handler(host_address, host_port);
        if (ICM_Handler.isLinkActive()) {
            return "Established connection with server: " + openAlgebraicEngine();
        }
        return "Unable to establish connection with server";
    }

    public String openAlgebraicEngine() {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return "Not connected to the server";
        }
        return ((ICM_OpenAlgebraicEngine)ICM_Handler.handle(new ICM_OpenAlgebraicEngine())).getResult();
    }

    public String[] retrieveTextSheetDirNames() {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return null;
        }
        return ((ICM_RetrieveTextSheetDirNames)ICM_Handler.handle(new ICM_RetrieveTextSheetDirNames())).getResult();
    }
    public String[] retrieveTextSheetNames(String dirname) {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return null;
        }
        return ((ICM_RetrieveTextSheetNames)ICM_Handler.handle(new ICM_RetrieveTextSheetNames(dirname))).getResult();
    }
    public String terminateLinkWithServer() {
        if (ICM_Handler == null || !ICM_Handler.isLinkActive()) {
            return "Not connected to the server";
        }
        return closeAlgebraicEngine() + " " + ICM_Handler.closeLink();
    }
}
