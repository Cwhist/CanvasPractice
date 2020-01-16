package core;

import component.LeftPanel;
import component.RightPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private RightPanel rightPanel = new RightPanel();
    private LeftPanel leftPanel = new LeftPanel(rightPanel.getMainCanvas());

    public MainFrame() {
        setSize(850, 700);
        setTitle("canvas");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(rightPanel.getPanel());
        add(leftPanel.getPanel());
    }
}
