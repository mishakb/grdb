package GRTensorJClient;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class MetricPanel extends Panel implements ActionListener {

    // widgets on the panel
    private TextField metricName = null;
    private TextField coords = null;
    private TextArea dsText = null;
    private Label metricStatus = null;
    private ClientAPI ivjClientInterface = null;
    private GRTensorJClientWindow ivjClientWindow = null;

    private static final String METRIC_STATUS = "(Please see New Spacetimes under the Help Menu for assistance)";

    public MetricPanel(GRTensorJClient.ClientAPI clientInterface, GRTensorJClientWindow clientWindow) {
        super();
        // add to the panel labels and textareas to form
        //     Metric Name: _________
        //     Coordinates: _________
        // The metric element
        //   (textarea box)
        //
        // Service specific entry instructions are retrieved
        // from the grServices class.
        //

        ivjClientInterface = clientInterface;
        ivjClientWindow = clientWindow;

        setBackground(Color.white);
        setForeground(Color.blue);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gridbagc = new GridBagConstraints();
        gridbagc.gridwidth = 1;
        gridbagc.gridheight = 1;
        setLayout(gridbag);

        // metric name label
        gridbagc.gridx = 1;
        gridbagc.gridy = 1;
        Label lname = new Label("Metric Name");
        gridbag.setConstraints(lname, gridbagc);
        add(lname);

        // metric name label
        gridbagc.gridx = 2;
        gridbagc.gridy = 1;
        Label lname_2 = new Label("e.g. mymetric");
        gridbag.setConstraints(lname_2, gridbagc);
        add(lname_2);

        // metric name text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 2;
        metricName = new TextField(30);
        gridbag.setConstraints(metricName, gridbagc);
        add(metricName);

        // coords label
        gridbagc.gridx = 1;
        gridbagc.gridy = 4;
        Label lcoords = new Label("Coordinates");
        gridbag.setConstraints(lcoords, gridbagc);
        add(lcoords);

        // coords label
        gridbagc.gridx = 2;
        gridbagc.gridy = 4;
        Label lcoords_2 = new Label("e.g. r,v,theta,phi ");
        gridbag.setConstraints(lcoords_2, gridbagc);
        add(lcoords_2);

        // coords text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 5;
        coords = new TextField(30);
        gridbag.setConstraints(coords, gridbagc);
        add(coords);

        // ds label
        gridbagc.gridx = 1;
        gridbagc.gridy = 7;
        Label lds = new Label("Line Element");
        gridbag.setConstraints(lds, gridbagc);
        add(lds);

        // ds label
        gridbagc.gridx = 2;
        gridbagc.gridy = 7;
        Label lds_1 = new Label("e.g. 2*d[r]*d[v]-(1-2*m(v)/r)*d[v]^2 + r^2*d[theta]^2 + r^2*sin(theta)^2*d[phi]^2");
        gridbag.setConstraints(lds_1, gridbagc);
        add(lds_1);

        // ds textarea
        gridbagc.gridx = 2;
        gridbagc.gridy = 9;
        dsText = new TextArea(14,60);
        gridbag.setConstraints(dsText, gridbagc);
        add(dsText);

        // Cancel button
        gridbagc.gridx = 1;
        gridbagc.gridy  = 11;
        Button cancel = new Button("Cancel");
        cancel.addActionListener(this);
        gridbag.setConstraints(cancel, gridbagc);
        add(cancel);

        // clear button
        gridbagc.gridx++;
        Button clear = new Button("Clear");
        clear.addActionListener(this);
        gridbag.setConstraints(clear, gridbagc);
        add(clear);

        // ok button
        gridbagc.gridx++;
        Button ok = new Button("Ok");
        ok.addActionListener(this);
        gridbag.setConstraints(ok, gridbagc);
        add(ok);

        // finally a label to indicate what's up
        gridbagc.gridx = 2;
        gridbagc.gridy = 13;
        metricStatus = new Label(METRIC_STATUS);
        gridbag.setConstraints(metricStatus, gridbagc);
        add(metricStatus);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            String arg = (String) event.getActionCommand();

            if (arg.equals("Clear")) {
                dsText.setText("");
                metricName.setText("");
                coords.setText("");
            }
            else if (arg.equals("Cancel")) {
                ivjClientWindow.restoreTextBox();
            }
            else if (arg.equals("Ok")) {
                metricStatus.setText("Checking syntax for new metric...please wait");
                if (syntax_correct()) {
                    metricStatus.setText("Creating the new metric...");
                    add_metric();
                }
            }
        }
    }

    private boolean syntax_correct() {
        String metric = metricName.getText();
        if (metric.equals("")) {
            metricStatus.setText("Please enter a metric name");
            return false;
        }

        String xup = coords.getText();
        if (xup.equals("")) {
            metricStatus.setText("Please enter the coordinates");
            return false;
        }

        String ds = dsText.getText();
        if (ds.equals("")) {
            metricStatus.setText("Please enter the line element");
            return false;
        }
        // test metric name syntax (20 letters max):
        if (metric.length() > 20) {
            metricStatus.setText("The metric name must not exceed 20 characters");
            return false;
        }
        for (int i = 0; i < metric.length(); i++) {
            Character temp = new Character(metric.charAt(i));
            if (!temp.isLetter(temp.charValue())) {
                metricStatus.setText(metric.charAt(i) + " is not a valid character in the metric name");
                return false;
            }
        }
        // test coordinate syntax:
        String[] coords = new String[5];
        int n = 0;
        while (xup != "") {
            Character temp = new Character(xup.charAt(0));
            if (!temp.isLetter(temp.charValue())) {
                metricStatus.setText("Please only use alphabet characters in the names of the coordinates");
                return false;
            }
            coords[n] = "";
            while ((xup != "") && (temp.isLetter(temp.charValue()))) {
                // metricStatus.setText(n + " " + coords[n] + " Testing 3b1 " + temp);
                coords[n] = coords[n] + xup.charAt(0);
                if (xup.length()==1) {
                    xup = "";
                }
                else {
                    xup = xup.substring(1);
                    temp = new Character(xup.charAt(0));
                }
            }
            if ((n < 1) && (xup == "")) {
                metricStatus.setText("Please enter at least two coordinates");
                return false;
            }
            if ((n > 4) && (xup != "")) {
                metricStatus.setText("Please enter no more than five coordinates");
                return false;
            }
            if ((xup != "") && (!xup.startsWith(","))) {
                metricStatus.setText("Please separate the coordinates with commas");
                return false;
            }
            if (xup != "") {
                xup = xup.substring(1);
                while (xup.startsWith(" ")) {
                    xup = xup.substring(1);
                }
            }
            n++;
        }
        // test line element syntax:
        // if we hit "d[" get what's inside the square brackets. should be coordinate.
        for (int i = 0; i < ds.length(); i++) {
            Character temp = new Character(ds.charAt(i));
            if (temp.toString().equals("d")) {
                Character temp2 = new Character(ds.charAt(i + 1));
                if (temp2.toString().equals("[")) {
                    int j = i + 2;
                    temp2 = new Character(ds.charAt(j));
                    String testcoord = "";
                    while (temp2.isLetter(temp2.charValue())) {
                        testcoord = testcoord + ds.charAt(j);
                        j++;
                        temp2 = new Character(ds.charAt(j));
                    }
                    //Character temp3 = new Character(ds.charAt(j));
                    if (!temp2.toString().equals("]")) {
                        metricStatus.setText("Missing square bracket in Line Element. " + temp2);
                        return false;
                    }
                    else {
                        boolean match = false;
                        for (int k = 0; k < 4; k++) {
                            if (testcoord.equals(coords[k])) {
                                match = true;
                            }
                        }
                        if (!match) {
                            metricStatus.setText("Please only put coordinates inside square brackets");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void add_metric() {
        String contents = "makeds(" + metricName.getText() + ",[" + coords.getText() + "]," + dsText.getText() + ");" + "\n" + "*grdisplay(g(dn,dn));" + "\n";
        System.out.println("before");
        ivjClientWindow.getStatusPanel().setSecondLine(ivjClientInterface.createTextSheet("New Spacetime " + metricName.getText(),contents));
        ivjClientWindow.restoreTextBox();
    }
}
