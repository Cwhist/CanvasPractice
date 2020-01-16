package button;

import tool.CanvasDrawer;
import tool.ColorChanger;
import component.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class BurshButton {
    private JButton button;

    public BurshButton(MainCanvas canvas) {

        button = new JButton("Brush");
        button.setSize(30, 30);
        button.setLocation(10, 10);
        button.setVisible(true);
        button.addActionListener(e -> {
            ColorChanger.changeColor(Color.BLACK, canvas);
            CanvasDrawer.setErase(false);
        });
    }

    public JButton getButton() {
        return button;
    }
}
