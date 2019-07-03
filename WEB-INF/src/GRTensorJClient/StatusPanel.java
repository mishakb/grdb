package GRTensorJClient;

import java.awt.*;

public class StatusPanel extends java.awt.Panel {
    private Label FirstLine;
    private Label SecondLine;

    /**
     * StatusPanel constructor comment.
     */
    public StatusPanel() {
        super();
        setLayout(new GridLayout(2,1));
        this.FirstLine = new java.awt.Label();
        FirstLine.setName("FirstLine");
        FirstLine.setFont(new java.awt.Font("dialog", 1, 16));
        FirstLine.setText("GRTensorJ: The Active General Relativity Processor");
        FirstLine.setForeground(new java.awt.Color(0,0,99));
        this.SecondLine = new Label();
        SecondLine.setName("SecondLine");
        SecondLine.setFont(new java.awt.Font("dialog", 2, 12));
        SecondLine.setText("");
        SecondLine.setForeground(new java.awt.Color(0,0,99));
        add(FirstLine);
        add(SecondLine);
    }

    /**
     * StatusPanel constructor comment.
     * @param layout java.awt.LayoutManager
     */
    public StatusPanel(java.awt.LayoutManager layout) {
        super(layout);
    }
    public void setFirstLine(String text) {
        this.FirstLine.setText(text);
    }
    public void setSecondLine(String text) {
        this.SecondLine.setText(text);
    }
}
