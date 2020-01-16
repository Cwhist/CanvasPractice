package component;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SubCanvas {
    private Canvas canvas = new Canvas();
    private BufferedImage bufferedImage;

    public SubCanvas() {
        canvas.setBounds(50,350,800,300);
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    public void refreshImage() {
        Graphics2D g = (Graphics2D)canvas.getGraphics();
        g.clearRect(0,0,800,300);
        g.drawImage(bufferedImage,null,0,0);
    }

    public Canvas getCanvas() { return canvas; }

    public void setBackgroundColor(Color backgroundColor) {
        canvas.setBackground(backgroundColor);
    }
}
