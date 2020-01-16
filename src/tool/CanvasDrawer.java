package tool;

import component.MainCanvas;
import core.ColorArray;
import core.Main;
import core.RGB;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class CanvasDrawer {
    private MainCanvas canvas;
    private Color color = new Color(0, 0, 0,255);
    private BufferStrategy bufferCanvas;
    private static boolean isErase = false;

    public CanvasDrawer(MainCanvas canvas) {
        this.canvas = canvas;
    }

    public void drawCanvas() {
        bufferCanvas = canvas.getCanvas().getBufferStrategy();

        if(bufferCanvas == null) {
            canvas.getCanvas().createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bufferCanvas.getDrawGraphics();
        writePixel(g);
        g.dispose();
        bufferCanvas.show();
    }

    public void writePixel(Graphics2D g) {
        boolean isPlusX = (canvas.getPrevX() < canvas.getX());
        boolean isPlusY = (canvas.getPrevY() < canvas.getY());
        int currentX = canvas.getPrevX();
        int currentY = canvas.getPrevY();
        int deltaX = Math.abs(canvas.getX() - canvas.getPrevX());
        int deltaY = Math.abs(canvas.getY() - canvas.getPrevY());
        g.setStroke(new BasicStroke(canvas.getBrushSize(), BasicStroke.CAP_ROUND, 0));

        //x와y좌표 변동x
        if(deltaX == 0 && deltaY == 0) {
            canvas.getCanvasColorInfoArray().setColorInfo(currentX, currentY, color);
            g.setColor(canvas.getCanvasColorInfoArray().getColorInfo()[currentY][currentX].makeColor());
            if(isErase)
                g.clearRect(currentX-canvas.getBrushSize()/2,currentY-canvas.getBrushSize()/2,canvas.getBrushSize(),canvas.getBrushSize());
            else
                g.drawLine(currentX, currentY, currentX + 1, currentY + 1);
            return;
        }

        //x좌표 변동x
        if(deltaX == 0) {
            while(currentY != canvas.getY()) {
                canvas.getCanvasColorInfoArray().setColorInfo(currentX, currentY, color);
                g.setColor(canvas.getCanvasColorInfoArray().getColorInfo()[currentY][currentX].makeColor());
                if(isErase)
                    g.clearRect(currentX-canvas.getBrushSize()/2,currentY-canvas.getBrushSize()/2,canvas.getBrushSize(),canvas.getBrushSize());
                else
                    g.drawLine(currentX, currentY, currentX + 1, currentY + 1);

                if(isPlusY) {
                    currentY++;
                }
                else {
                    currentY--;
                }
            }

            return;
        }

        //y좌표 변동x
        if(deltaY == 0) {
            while(currentX != canvas.getX()) {
                canvas.getCanvasColorInfoArray().setColorInfo(currentX, currentY, color);
                g.setColor(canvas.getCanvasColorInfoArray().getColorInfo()[currentY][currentX].makeColor());
                if(isErase)
                    g.clearRect(currentX-canvas.getBrushSize()/2,currentY-canvas.getBrushSize()/2,canvas.getBrushSize(),canvas.getBrushSize());
                else
                    g.drawLine(currentX, currentY, currentX + 1, currentY + 1);

                if(isPlusX) {
                    currentX++;
                }
                else {
                    currentX--;
                }
            }

            return;
        }

        double ratio;
        int count = 0;

        if(deltaX > deltaY)
            ratio = deltaX / deltaY;
        else
            ratio = deltaY / deltaX;

        while((currentX != canvas.getX()) && (currentY != canvas.getY())) {
            canvas.getCanvasColorInfoArray().setColorInfo(currentX, currentY, color);
            g.setColor(canvas.getCanvasColorInfoArray().getColorInfo()[currentY][currentX].makeColor());
            if(isErase)
                g.clearRect(currentX-canvas.getBrushSize()/2,currentY-canvas.getBrushSize()/2,canvas.getBrushSize(),canvas.getBrushSize());
            else
                g.drawLine(currentX, currentY, currentX + 1, currentY + 1);

            // count가 ratio(x변동/y변동 or y변동/x변동)보다 크거나 같으면
            if((count >= ratio)) {
                if(deltaX > deltaY) {
                    if(isPlusY && (currentY != canvas.getY())) {
                        currentY++;
                    }
                    else if(currentY != canvas.getY()) {
                        currentY--;
                    }
                }
                else {
                    if(isPlusX && (currentX != canvas.getX())) {
                        currentX++;
                    }
                    else if(currentX != canvas.getX()) {
                        currentX--;
                    }
                }

                count = 0;
                if(deltaX > deltaY)
                    ratio = Math.abs(canvas.getX() - currentX) / Math.abs(canvas.getY() - currentY);
                else
                    ratio = Math.abs(canvas.getY() - currentY) / Math.abs(canvas.getX() - currentX);
            }
            else {
                if (deltaX > deltaY) {
                    if (isPlusX && (currentX != canvas.getX())) {
                        currentX++;
                    }
                    else if (currentX != canvas.getX()) {
                        currentX--;
                    }
                }
                else {
                    if (isPlusY && (currentY != canvas.getY())) {
                        currentY++;
                    }
                    else if (currentY != canvas.getY()) {
                        currentY--;
                    }
                }

                count++;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static void setErase(boolean value) { isErase = value; }
}
