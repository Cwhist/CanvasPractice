package component;

import button.BurshButton;
import button.ColorChooserButton;
import button.EraseButton;
import button.SizeBox;

import javax.swing.*;
import java.awt.*;

public class LeftPanel {
    private JPanel panel;

    public LeftPanel(MainCanvas canvas) {
        panel = new JPanel();
        panel.setSize(50, 600);
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new BurshButton(canvas).getButton());
        panel.add(new EraseButton(canvas).getButton());
        panel.add(new ColorChooserButton(canvas).getButton());
        panel.add(new SizeBox(canvas).getComboBox());
    }

    public JPanel getPanel() {
        return panel;
    }
}
