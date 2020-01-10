package tool;

import component.MainCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferImageMaker {
    private MainCanvas canvas;
    private BufferedImage image;
    private File imageFile = new File("files/canvas.png");

    public BufferImageMaker(MainCanvas canvas) {
        this.canvas = canvas;
        image = new BufferedImage(canvas.getCanvas().getWidth(), canvas.getCanvas().getHeight(), BufferedImage.TYPE_INT_ARGB);

        if(imageFile == null) {
            try {
                imageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void make() {
        Graphics2D g = (Graphics2D) image.createGraphics();
        g.setBackground(canvas.getBackgroundColor());
        g.setColor(canvas.getListener().getDrawer().getColor());
        g.setStroke(new BasicStroke(canvas.getBrushSize(), BasicStroke.CAP_ROUND, 0));
        g.drawLine(canvas.getPrevX(), canvas.getPrevY(), canvas.getX(), canvas.getY());
        g.dispose();

        try {
            ImageIO.write(image, "png", imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
