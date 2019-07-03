package GRTensorJClient;

import java.io.*;
import java.util.*;
import java.net.*;

public class GRTensorJClientWindow extends java.awt.Frame implements java.awt.event.ActionListener, java.awt.event.WindowListener {
    private java.awt.MenuItem ivjclear = null;
    private ClientAPI ivjClientInterface = null;
    private java.awt.MenuItem ivjConnect = null;
    private java.awt.MenuItem ivjDisconnect = null;
    private java.awt.MenuItem ivjNewMetric = null;
    private java.awt.MenuItem ivjNewObject1 = null;
    private java.awt.MenuItem ivjNewObjectm = null;
    private java.awt.MenuItem ivjListOfMetricsNames = null;
    private java.awt.BorderLayout ivjGRTensorJClientWindowBorderLayout = null;
    private java.awt.MenuBar ivjGRTensorJClientWindowMenuBar = null;
    private String ivjHostAddress = null;
    private Integer ivjHostPort = null;
    private java.awt.MenuItem ivjMenuItem1 = null;
    private java.awt.Panel ivjPanel2 = null;
    private java.awt.Panel ivjMetricPanel = null;
    private java.awt.Panel ivjObjectPanelm = null;
    private java.awt.Panel ivjObjectPanel1 = null;
    private java.awt.BorderLayout ivjPanel2BorderLayout = null;
    private java.awt.Panel ivjPanel3 = null;
    private java.awt.Menu ivjServerMenu = null;
    private java.awt.Menu ivjCustomMenu = null;
    public StatusPanel ivjStatusPanel = null;
    private java.awt.TextArea ivjTextBox = null;

    /**
     * Constructor
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public GRTensorJClientWindow() {
        super();
        initialize();
    }

    /**
     * GRTensorJClientWindow constructor comment.
     * @param title java.lang.String
     */
    public GRTensorJClientWindow(String HostAddress, int HostPort) {
        this();
        setHostAddress(HostAddress);
        setHostPort(new Integer(HostPort));

    }
    /**
     * Method to handle events for the ActionListener interface.
     * @param e java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // user code begin {1}
        if ((e.getSource() instanceof java.awt.Menu) && (e.getSource() != getServerMenu()) && (e.getSource() != getCustomMenu())) {
            this.executionSequence(e);
        }

        // user code end
        if ((e.getSource() == getConnect()) ) {
            conn16(e);
        }
        if ((e.getSource() == getDisconnect()) ) {
            conn27(e);
        }
        if ((e.getSource() == getclear()) ) {
            conn15(e);
        }
        if ((e.getSource() == getNewMetric()) ) {
            conn34(e);
        }
        if ((e.getSource() == getNewObjectm()) ) {
            conn35(e);
        }
        if ((e.getSource() == getNewObject1()) ) {
            conn36(e);
        }
        if ((e.getSource() == getListOfMetricsNames()) ) {
            conn37(e);
        }
        if ((e.getSource() == getCustomMenu()) && (e.getSource() != getNewMetric()) && (e.getSource() != getNewObjectm()) && (e.getSource() != getNewObject1() ) && (e.getSource() != getListOfMetricsNames())  ) {
            this.customExecutionSequence(e);
        }
        // user code begin {2}
        // user code end
    }

    /**
     * conn0:  (GRTensorJClientWindow.window.windowClosing(java.awt.event.WindowEvent) --> GRTensorJClientWindow.dispose())
     * @param arg1 java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn0(java.awt.event.WindowEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.dispose();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn15:  (clear.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.writeToTextBox(Ljava.lang.String;Z)V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn15(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.writeToTextBox("", true);
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn16:  (Connect.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.connectSequence()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn16(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.connectSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn27:  (Disconnect.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.disconnectSequence()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn27(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.disconnectSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn34:  (NewMetric.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.newMetricSequence()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn34(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.newMetricSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn35:  (NewObjectm.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.newObjectmSequence()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn35(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.newObjectmSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn36:  (NewObject1.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientWindow.newObject1Sequence()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn36(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.newObject1Sequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn37:
     /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn37(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.ListOfMetricsNamesSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn5:  (GRTensorJClientWindow.window.windowOpened(java.awt.event.WindowEvent) --> GRTensorJClientWindow.connectSequence()V)
     * @param arg1 java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn5(java.awt.event.WindowEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.connectSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * conn8:  (GRTensorJClientWindow.window.windowClosing(java.awt.event.WindowEvent) --> GRTensorJClientWindow.disconnectSequence()V)
     * @param arg1 java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn8(java.awt.event.WindowEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.disconnectSequence();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * This method was created by a SmartGuide.
     */
    public void connectSequence() {
        getStatusPanel().setSecondLine("Attempting to connect to server...");
        setCursor(WAIT_CURSOR);
        getStatusPanel().setSecondLine(getClientInterface().initiateLinkWithServer(getHostAddress(), getHostPort().intValue()));
        System.out.println(200);
        populateAllMenus();
        System.out.println(210);

        writeToTextBox(getClientInterface().executeTextSheet("Help", "About GRTensorJ"), false);
        getStatusPanel().setSecondLine("Program ready, awaiting instruction...");

        // THE FOLLOWING CODE IS NOW PART OF A TEXTSHEET WHICH DISPLAYS THE "ABOUT GRTENSORJ" INFORMATION:

        // getTextBox().setText("WELCOME TO GRTensorJ\n"+
        //        "Java Engine: Remote Analysis System 1.0 (c) John Mourra\n"+
        //        "Algebraic Engine: MapleV Release 5 (c) Waterloo Maple  // Software\n"+
        //        "Tensor Engine: GRTensorII 1.73 (c) Peter Musgrave, Denis //Pollney and Kayll Lake\n"+
        //        "OS: SunOS 5.5 (c) Sun Microsystems\n"+
        //        "Server Location: "+getHostAddress()+"\n"+"\n"+"\n");

        setCursor(DEFAULT_CURSOR);
        System.out.println(220);
        return;
    }

    public void disconnectSequence() {
        getStatusPanel().setSecondLine("Attempting to disconnect from server...");
        setCursor(WAIT_CURSOR);
        getStatusPanel().setSecondLine(getClientInterface().terminateLinkWithServer());
        getTextBox().setText("");
        setCursor(DEFAULT_CURSOR);
        return;
    }

    /**
     * This sequence loads the metric panel and hides the text box so that a new metric can be created
     */

    public void newMetricSequence() {
        getStatusPanel().setSecondLine("Loading interface for creating a new metric...");
        setCursor(WAIT_CURSOR);

        getTextBox().setVisible(false);
        if (ivjMetricPanel == null)
            this.add("Center", getMetricPanel());
        else getMetricPanel().setVisible(true);

        pack();

        setCursor(DEFAULT_CURSOR);
        return;
    }


    /**
     * This sequence loads the object panel and hides the text box so that a new object can be created
     */

    public void newObjectmSequence() {
        getStatusPanel().setSecondLine("Loading interface for creating a new object...");
        setCursor(WAIT_CURSOR);

        getTextBox().setVisible(false);
        if (ivjObjectPanelm == null)
            this.add("Center", getObjectPanelm());
        else getObjectPanelm().setVisible(true);

        pack();

        setCursor(DEFAULT_CURSOR);
        return;
    }

    /**
     * This sequence loads the object1 panel and hides the text box so that a new object can be created
     */

    public void newObject1Sequence() {
        getStatusPanel().setSecondLine("Loading interface for creating a new single object...");
        setCursor(WAIT_CURSOR);

        getTextBox().setVisible(false);
        if (ivjObjectPanel1 == null)
            this.add("Center", getObjectPanel1());
        else getObjectPanel1().setVisible(true);

        pack();

        setCursor(DEFAULT_CURSOR);
        return;
    }

    /**
     * This sequence communicates with trhe servlet GRDBServlet in order to
     * get the list of metrics that should be loaded into the calculator
     */

    public void ListOfMetricsNamesSequence ()

    {
        getStatusPanel().setSecondLine("Communicating with the GRDB2 Servlet...");
        setCursor(WAIT_CURSOR);

        try {
            Vector ListOfMetricsNames = new Vector();
            String Message = "GRTensorJClient request";
            // URL url = new URL("http://millennium.phy.queensu.ca:8080"+
            //    "/servlet/GRDB2.GRDBServlet?Command=TransferMetricsNames");
            URL url = new URL("http://grdatabase.utdallas.edu/home?Command=TransferMetricsNames");
            URLConnection con = url.openConnection();

            writeListOfMetricsNames(con, Message);
            ListOfMetricsNames = readListOfMetricsNames(con);

            if (ListOfMetricsNames != null && ListOfMetricsNames.size() > 0) {
                for (int x = 0 ; x < ListOfMetricsNames.size(); x++) {

                    String  contents = "qload(" + ((String) ListOfMetricsNames.elementAt(x));
                    contents = contents + ");" + "\n" + "*grdisplay(g(dn, dn));" + "\n";

                    String result = getClientInterface().createTextSheet((String)ListOfMetricsNames.elementAt(x), contents);
                    // ALT 1
                    if (getClientInterface().CustomTextSheetExists((String)ListOfMetricsNames.elementAt(x)))
                        this.addToCustomMenu((String)ListOfMetricsNames.elementAt(x));
                    // this.addToCustomMenu(("Loaded from GRDB2 : "+  ((String) ListOfMetricsNames.elementAt(x))) );
                    this.restoreTextBox(result);
                    getStatusPanel().setSecondLine(result);
                }
            }
            else {
                getStatusPanel().setSecondLine("No metrics from GRDB2 are available");
            }
        }
        catch(MalformedURLException mue) {

            // getStatusPanel().setSecondLine(mue.getMessage());
            getStatusPanel().setSecondLine("MalformedURLException (ListOfMetricsNamesSequence)");
        }
        catch(Exception e) {

            // getStatusPanel().setSecondLine(e.getMessage());
            getStatusPanel().setSecondLine("Exception (ListOfMetricsNamesSequence)");
        }
        setCursor(DEFAULT_CURSOR);
        return;
    }

    public void writeListOfMetricsNames (URLConnection connection, String value) {
        try {
            connection.setUseCaches(false);
            connection.setRequestProperty("CONTENT_TYPE", "application/octet-stream");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            ObjectOutputStream os = new ObjectOutputStream(connection.getOutputStream());
            getStatusPanel().setSecondLine("Sending lom Object to GRDB2...");
            os.writeObject(value);
            os.flush();
            os.close();
        }
        catch (IOException e) {
            // getStatusPanel().setSecondLine(e.getMessage());
            getStatusPanel().setSecondLine("IOException (writeListOfMetricsNames)");
        }
    }

    public Vector readListOfMetricsNames(URLConnection connection) {

        Vector ListOfMetricsNames = new Vector();
        try {
            ObjectInputStream is = new ObjectInputStream(connection.getInputStream());
            getStatusPanel().setSecondLine("Waiting for response from GRDB2...");
            ListOfMetricsNames = (Vector)is.readObject();
            is.close();
        }
        catch (IOException e) {
            // getStatusPanel().setSecondLine(e.getMessage());
            getStatusPanel().setSecondLine("IOException (readListOfMetricsNames): " + e);
        }
        catch (ClassNotFoundException ce ) {
            // getStatusPanel().setSecondLine(ce.getMessage());
            getStatusPanel().setSecondLine("ClassNotFoundException (readListOfMetricsNames): " + ce.getMessage());
        }
        return ListOfMetricsNames;
    }
    /**
     * When the new object or new metric panel is closed, this procedure hides the old panel
     * and redisplays the text box
     * NOTE: RIGHT NOW, THIS PROCEDURE DISCONNECTS AND RECONNECTS TO THE SERVER TO RELOAD THE MENUS.
     * IDEALLY, WE WANT TO RELOAD THE MENUS WITHOUT DISCONNECTING...
     */

    public void addToCustomMenu(String MenuItemName) {
        java.awt.MenuItem newMenuItem = new java.awt.MenuItem();
        newMenuItem.setName(MenuItemName);
        newMenuItem.setLabel(MenuItemName);
        getCustomMenu().add(newMenuItem);
    }

    public void restoreTextBox() {
        if (ivjMetricPanel != null)
            getMetricPanel().setVisible(false);
        if (ivjObjectPanelm != null)
            getObjectPanelm().setVisible(false);
        if (ivjObjectPanel1 != null)
            getObjectPanel1().setVisible(false);
        getTextBox().setVisible(true);
        pack();

        // ALT
        // try {
        //  this.disconnectSequence();
        // } catch (java.lang.Throwable ivjExc) {
        //  handleException(ivjExc);
        // }
        // try {
        //  this.connectSequence();
        // } catch (java.lang.Throwable ivjExc) {
        //  handleException(ivjExc);
        // }
    }

    // ALT
    public void restoreTextBox(String inStr) {
        getStatusPanel().setSecondLine(inStr);
        restoreTextBox();
    }

    /**
     * This method was created by a SmartGuide.
     * @param evt java.awt.event.ActionEvent
     */
    public void executionSequence(java.awt.event.ActionEvent evt) {
        getStatusPanel().setSecondLine("Processing the calculation of "+evt.getActionCommand());
        setCursor(WAIT_CURSOR);

        java.awt.Menu rootDir = (java.awt.Menu)evt.getSource();
        String dir = rootDir.getLabel();
        while (rootDir.getParent() != getGRTensorJClientWindowMenuBar()) {
            rootDir = (java.awt.Menu)rootDir.getParent();
            dir = rootDir.getLabel() + "/" + dir;
        }

        writeToTextBox(getClientInterface().executeTextSheet(dir, evt.getActionCommand()), false);

        setCursor(DEFAULT_CURSOR);
        getStatusPanel().setSecondLine(evt.getActionCommand()+" has been calculated...");

        return;
    }

    public void customExecutionSequence(java.awt.event.ActionEvent evt) {
        getStatusPanel().setSecondLine("Processing custom calculation "+evt.getActionCommand());
        setCursor(WAIT_CURSOR);

        writeToTextBox(getClientInterface().executeCustomTextSheet(evt.getActionCommand()), false);
        setCursor(DEFAULT_CURSOR);
        getStatusPanel().setSecondLine(evt.getActionCommand()+" has been calculated...");

        return;
    }

    /**
     * Return the clear property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getclear() {
        if (ivjclear == null) {
            try {
                ivjclear = new java.awt.MenuItem();
                ivjclear.setName("clear");
                ivjclear.setLabel("Clear Buffer");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjclear;
    }

    /**
     * Return the ClientInterface property value.
     * @return GRTensorJClient.ClientAPI
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private ClientAPI getClientInterface() {
        if (ivjClientInterface == null) {
            try {
                ivjClientInterface = new GRTensorJClient.ClientAPI();
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjClientInterface;
    }

    /**
     * Return the Connect property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getConnect() {
        if (ivjConnect == null) {
            try {
                ivjConnect = new java.awt.MenuItem();
                ivjConnect.setName("Connect");
                ivjConnect.setLabel("Connect to server");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjConnect;
    }

    /**
     * Return the Disconnect property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getDisconnect() {
        if (ivjDisconnect == null) {
            try {
                ivjDisconnect = new java.awt.MenuItem();
                ivjDisconnect.setName("Disconnect");
                ivjDisconnect.setLabel("Disconnect from server");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjDisconnect;
    }

    /**
     * Return the NewMetric property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getNewMetric() {
        if (ivjNewMetric == null) {
            try {
                ivjNewMetric = new java.awt.MenuItem();
                ivjNewMetric.setName("New Metric");
                ivjNewMetric.setLabel("Create a new metric");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjNewMetric;
    }

    /**
     * Return the NewObject1 property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getNewObject1() {
        if (ivjNewObject1 == null) {
            try {
                ivjNewObject1 = new java.awt.MenuItem();
                ivjNewObject1.setName("New Object1");
                ivjNewObject1.setLabel("Create a new single definition object");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjNewObject1;
    }

    /**
     * Return the NewObjectm property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getNewObjectm() {
        if (ivjNewObjectm == null) {
            try {
                ivjNewObjectm = new java.awt.MenuItem();
                ivjNewObjectm.setName("New Objectm");
                ivjNewObjectm.setLabel("Create a new multiple definitions object");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjNewObjectm;
    }


    private java.awt.MenuItem getListOfMetricsNames() {
        if (ivjListOfMetricsNames == null) {
            try {
                ivjListOfMetricsNames = new java.awt.MenuItem();
                ivjListOfMetricsNames.setName("Load GRDBmetrics");
                ivjListOfMetricsNames.setLabel("Load Marked Spacetimes from GRDB2");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjListOfMetricsNames;
    }

    /**
     * Return the GRTensorJClientWindowBorderLayout property value.
     * @return java.awt.BorderLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.BorderLayout getGRTensorJClientWindowBorderLayout() {
        java.awt.BorderLayout ivjGRTensorJClientWindowBorderLayout = null;
        try {
            /* Create part */
            ivjGRTensorJClientWindowBorderLayout = new java.awt.BorderLayout();
            ivjGRTensorJClientWindowBorderLayout.setVgap(15);
            ivjGRTensorJClientWindowBorderLayout.setHgap(15);
            //  ivjGRTensorJClientWindowBorderLayout.setBackground(java.awt.Color.black);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjGRTensorJClientWindowBorderLayout;
    }

    /**
     * Return the GRTensorJClientWindowMenuBar property value.
     * @return java.awt.MenuBar
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuBar getGRTensorJClientWindowMenuBar() {
        if (ivjGRTensorJClientWindowMenuBar == null) {
            try {
                ivjGRTensorJClientWindowMenuBar = new java.awt.MenuBar();
                // ivjGRTensorJClientWindowMenuBar.add(getServerMenu());
                // ivjGRTensorJClientWindowMenuBar.add(getCustomMenu());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjGRTensorJClientWindowMenuBar;
    }

    /**
     * Return the HostAddress property value.
     * @return java.lang.String
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private String getHostAddress() {
        // user code begin {1}
        // user code end
        return ivjHostAddress;
    }

    /**
     * Return the HostPort property value.
     * @return java.lang.Integer
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private Integer getHostPort() {
        // user code begin {1}
        // user code end
        return ivjHostPort;
    }

    /**
     * Return the MenuItem1 property value.
     * @return java.awt.MenuItem
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.MenuItem getMenuItem1() {
        if (ivjMenuItem1 == null) {
            try {
                ivjMenuItem1 = new java.awt.MenuItem();
                ivjMenuItem1.setLabel("-");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjMenuItem1;
    }

    /**
     * Return the MetricPanel property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getMetricPanel() {
        if (ivjMetricPanel == null) {
            try {
                ivjMetricPanel = new GRTensorJClient.MetricPanel(getClientInterface(), this);
                ivjPanel2.setName("MetricPanel");

                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjMetricPanel;
    }

    /**
     * Return the ObjectPanel1 property value.
     * @return java.awt.Panel1
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getObjectPanel1() {
        if (ivjObjectPanel1 == null) {
            try {
                ivjObjectPanel1 = new GRTensorJClient.ObjectPanel1(getClientInterface(), this);
                ivjPanel2.setName("ObjectPanel1");

                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjObjectPanel1;
    }

    /**
     * Return the ObjectPanel property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getObjectPanelm() {
        if (ivjObjectPanelm == null) {
            try {
                ivjObjectPanelm = new GRTensorJClient.ObjectPanel(getClientInterface(), this);
                ivjPanel2.setName("ObjectPanelm");

                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjObjectPanelm;
    }
    /**
     * Return the Panel2 property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPanel2() {
        if (ivjPanel2 == null) {
            try {
                ivjPanel2 = new java.awt.Panel();
                ivjPanel2.setName("Panel2");
                ivjPanel2.setLayout(getPanel2BorderLayout());
                getPanel2().add("West", getPanel3());

                getPanel2().add("Center", getStatusPanel());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        }
        return ivjPanel2;
    }

    /**
     * Return the Panel2BorderLayout property value.
     * @return java.awt.BorderLayout
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.BorderLayout getPanel2BorderLayout() {
        java.awt.BorderLayout ivjPanel2BorderLayout = null;
        try {
            /* Create part */
            ivjPanel2BorderLayout = new java.awt.BorderLayout();
            ivjPanel2BorderLayout.setVgap(8);
            ivjPanel2BorderLayout.setHgap(15);
        } catch (java.lang.Throwable ivjExc) {
            handleException(ivjExc);
        };
        return ivjPanel2BorderLayout;
    }

    /**
     * Return the Panel3 property value.
     * @return java.awt.Panel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Panel getPanel3() {
        if (ivjPanel3 == null) {
            try {
                ivjPanel3 = new java.awt.Panel();
                ivjPanel3.setName("Panel3");
                ivjPanel3.setLayout(null);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjPanel3;
    }

    /**
     * Return the ServerMenu property value.
     * @return java.awt.Menu
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Menu getServerMenu() {
        if (ivjServerMenu == null) {
            try {
                ivjServerMenu = new java.awt.Menu();
                ivjServerMenu.setName("ServerMenu");
                ivjServerMenu.setLabel("Server");
                ivjServerMenu.add(getConnect());
                ivjServerMenu.add(getDisconnect());
                ivjServerMenu.add(getMenuItem1());
                ivjServerMenu.add(getclear());
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjServerMenu;
    }

    /**
     * Return the CustomMenu property value.
     * @return java.awt.Menu
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Menu getCustomMenu() {
        if (ivjCustomMenu == null) {
            try {
                getStatusPanel().setSecondLine("Loading customized options...");
                ivjCustomMenu = new java.awt.Menu();
                ivjCustomMenu.setName("Custom");
                ivjCustomMenu.setLabel("Custom");
                ivjCustomMenu.add(getNewMetric());
                ivjCustomMenu.add(getNewObject1());
                ivjCustomMenu.add(getNewObjectm());
                ivjCustomMenu.add(getListOfMetricsNames());
                ivjCustomMenu.add(getMenuItem1());

                // FileWriter thefile = new FileWriter("SheetTest.t");

                // THIS WAS TEMPORARILY DISABLED TO PROVIDE A WORKING VERSION ON 08/05/99
                // THESE TRACES AND THIS CODE IS NO LONGER NECESSARY SINCE WORKING CODE
                // HAS BEEN CREATED 09/14/99

                // getStatusPanel().setSecondLine("Test1");
                // String dirName = "D:\\Program Files\\Xitami\\webpages\\GRTensorJ\\Sheets\\";
                // getStatusPanel().setSecondLine("Test2");
                // File dir = new File(dirName);
                // getStatusPanel().setSecondLine("Test3");
                // getStatusPanel().setSecondLine("Test31");

                // if (dir.exists()) {getStatusPanel().setSecondLine("exists");}
                // else {getStatusPanel().setSecondLine("does not exist");}

                // getStatusPanel().setSecondLine("Number of Files: "+dir.list().length);
                // String[] sheetlist = dir.list();
                // getStatusPanel().setSecondLine("Test4");
                // for (int i=0;i<sheetlist.length;i++) {
                //  getStatusPanel().setSecondLine("Adding "+sheetlist[i]);
                //  ivjCustomMenu.add(sheetlist[i]);
                // }

                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjCustomMenu;
    }

    /**
     * Return the StatusPanel property value.
     * @return GRTensorJClient.StatusPanel
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public StatusPanel getStatusPanel() {
        // private StatusPanel getStatusPanel() {
        if (ivjStatusPanel == null) {
            try {
                ivjStatusPanel = new GRTensorJClient.StatusPanel();
                ivjStatusPanel.setName("StatusPanel");
                ivjStatusPanel.setForeground(java.awt.Color.cyan);
                ivjStatusPanel.setBackground(new java.awt.Color(173, 202, 255));
                ivjStatusPanel.setFont( new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 12));
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjStatusPanel;
    }

    /**
     * Return the TextBox property value.
     * @return java.awt.TextArea
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.TextArea getTextBox() {
        if (ivjTextBox == null) {
            try {

                // Create the main textarea
                ivjTextBox = new java.awt.TextArea(120, 120);
                ivjTextBox.setEditable( false);
                ivjTextBox.setText(" ");
                ivjTextBox.setFont( new java.awt.Font("Courier", java.awt.Font.PLAIN, 12));
                ivjTextBox.setForeground(java.awt.Color.black);
                ivjTextBox.setBackground(java.awt.Color.white);

                //   ivjTextBox = new java.awt.TextArea();
                ivjTextBox.setName("TextBox");
                //   ivjTextBox.setFont(new java.awt.Font("courier", 0, 12));
                //   ivjTextBox.setBackground(java.awt.SystemColor.activeCaptionText);
                //   ivjTextBox.setEditable(false);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjTextBox;
    }

    /**
     * Called whenever the part throws an exception.
     * @param exception java.lang.Throwable
     */
    private void handleException(Throwable exception) {

        /* Uncomment the following lines to print uncaught exceptions to stdout */
        System.out.println("--------- UNCAUGHT EXCEPTION ---------");
        exception.printStackTrace(System.out);
    }

    /**
     * Initializes connections
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initConnections() {
        // user code begin {1}
        // user code end
        this.addWindowListener(this);
        getConnect().addActionListener(this);
        getDisconnect().addActionListener(this);
        getclear().addActionListener(this);
        getNewMetric().addActionListener(this);
        getNewObject1().addActionListener(this);
        getNewObjectm().addActionListener(this);
        getListOfMetricsNames().addActionListener(this);
    }

    /**
     * Initialize class
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initialize() {
        // user code begin {1}
        // user code end
        setName("GRTensorJClientWindow");
        setName("GRTensorJClientWindow");
        setMenuBar(getGRTensorJClientWindowMenuBar());
        setLayout(getGRTensorJClientWindowBorderLayout());
        setBackground(new java.awt.Color(173, 202, 255));
        setSize(810, 729); // old size was (610, 419) second size = 610, 629
        setTitle("GRTensorJ");

        this.add("Center", getTextBox());

        // THIS CODE IS NO LONGER NECESSARY SINCE RestoreTextBox() TAKES CARE OF RELOADING THE TEXT BOX

        // pack();

        // this.add("Center", getMetricPanel());
        // getMetricPanel().setVisible(false);

        // this.add("Center", getObjectPanel());
        // getObjectPanel().setVisible(false);

        // pack();

        // getTextBox().setVisible(false);

        // this.add("Center", getMetricPanel());
        // getMetricPanel().setVisible(false);

        // getTextBox().setVisible(true);

        this.add("North", getPanel2());
        initConnections();
        // user code begin {2}
        getPanel2().add("North", new java.awt.Panel(null));
        this.add("West", new java.awt.Panel(null));
        this.add("East", new java.awt.Panel(null));
        this.add("South", new java.awt.Panel(null));
        // user code end
    }

    /**
     * main entrypoint - starts the part when it is run as an application
     * @param args java.lang.String[]
     */
    public static void main(java.lang.String[] args) {
        try {
            //GRTensorJClient.GRTensorJClientWindow aGRTensorJClientWindow = new GRTensorJClient.GRTensorJClientWindow("millennium.phy.queensu.ca", 4450);
            GRTensorJClient.GRTensorJClientWindow aGRTensorJClientWindow = new GRTensorJClient.GRTensorJClientWindow("grdatabase.utdallas.edu", 4444);
            try {
                Class aCloserClass = Class.forName("uvm.abt.edit.WindowCloser");
                Class parmTypes[] = { java.awt.Window.class };
                Object parms[] = { aGRTensorJClientWindow };
                java.lang.reflect.Constructor aCtor = aCloserClass.getConstructor(parmTypes);
                aCtor.newInstance(parms);
            } catch (java.lang.Throwable exc) {};
            aGRTensorJClientWindow.setVisible(true);
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of java.awt.Frame");
        }
    }

    /**
     * This method was created by a SmartGuide.
     */
    public void populateAllMenus() {
        int i, j;
        java.awt.MenuBar mbar;
        java.awt.Menu m;
        String dirlist[];
        ivjGRTensorJClientWindowMenuBar = null;
        ivjServerMenu = null;
        ivjCustomMenu = null;
        mbar = getGRTensorJClientWindowMenuBar();
        mbar.add(getServerMenu());
        mbar.add(getCustomMenu());
        getStatusPanel().setSecondLine("Building menu interface...");
        getCustomMenu().addActionListener(this);
        // getMenuItems(getCustomMenu(), "Custom");
        dirlist = getClientInterface().retrieveTextSheetDirNames();
        for (i=0;i<dirlist.length;i++) {
            m = new java.awt.Menu();
            m.setLabel(dirlist[i]);
            m.setName(dirlist[i]);
            m.addActionListener(this);
            mbar.add(m);
            getMenuItems(m, dirlist[i]);
        }
        setMenuBar(mbar);
        return;

    }

    public void getMenuItems(java.awt.Menu m, String dir) {
        String sheetlist[] = getClientInterface().retrieveTextSheetNames(dir);
        for (int i=0;i<sheetlist.length;i++) {
            if (sheetlist[i].startsWith("s"))  // then it is a textsheet
                m.add(sheetlist[i].substring(1));
            if (sheetlist[i].startsWith("d")) {   // then it is a submenu
                java.awt.Menu newMenu = new java.awt.Menu();
                newMenu.setLabel(sheetlist[i].substring(1));
                newMenu.setName(sheetlist[i].substring(1));
                newMenu.addActionListener(this);
                m.add(newMenu);
                getMenuItems(newMenu, dir+"/"+sheetlist[i].substring(1));
            }
        }
        return;
    }

    /**
     * Set the HostAddress to a new value.
     * @param newValue java.lang.String
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void setHostAddress(String newValue) {
        if (ivjHostAddress != newValue) {
            try {
                ivjHostAddress = newValue;
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
    }

    /**
     * Set the HostPort to a new value.
     * @param newValue java.lang.Integer
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void setHostPort(Integer newValue) {
        if (ivjHostPort != newValue) {
            try {
                ivjHostPort = newValue;
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowActivated(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowClosed(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowClosing(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        if ((e.getSource() == this) ) {
            conn0(e);
        }
        if ((e.getSource() == this) ) {
            conn8(e);
        }
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowDeactivated(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowDeiconified(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowIconified(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        // user code begin {2}
        // user code end
    }

    /**
     * Method to handle events for the WindowListener interface.
     * @param e java.awt.event.WindowEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void windowOpened(java.awt.event.WindowEvent e) {
        // user code begin {1}
        // user code end
        if ((e.getSource() == this) ) {
            conn5(e);
        }
        // user code begin {2}
        // user code end
    }

    /**
     * This method was created by a SmartGuide.
     * @param s java.lang.String
     * @param clear boolean
     */
    public void writeToTextBox(String s, boolean clear) {
        if (clear) getTextBox().setText(s);
        else getTextBox().setText(s);
        // this next line is just to remove the text cursor from the textbox
        getStatusPanel();
        return;
    }
}
