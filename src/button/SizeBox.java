package button;

import component.MainCanvas;
import tool.SizeChanger;

import javax.swing.*;
import java.util.ArrayList;

public class SizeBox {
    private JComboBox<Integer> comboBox;

    public SizeBox(MainCanvas canvas) {
        comboBox = new JComboBox<Integer>();
        addItem(comboBox);
        comboBox.setSize(30,30);
        comboBox.setLocation(10,70);
        comboBox.setVisible(true);
        comboBox.setSelectedItem(3);
        comboBox.addActionListener(e -> {
            SizeChanger.sizeChange((int)comboBox.getSelectedItem(),canvas);
        });
    }

    public JComboBox getComboBox() { return comboBox; }

    public void addItem(JComboBox<Integer> comboBox) {
        for(int i=1; i<=20; i++) {
            if(i<=10) comboBox.addItem(i); else if(i<=15) comboBox.addItem((i-5)*2); else comboBox.addItem((i-10)*4);
        }
    }
}
