package component;

import javax.swing.*;
import java.awt.*;

public class RightPanel {
    private JPanel panel;
    private MainCanvas mainCanvas = new MainCanvas();
    private SubCanvas subCanvas = new SubCanvas();

    public RightPanel() {
        panel = new JPanel();
        panel.setSize(800, 1250);
        panel.setLocation(50, 0);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(mainCanvas.getCanvas());
        subCanvas.setBackgroundColor(new Color(255,255,255,0));
        panel.add(subCanvas.getCanvas());

        subCanvas.setBufferedImage(mainCanvas.getListener().getMaker().getImage());
        mainCanvas.getListener().setSubCanvas(subCanvas);
    }

    public JPanel getPanel() {
        return panel;
    }

    public MainCanvas getMainCanvas() {
        return mainCanvas;
    }
}
