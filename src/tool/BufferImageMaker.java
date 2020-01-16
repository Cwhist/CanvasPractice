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
        Graphics2D g = image.createGraphics();

        g.setBackground(canvas.getBackgroundColor());
        canvas.getListener().getDrawer().writePixel(g);
        g.dispose();

        try {
            ImageIO.write(image, "png", imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() { return image; }

    public void initImage() {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setBackground((canvas.getBackgroundColor()));
        g.clearRect(0,0,800,300);
    }
}
