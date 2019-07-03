package  GRTensorJClient;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ObjectPanel extends Panel implements ActionListener {
    // widgets on the panel
    //    private TextField objectIndices = null;
    //    private TextArea listsText = null;
    private TextField objectName = null; // name of the textsheets
    private Label objectStatus = null;
    private ClientAPI ivjClientInterface = null;
    private GRTensorJClientWindow ivjClientWindow = null;
    private static final String OBJECT_STATUS = "(Please see New Objects under the Help Menu for assistance)";
    private TextArea objectText1 = null;
    private int numIndices1 = 0;
    private boolean[] indices1 = new boolean[10];
    private String objName1 = "";
    private TextArea objectText2 = null;
    private int numIndices2 = 0;
    private boolean[] indices2 = new boolean[10];
    private String objName2 = "";
    private TextArea objectText3 = null;
    private int numIndices3 = 0;
    private boolean[] indices3 = new boolean[10];
    private String objName3 = "";

    public ObjectPanel(GRTensorJClient.ClientAPI clientInterface, GRTensorJClientWindow clientWindow) {
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
        Label lname = new Label("Principal Object Name");
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
        Label lobject1 = new Label("Object Definition, part I :");
        gridbag.setConstraints(lobject1, gridbagc);
        add(lobject1);

        // object text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 2;
        objectText1 = new TextArea(4, 60);
        gridbag.setConstraints(objectText1, gridbagc);
        add(objectText1);

        // second part of definition
        // object text label
        gridbagc.gridx = 1;
        gridbagc.gridy = 3;
        Label lobject2 = new Label("Object Definition, part II: ");
        gridbag.setConstraints(lobject2, gridbagc);
        add(lobject2);

        // object text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 3;
        objectText2 = new TextArea(4, 60);
        gridbag.setConstraints(objectText2, gridbagc);
        add(objectText2);

        // second part of definition
        // object text label
        gridbagc.gridx = 1;
        gridbagc.gridy = 4;
        Label lobject3 = new Label("Object Definition, part III: ");
        gridbag.setConstraints(lobject3, gridbagc);
        add(lobject3);

        // object text area
        gridbagc.gridx = 2;
        gridbagc.gridy = 4;
        objectText3 = new TextArea(4, 60);
        gridbag.setConstraints(objectText3, gridbagc);
        add(objectText3);

        // THE FOLLOWING CODE WAS USED WHEN THE USER INPUTS THE INDICES, TENSOR EQUATION,
        // AND SYMMETRIES SEPARATELY.
        // NOW, THEY SIMPLY ENTER THE ARGUMENT TO GRDEF TO SEND TO MAPLE

        // tenser equation text label
        //        gridbagc.gridx = 1;
        //        gridbagc.gridy = 3;
        //        Label lequation = new Label("Tenser Equation (optional)");
        //        gridbag.setConstraints(lequation, gridbagc);
        //        add(lequation);

        // tenser equation text area
        //        gridbagc.gridx++;
        //        equationText = new TextArea(8, 40);
        //        gridbag.setConstraints(equationText, gridbagc);
        //        add(equationText);

        // symmetry lists label
        // gridbagc.gridx = 1;
        // gridbagc.gridy = 4;
        // Label llists = new Label("Symmetry Lists (optional)");
        // gridbag.setConstraints(llists, gridbagc);
        // add(llists);

        // symmetry lists text area
        // gridbagc.gridx++;
        // listsText = new TextArea(6, 40);
        // gridbag.setConstraints(listsText, gridbagc);
        // add(listsText);

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
                objectText2.setText("");
                objectText3.setText("");
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
                if (numIndices1 > 9) {
                    objectStatus.setText("You can not use more than ten indices (in part I)");
                    return false;
                }
                indices1[numIndices1] = false;
            }
        }

        // THIS WAS A SYNTAX CHECK WHEN THE COMPONENTS OF THE ARGUMENT TO GRDEF WERE INPUT SEPARATELY
        //  if ((objindices != "") && ((!objindices.startsWith("{")) || // (!objindices.endsWith("}")))) {
        //   objectStatus.setText("Indices must lie within curly brackets: {}");
        //   return false;
        //  }
        //  objindices = objindices.substring(1, objindices.length()-1);
        //  String[] indices = new String[8];
        //  int n=0;
        //  while (objindices != "") {
        //   Character temp = new Character(objindices.charAt(0));
        //   if (!temp.isLetter(temp.charValue())) {
        //    objectStatus.setText("Please only use alphabet characters in // the names of the indices");
        //    return false;
        //   }
        //   indices[n] = "";
        //   while ((objindices != "") && (temp.isLetter(temp.charValue()))) {
        //    indices[n] = indices[n] + objindices.charAt(0);
        //    if (objindices.length()==1) {objindices = "";}
        //    else {
        //     objindices = objindices.substring(1);
        //     temp = new Character(objindices.charAt(0));
        //    }
        //   }
        //   if ((n>7) && (objindices != "")) {
        //    objectStatus.setText("Please enter no more than eight // indices");
        //    return false;
        //   }
        //   if (objindices != "") {
        //    while (objindices.startsWith(" ")) {objindices = // objindices.substring(1);}
        //   }
        //   n++;
        //  }
        //  numIndices = n;
        String object2 = objectText2.getText().trim();
        if (object2.length() > 0) {
            // test part II syntax:
            // test object definition (indices)
            indices2[0] = false;
            // object.substring(2); // get rid of `
            objName2 = "";
            while ((object2.length() > 1) && (!object2.startsWith("{"))) {
                objName2 = objName2 + object2.charAt(0);
                object2 = object2.substring(1);
            }
            objName2 = objName2.substring(1);
            while ((object2.length() > 1) && (!object2.startsWith("}"))) {
                object2 = object2.substring(1);
                if (object2.startsWith("^"))
                    indices2[numIndices2] = true;
                Character first = new Character(object2.charAt(0));
                if (first.isLetter(first.charValue())) {
                    numIndices2++;
                    if (numIndices2 > 9) {
                        objectStatus.setText("You can not use more than ten indices (in partII)");
                        return false;
                    }
                    indices2[numIndices2] = false;
                }
            }
            // end of the second syntax verification ; this end the if
        }
        String object3 = objectText3.getText().trim();
        if (object3.length() > 0) {
            // test part II syntax:
            // test object definition (indices)
            indices3[0] = false;
            // object.substring(2); // get rid of `
            objName3 = "";
            while ((object3.length() > 1) && (!object3.startsWith("{"))) {
                objName3 = objName3 + object3.charAt(0);
                object3 = object3.substring(1);
            }
            objName3 = objName3.substring(1);
            while ((object3.length() > 1) && (!object3.startsWith("}"))) {
                object3 = object3.substring(1);
                if (object3.startsWith("^")) {
                    indices3[numIndices3] = true;
                }
                Character first = new Character(object3.charAt(0));
                if (first.isLetter(first.charValue())) {
                    numIndices3++;
                    if (numIndices3 > 9) {
                        objectStatus.setText("You can not use more than ten indices (in partIII)");
                        return false;
                    }
                    indices3[numIndices3] = false;
                }
            }
            // end of the second syntax verification ; this end the if
        }
        return true;
    }

    private void add_object() {
        String contents = "grdef(" + objectText1.getText() + "):" + "\n";
        contents = contents + "grcalc(" + objName1 + "(";
        for (int i = 0; i < numIndices1; i++) {
            if (indices1[i]) {
                contents = contents + "up";
            }
            else {
                contents = contents + "dn";
            }
            if (i < (numIndices1-1)) {
                contents = contents + ",";
            }
        }
        numIndices1 = 0;
        contents = contents + "));" + "\n" + "*grdisplay(_);" + "\n";
        String object2 = objectText2.getText().trim();
        if (object2.length() > 0) {
            contents = contents + "; " + "grdef(" + objectText2.getText() + "):" + "\n";
            contents = contents + "grcalc(" + objName2 + "(";
            for (int i = 0; i < numIndices2; i++) {
                if (indices2[i]) {
                    contents = contents + "up";
                }
                else {
                    contents = contents + "dn";
                }
                if (i < (numIndices2-1)) {
                    contents = contents + ",";
                }
            }
            numIndices2 = 0;
            contents = contents + "));" + "\n" + "*grdisplay(_);" + "\n";
        }
        String object3 = objectText3.getText().trim();
        if (object3.length() > 0) {
            contents = contents + "; " + "grdef(" + objectText3.getText() + "):" + "\n";
            contents = contents + "grcalc(" + objName3 + "(";
            for (int i = 0; i < numIndices3; i++) {
                if (indices3[i]) {
                    contents = contents + "up";
                }
                else {
                    contents = contents + "dn";
                }
                if (i < (numIndices3-1)) {
                    contents = contents + ",";
                }
            }
            numIndices3 = 0;
            contents = contents + "));" + "\n" + "*grdisplay(_);" + "\n";
        }

        // FOR WHEN GRDEF COMPONENTS ENTERED SEPARATELY
        //  if (equationText.getText() != "")
        //   contents = contents + " := " + equationText.getText();
        // if (listsText.getText() != "")
        //  if ((listsText.getText().trim().length() != 0 )){
        //   contents = contents + "," + listsText.getText();}
        //  contents = contents + "`):" + "\n" + "grcalc(" + objectName.getText() + "(";
        //  for (int i=0;i<(numIndices-1);i++) {
        //   contents = contents + "dn,";
        //  }
        //  contents = contents + "dn));" + "\n" + "*grdisplay(" + objectName.getText() + "(";
        //  for (int i=0;i<(numIndices-1);i++) {
        //   contents = contents + "dn,";
        //  }
        //  contents = contents + "dn));" + "\n";

        ivjClientInterface.createTextSheet("New Object " + objectName.getText(), contents);
        ivjClientWindow.restoreTextBox();
    }
}
