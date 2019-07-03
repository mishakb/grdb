package GRTensorJServer;

import java.util.*;
import java.io.*;

public class ServerAPI extends java.lang.Object {
    public final static String TextSheetExt = "ts";
    public final static String TextSheetsDir = "/usr/local/src/grdb/GRTensorJ2/TextSheets/";
    private final static String MapleExecCmd = "maple";
    private boolean continueReadingTextsheet = true;
    private boolean addThisMessageToResult = true;
    private Process Engine = null;
    private BufferedReader fromEngine = null;
    private PrintWriter toEngine = null;

    public boolean closeAlgebraicEngine() {
        if (isEngineOpen()) {
            toEngine.println("quit;");
            try {
                Engine.waitFor();
            }
            catch (InterruptedException e) {
                return false;
            }
            Engine.destroy();
            Engine = null;
            if (!isEngineOpen()) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /*
     * executeTextSheet
     * @parameter: sheetname
     * @parameter: dirname
     */
    public String executeTextSheet(String dirname, String sheetname) {
        if (!isEngineOpen() || !isEngineLinkAvailable()) {
            if (!openAlgebraicEngine()) {
                return "ServerAPI: error occured while opening algebraic engine";
            }
        }

        try {
            FileReader fromTxtSheet = new FileReader(TextSheetsDir + dirname + "/" + sheetname + "." + TextSheetExt);
            int firstchar = 0;
            int nextchar = 0;
            String line = "";
            String total_result = "";
            String temp = "";
            boolean comment = false;
            boolean display = false;
            continueReadingTextsheet = true;
            addThisMessageToResult = false;

            try {
                firstchar = fromTxtSheet.read();
                while (firstchar != -1 && nextchar != -1 && continueReadingTextsheet) {
                    // System.out.println("continue ... " + continueReadingTextsheet);
                    line = "";
                    comment = false;
                    display = false;
                    //  System.out.println("first: " + (char)firstchar);
                    // this decides what to do with the txtsheet line:
                    if ((char)firstchar == '#') {
                        comment = true;
                    }
                    else if ((char)firstchar == '*') {
                        display = true;
                    }
                    else {
                        line = line + (char)firstchar;
                    }
                    // this reads in the line:
                    nextchar = fromTxtSheet.read();
                    while (nextchar > 13 ) {
                        line = line + (char)nextchar;
                        //   System.out.println((char)nextchar);
                        nextchar = fromTxtSheet.read();
                    }
                    if (comment) {
                        total_result = total_result + line + "\n";
                    }
                    else if (display) {
                        total_result = total_result + submitCmdToEngine(line);
                    }
                    else {
                        temp =  submitCmdToEngine(line);
                        if (addThisMessageToResult) {
                            total_result = total_result + temp;
                            addThisMessageToResult = false;
                        }
                    }
                    // temp is a dummy variable to store the result
                    // submitCmd... outputs a result whether displayed or not

                    // this code is necessary to filter out carriage returns
                    // and line feeds...it will handle any number of them.
                    firstchar = nextchar;
                    while (firstchar < 14 && firstchar != -1) {
                        // System.out.println("skip2: " + firstchar);
                        firstchar = fromTxtSheet.read();
                    }
                }
            }
            catch (IOException e) {
                return "ServerAPI: IOError while reading file " + TextSheetsDir + dirname + "/" + sheetname + "." + TextSheetExt;
            }
            finally {
                if (!continueReadingTextsheet) {
                    return temp + "\n" + " Error in : " + TextSheetsDir + dirname + "/" + sheetname + "." + TextSheetExt;
                }
                else {
                    return total_result;
                }
            }
        }
        catch (FileNotFoundException e) {
            return "ServerAPI: file not found: " + TextSheetsDir + dirname + "/" + sheetname + "." + TextSheetExt;
        }
    }

    /*
     * executeCustomTextSheet
     * @parameter: sheetName
     * @parameter: contents
     */
    // ALT 3
    public String executeCustomTextSheet(String sheetName, String contents) {
        if (!isEngineOpen() || !isEngineLinkAvailable()) {
            if (!openAlgebraicEngine()) {
                return "ServerAPI: error occured while opening algebraic engine";
            }
        }

        int firstchar = 0;
        int nextchar = 0;
        int i = 0;
        String line = "";
        String total_result = "";
        boolean comment = false;
        boolean display = false;

        try {
            firstchar = contents.charAt(i);
            while (i < contents.length()) {
                line = "";
                comment = false;
                display = false;
                //   System.out.println("first: " + (char)firstchar);
                // this decides what to do with the txtsheet line:
                if ((char)firstchar == '#') {
                    comment = true;
                }
                else if ((char)firstchar == '*') {
                    display = true;
                }
                else {
                    line = line + (char)firstchar;
                }
                // this reads in the line:
                i = i + 1;
                if (i < contents.length()) {
                    nextchar = contents.charAt(i);
                }
                while (nextchar > 13 && i < contents.length()) {
                    line = line + (char)nextchar;
                    //    System.out.println((char)nextchar);
                    i = i + 1;
                    if (i < contents.length()) nextchar = contents.charAt(i);
                }
                if (comment) {
                    total_result = total_result + line + "\n";
                    System.out.println("Comment: " + line);
                }
                else if (display) {
                    String turd = submitCmdToEngine(line);
                    total_result = total_result + turd;
                    System.out.println("Display: " + line);
                    System.out.println("Result: " + turd);
                }
                else {
                    System.out.println("Temp: " + line);
                    String temp = submitCmdToEngine(line);
                    System.out.println("Result: " + temp);
                }
                // temp is a dummy variable to store the result
                // submitCmd... outputs a result whether displayed or not
                // this code is necessary to filter out carriage returns
                // and line feeds...it will handle any number of them.
                firstchar = nextchar;
                while (firstchar < 14 && i < contents.length()) {
                    //    System.out.println("skip2: " + firstchar);
                    i = i + 1;
                    if (i < contents.length()) {
                        firstchar = contents.charAt(i);
                    }
                }
            }
        }
        catch (Exception e) {
            return "ServerAPI: error while executing " + sheetName + "\n" + e + "\nMaxLength = " + contents.length();
        }
        return total_result;
    }

    /*
     * createTextSheet
     * @parameter: filename
     * @parameter: contents
     */
    public String createTextSheet(String filename, String contents) throws IOException {
        if (!isEngineOpen() || !isEngineLinkAvailable()) {
            if (!openAlgebraicEngine()) {
                return "ServerAPI: error occured while opening algebraic engine";
            }
        }

        // append name to flags file
        try {
            File oldfile = new File(TextSheetsDir + "Custom/" + filename + ".ts");
            if (!oldfile.exists()) {
                File flagFile = new File(TextSheetsDir + "Custom/flags.flg");
                FileReader oldFile = new FileReader(flagFile);
                int c;
                String oldFlags = "";

                while ((c = oldFile.read()) != -1) {
                    oldFlags = oldFlags + (char) c;
                }

                PrintWriter flagout = new PrintWriter(new FileWriter(flagFile));
                flagout.println(oldFlags + filename + "\n");
                flagout.close();
            }

            // create the file
            PrintWriter pout = new PrintWriter(new FileWriter(TextSheetsDir + "Custom/" + filename + ".ts"));
            pout.println(contents);
            pout.close();

            // execute the text sheet
            // return executeTextSheet("Custom",filename);
            return "ServerAPI: metric created and saved under Custom menu";
        }
        catch (IOException e) {
            return "ServerAPI: IOError while creating file: " + TextSheetsDir + "Custom/" + filename + "." + ".ts";
        }
    }

    public String[] getTextSheetDirNames() {
        File dir = new File(TextSheetsDir);
        try {
            FileReader thefile = new FileReader(dir + "/flags.flg");
            int nextchar = 0;
            String line = "";
            String[] filelist = dir.list();
            String[] dirlist = new String[filelist.length];
            int count = 0;
            for (int i = 0; i < filelist.length; i++) {
                if ((new File(TextSheetsDir + filelist[i]).isDirectory()) && (filelist[i] != "Custom")) {
                    dirlist[count] = filelist[i];
                    count++;
                }
            }
            String[] finallist = new String[count];
            try {
                nextchar = thefile.read();
                for (int j = 0; j < finallist.length; j++) {
                    line = "";
                    while (nextchar > 13) {
                        line = line + (char)nextchar;
                        nextchar = thefile.read();
                    }
                    for (int i = 0; i < finallist.length; i++) {
                        if (dirlist[i].equals(line)) {
                            finallist[j] = dirlist[i];
                        }
                    }
                    while (nextchar < 14 && nextchar != -1) {
                        nextchar = thefile.read();
                    }
                }
            }
            catch (IOException e) {
                String[] err = new String[1];
                err[0] = "IOError while reading from " + TextSheetsDir + dir + "/flags.flg";
                return err;
            }
            return finallist;
        }
        catch (FileNotFoundException e) {
            String[] err = new String[1];
            err[0] = "File Not Found: " + dir + "/flags.flg";
            return err;
        }
    }

    /**
     * This method was created by Jon Stern
     * It uses the flags.flg files to order and structure the menus
     */
    public String[] getTextSheetNames(String DirName) {
        File dir = new File(TextSheetsDir + DirName + "/");
        try {
            FileReader thefile = new FileReader(TextSheetsDir + DirName + "/" + "flags.flg");
            int nextchar = 0;
            String line = "";
            String[] filelist = dir.list();
            String[] templist = new String[filelist.length];
            int count = 0;
            for (int i = 0; i < filelist.length; i++) {
                if (new File(TextSheetsDir + DirName + "/" + filelist[i]).isDirectory()) {
                    templist[count] = filelist[i];
                    count++;
                }
            }

            String[] dirlist = new String[count];
            for (int i = 0; i < dirlist.length; i++) {
                dirlist[i] = templist[i];
            }

            String[] sheetlist = dir.list(new FileExtensionFilter(TextSheetExt));
            for (int i = 0; i < sheetlist.length; i++) {
                sheetlist[i] = removeExtension(sheetlist[i]);
            }

            String[] finallist = new String[dirlist.length + sheetlist.length];
            try {
                nextchar = thefile.read();
                for (int j = 0; j < finallist.length; j++) {
                    line = "";
                    // nextchar = thefile.read();
                    while (nextchar > 13) {
                        line = line + (char) nextchar;
                        nextchar = thefile.read();
                    }
                    for (int i = 0; i < dirlist.length; i++) {
                        if (dirlist[i].equals(line)) {
                            finallist[j] = "d" + dirlist[i];
                        }
                    }
                    for (int i = 0; i < sheetlist.length; i++) {
                        if (sheetlist[i].equals(line)) {
                            finallist[j] = "s" + sheetlist[i];
                        }
                    }
                    while (nextchar < 14 && nextchar != -1) {
                        nextchar = thefile.read();
                    }
                }
            }
            catch (IOException e) {
                String[] err = new String[1];
                err[0] = "IOError while reading from " + TextSheetsDir + dir + "/flags.flg";
                return err;
            }
            return finallist;
        }
        catch (FileNotFoundException e) {
            String[] err = new String[1];
            err[0] = "File Not Found: " + TextSheetsDir + dir + "/flags.flg";
            return err;
        }
    }

    public boolean isEngineLinkAvailable() {
        if ((fromEngine != null) && (toEngine != null)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isEngineOpen() {
        if (Engine != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean openAlgebraicEngine() {
        try {
            if (!isEngineOpen()) {
                Engine = (Runtime.getRuntime().exec(MapleExecCmd));
                toEngine = new PrintWriter(Engine.getOutputStream(), true);
                fromEngine = new BufferedReader(new InputStreamReader(Engine.getInputStream()));
                fromEngine.readLine(); // bypass
                while (fromEngine.ready()) {
                    // maple startup,logo, etc.
                    fromEngine.readLine();
                }
                //  this should initialize the maple session on startup with
                //  restart: and grtj();
                String nextline = "";
                boolean finished = false;
                toEngine.println("restart:" + "grtj();" + "finished;");
                // wait until Maple is ready
                while (!fromEngine.ready()) {}
                // read in the line with the command. we don't
                // want that to appear as part of the result.
                nextline = fromEngine.readLine();
                while (!finished) {
                    if (fromEngine.ready()) {
                        nextline = fromEngine.readLine();
                        // for some reason, the second readline also reads in the
                        // command. so to avoid this, the second readLine was
                        // skipped as well. but this would only work if put
                        // into this loop as follows. a bit of a quick fix.
                        if (nextline.trim().equals("finished")) {
                            finished = true;
                        }
                    }
                }
            }
            if (!isEngineLinkAvailable()) {
                toEngine = new PrintWriter(Engine.getOutputStream(), true);
                fromEngine = new BufferedReader(new InputStreamReader(Engine.getInputStream()));
            }
            return true;
        }
        catch (Throwable e) {
            System.out.println("ServerAPI: error while opening engine: " + e);
            return false;
        }
    }
    private String removeExtension(String filename) {
        StringTokenizer tokenizer = new StringTokenizer(filename, ".");
        return tokenizer.nextToken();
    }
    public String submitCmdToEngine(String cmd) {
        String result = "";
        String nextline = "";
        try {
            // "finished;" is added to the end of each line of the code
            // sent to Maple, because we need some way of telling when
            // all the output lines have been read. otherwise, the next
            // readLine call will wait indefinitely for something to read.
            toEngine.println(cmd + "finished;");
            System.out.println(cmd);

            // wait until Maple is ready
            while (!fromEngine.ready()) {}

            // read in the line with the command. we don't
            // want that to appear as part of the result.
            nextline = fromEngine.readLine();

            boolean finished = false;
            while (!finished) {
                if (fromEngine.ready()) {
                    nextline = fromEngine.readLine();

                    // for some reason, the second readline also reads in the
                    // command. so to avoid this, the second readLine was
                    // skipped as well. but this would only work if put
                    // into this loop as follows. a bit of a quick fix.
                    if (nextline.trim().equals("finished")) {
                        finished = true;
                    }
                    else {
                        if (nextline.trim().length() > 5) {
                            if (nextline.trim().substring(0,5).equals("Error")) {
                                result = result + "The following error occurred in Maple:" + "\n";
                                finished = true;
                            }
                        }

                        //    if (nextline.trim().length() > 7)
                        //   if (nextline.trim().substring(0,7).equals("Warning")) {
                        //    result = result + "The following warning occurred in Maple:" + "\n";
                        //    finished = true;
                        //   }
                        if (nextline.trim().length() > 5) {
                            //  System.out.println(nextline);
                            StringTokenizer st = new StringTokenizer(nextline.trim());
                            while (st.hasMoreTokens()) {
                                String Sst = st.nextToken() ;
                                if ("error".equals(Sst) || "error,".equals(Sst) || "Error".equals(Sst) || "Error,".equals(Sst)) {
                                    result = result + "There is a syntax error in the Textsheet corresonding to this selection" + "\n";
                                    result = result + "The following error occurred in Maple:" + "\n";
                                    continueReadingTextsheet = false ;
                                    finished = true;
                                    System.out.println("ServerAPI: parse error: " + nextline);
                                }
                            }

                            st = new StringTokenizer(nextline.trim());
                            while (st.hasMoreTokens()) {
                                String Sst = st.nextToken() ;
                                if ("Warning:".equals(Sst) || "warning:".equals(Sst) || "Warning".equals(Sst) || "warning".equals(Sst)) {
                                    result = result + "Textsheet corresonding to this selection produces a warning message" + "\n";
                                    addThisMessageToResult = true ;
                                    finished = true;
                                    System.out.println("ServerAPI: parse warning: " + nextline);
                                }
                            }
                        }
                        if (result == "") {
                            result = result + "\n";
                        }
                        else {
                            result = result + nextline + "\n";
                        }
                        // System.out.println(result);
                    }
                }
            }
        }
        catch (IOException e) {
            return "ServerAPI: IOError while communicating with engine: " + e;
        }
        return result;
    }
}
