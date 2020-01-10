package component;

import tool.CanvasMouseListener;

import java.awt.*;

public class MainCanvas {
    private Canvas canvas = new Canvas();
    private Color backgroundColor = new Color(Color.WHITE.getRGB());
    private int x;
    private int y;
    private int prevX;
    private int prevY;
    private int brushSize;
    private CanvasMouseListener listener;

    public MainCanvas() {
        canvas.setBackground(backgroundColor);
        canvas.setBounds(50, 0, 800, 600);
        brushSize = 3;

        listener = new CanvasMouseListener(this);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public int getBrushSize() { return brushSize; }

    public CanvasMouseListener getListener() {
        return listener;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public void setBrushSize(int brushSize) { this.brushSize = brushSize; }
}
