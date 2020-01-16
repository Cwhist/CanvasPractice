package button;

import tool.CanvasDrawer;
import tool.CanvasMouseListener;
import tool.ColorChanger;
import component.MainCanvas;

import javax.swing.*;

public class EraseButton {
    private JButton button;

    public EraseButton(MainCanvas canvas) {
        button = new JButton("Erase");
        button.setSize(30, 30);
        button.setLocation(10, 50);
        button.setVisible(true);
        button.addActionListener(e -> {
            CanvasDrawer.setErase(true);
        });
    }

    public JButton getButton() {
        return button;
    }
}
