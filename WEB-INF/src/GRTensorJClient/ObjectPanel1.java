package  GRTensorJClient;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ObjectPanel1 extends Panel implements ActionListener {
    // widgets on the panel

    // private TextField objectIndices = null;
    // private TextArea listsText = null;
    // name of the textsheets
    private TextField objectName = null;
    private Label objectStatus = null;
    private ClientAPI ivjClientInterface = null;
    private GRTensorJClientWindow ivjClientWindow = null;
    private static final String OBJECT_STATUS = "(Please see New Objects under the Help Menu for assistance)";
    private TextArea objectText1 = null;
    private int numIndices1 = 0;
    private boolean[] indices1 = new boolean[10];
    private String objName1 = "";

    public ObjectPanel1(GRTensorJClient.ClientAPI clientInterface, GRTensorJClientWindow clientWindow) {
        super();
        // add to the panel labels and textareas to form
        //     Object Name: _________
        // The object text
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

        // object name label
        gridbagc.gridx = 1;
        gridbagc.gridy = 1;
        Label lname = new Label("Object Name");
        gridbag.setConstraints(lname, gridbagc);
        add(lname);

        // object name text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 1;
        objectName = new TextField(20);
        gridbag.setConstraints(objectName, gridbagc);
        add(objectName);

        // first part of definition
        // object text label
        gridbagc.gridx = 1;
        gridbagc.gridy = 2;
        Label lobject1 = new Label("Object Definition :");
        gridbag.setConstraints(lobject1, gridbagc);
        add(lobject1);

        // object text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 2;
        objectText1 = new TextArea(4, 60);
        gridbag.setConstraints(objectText1, gridbagc);
        add(objectText1);

        // Cancel button
        gridbagc.gridx = 1;
        gridbagc.gridy = 5;
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
        gridbagc.gridy++;
        objectStatus = new Label(OBJECT_STATUS);
        gridbag.setConstraints(objectStatus, gridbagc);
        add(objectStatus);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            String arg = (String) event.getActionCommand();
            if (arg.equals("Clear")) {
                objectText1.setText("");
                objectName.setText("");
            }
            else if (arg.equals("Cancel")) {
                ivjClientWindow.restoreTextBox();  // need to close metric panel and open textbox
            }
            else if (arg.equals("Ok")) {
                objectStatus.setText("Checking syntax for new object(s)...please wait");
                if (syntax_correct()) {
                    objectStatus.setText("Creating the new object(s)...");
                    add_object();
                }
            }
        }
    }

    private boolean syntax_correct() {
        String name = objectName.getText();
        if (name.equals("")) {
            objectStatus.setText("Please enter an object name");
            return false;
        }

        String object1 = objectText1.getText().trim();
        if (object1.length() < 4) {
            objectStatus.setText("Please enter the object's complete definition");
            return false;
        }
        // test object name syntax:
        // THIS WAS DISABLED SINCE THERE IS NOT AN 8 CHARACTER LIMIT FOR FILE NAMES
        //  if (object.length() > 8) {
        //   objectStatus.setText("The object name must not exceed 8 characters");
        //   return false;
        //  }
        for (int i = 0; i < name.length(); i++) {
            Character temp = new Character(name.charAt(i));
            if (!temp.isLetter(temp.charValue())) {
                objectStatus.setText(object1.charAt(i) + " is not a valid character in the object name");
                return false;
            }
        }
        // test object definition (indices)
        indices1[0] = false;
        // object.substring(2); // get rid of `
        objName1 = "";
        while ((object1.length() > 1) && (!object1.startsWith("{"))) {
            objName1 = objName1 + object1.charAt(0);
            object1 = object1.substring(1);
        }
        objName1 = objName1.substring(1);
        while ((object1.length() > 1) && (!object1.startsWith("}"))) {
            object1 = object1.substring(1);
            if (object1.startsWith("^")) {
                indices1[numIndices1] = true;
            }
            Character first = new Character(object1.charAt(0));
            if (first.isLetter(first.charValue())) {
                numIndices1++;
                if (numIndices1>9) {
                    objectStatus.setText("You can not use more than ten indices (in part I)");
                    return false;
                }
                indices1[numIndices1] = false;
            }
        }
        return true;
    }

    private void add_object() {
        String CalcName1 = objName1 + "(";
        for (int i = 0; i < numIndices1; i++) {
            if (indices1[i]) {
                CalcName1 = CalcName1 + "up";
            }
            else {
                CalcName1 = CalcName1 + "dn";
            }
            if (i < (numIndices1-1)) {
                CalcName1 = CalcName1 + ",";
            }
        }
        CalcName1 = CalcName1 + ")" ;
        numIndices1 = 0;

        String contents = "grdef(" + objectText1.getText() + "):" + "\n";
        contents = contents + "initzero(" + CalcName1 + "):" + "\n";
        contents = contents + "grundefine(" + CalcName1 + "):" + "\n";
        contents = contents + "grdef(" + objectText1.getText() + "):" + "\n";
        contents = contents + "grcalc(" + CalcName1 + ");"  ;
        contents = contents + "\n" + "*grdisplay(_);" + "\n";
        ivjClientInterface.createTextSheet("New Object " + objectName.getText(), contents);
        ivjClientWindow.restoreTextBox();
    }
}
