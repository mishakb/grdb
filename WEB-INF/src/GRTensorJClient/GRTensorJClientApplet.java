package GRTensorJClient;

public class GRTensorJClientApplet extends java.applet.Applet implements java.awt.event.ActionListener {
    private java.awt.Button ivjButton1 = null;
    private java.awt.Label ivjLabel1 = null;
    private GRTensorJClientWindow theGRTensorJClientWindow = null;

    /**
     * Method to handle events for the ActionListener interface.
     * @param e java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // user code begin {1}
        // user code end
        if ((e.getSource() == getButton1()) ) {
            conn0(e);
        }
        // user code begin {2}
        // user code end
    }

    /**
     * conn0:  (Button1.action.actionPerformed(java.awt.event.ActionEvent) --> GRTensorJClientApplet.openElastiticyClientWindow()V)
     * @param arg1 java.awt.event.ActionEvent
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void conn0(java.awt.event.ActionEvent arg1) {
        try {
            // user code begin {1}
            // user code end
            this.openGRTensorJClientWindow();
            // user code begin {2}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {3}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * Gets the applet information.
     * @return java.lang.String
     */
    public String getAppletInfo() {
        return "GRTensorJClient.GRTensorJClientApplet created using VisualAge for Java.";
    }

    /**
     * Return the Button1 property value.
     * @return java.awt.Button
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Button getButton1() {
        if (ivjButton1 == null) {
            try {
                ivjButton1 = new java.awt.Button();
                ivjButton1.setName("Button1");
                ivjButton1.setBounds(01, 01, 200, 30);
                ivjButton1.setLabel("Click to Start Calculator");
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjButton1;
    }

    /**
     * Return the Label1 property value.
     * @return java.awt.Label
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private java.awt.Label getLabel1() {
        if (ivjLabel1 == null) {
            try {
                ivjLabel1 = new java.awt.Label();
                ivjLabel1.setName("Label1");
                ivjLabel1.setAlignment(java.awt.Label.CENTER);
                ivjLabel1.setText("Virtual GRTensorJ");
                ivjLabel1.setBounds(20, 10, 200, 30);
                // user code begin {1}
                // user code end
            } catch (java.lang.Throwable ivjExc) {
                // user code begin {2}
                // user code end
                handleException(ivjExc);
            }
        };
        return ivjLabel1;
    }

    /**
     * Called whenever the part throws an exception.
     * @param exception java.lang.Throwable
     */
    private void handleException(Throwable exception) {
        /* Uncomment the following lines to print uncaught exceptions to stdout */
        // System.out.println("--------- UNCAUGHT EXCEPTION ---------");
        // exception.printStackTrace(System.out);
    }

    /**
     * Handle the Applet init method.
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    public void init() {
        super.init();
        try {
            setName("GRTensorJClientApplet");
            setLayout(null);
            //  setBackground(java.awt.Color.white);
            //  setSize(169, 95);
            add(getButton1(), getButton1().getName());
            // add(getLabel1(), getLabel1().getName());
            initConnections();
            // user code begin {1}
            // user code end
        } catch (java.lang.Throwable ivjExc) {
            // user code begin {2}
            // user code end
            handleException(ivjExc);
        }
    }

    /**
     * Initializes connections
     */
    /* WARNING: THIS METHOD WILL BE REGENERATED. */
    private void initConnections() {
        // user code begin {1}
        // user code end
        getButton1().addActionListener(this);
    }

    /**
     * main entrypoint - starts the part when it is run as an application
     * @param args java.lang.String[]
     */
    public static void main(java.lang.String[] args) {
        try {
            java.awt.Frame frame;
            try {
                Class aFrameClass = Class.forName("uvm.abt.edit.TestFrame");
                frame = (java.awt.Frame)aFrameClass.newInstance();
            } catch (java.lang.Throwable ivjExc) {
                frame = new java.awt.Frame();
            }
            GRTensorJClient.GRTensorJClientApplet aGRTensorJClientApplet = new GRTensorJClient.GRTensorJClientApplet();
            frame.add("Center", aGRTensorJClientApplet);
            frame.setSize(aGRTensorJClientApplet.getSize());
            aGRTensorJClientApplet.init();
            aGRTensorJClientApplet.start();
            frame.setVisible(true);

            aGRTensorJClientApplet.destroy();
        } catch (Throwable exception) {
            System.err.println("Exception occurred in main() of java.applet.Applet");
        }
    }

    /**
     * This method was created by a SmartGuide.
     */
    public void openGRTensorJClientWindow() {
        if (theGRTensorJClientWindow == null) {
            theGRTensorJClientWindow = new GRTensorJClientWindow(getCodeBase().getHost(), Integer.parseInt(getParameter("port")));
            theGRTensorJClientWindow.setVisible(true);
        }
        return;
    }
}
