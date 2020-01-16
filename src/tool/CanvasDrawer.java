package tool;

import component.MainCanvas;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class CanvasDrawer {
    private MainCanvas canvas;
    private Color color = new Color(0,0, 0, 255);
    private BufferStrategy bufferCanvas;
    private static boolean isErase = false;

    public CanvasDrawer(MainCanvas canvas) { this.canvas = canvas; }

    public void drawCanvas() {
        bufferCanvas = canvas.getCanvas().getBufferStrategy();

        if(bufferCanvas == null) {
            canvas.getCanvas().createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();

        g.setColor(color);
        g.setStroke(new BasicStroke(canvas.getBrushSize(), BasicStroke.CAP_ROUND, 0));
        if(isErase) {
            g.clearRect(canvas.getX()-canvas.getBrushSize()/2,canvas.getY()-canvas.getBrushSize()/2,canvas.getBrushSize(),canvas.getBrushSize());
        }
        else
            g.drawLine(canvas.getPrevX(), canvas.getPrevY(), canvas.getX(), canvas.getY());

        g.dispose();
        bufferCanvas.show();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = new Color(color.getRed(),color.getGreen(),color.getBlue(), color.getAlpha());
    }

    public boolean getErase() { return isErase; }

    public static void setErase(boolean value) { isErase = value; }
}
