package tool;

import component.MainCanvas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CanvasMouseListener {
    private CanvasDrawer drawer;
    private BufferImageMaker maker;
    private MouseAdapter mouseAdapter;
    private MouseMotionAdapter mouseMotionAdapter;

    public CanvasMouseListener(MainCanvas canvas) {
        drawer = new CanvasDrawer(canvas);
        maker = new BufferImageMaker(canvas);
        createListener(canvas);
    }

    public void createListener(MainCanvas canvas) {
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.setX(e.getX());
                canvas.setY(e.getY());
                canvas.setPrevX(canvas.getX());
                canvas.setPrevY(canvas.getY());

                drawer.drawCanvas();
            }
        };

        mouseMotionAdapter = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvas.setPrevX(canvas.getX());
                canvas.setPrevY(canvas.getY());
                canvas.setX(e.getX());
                canvas.setY(e.getY());

                drawer.drawCanvas();
                maker.make();
            }
        };

        canvas.getCanvas().addMouseListener(mouseAdapter);
        canvas.getCanvas().addMouseMotionListener(mouseMotionAdapter);
    }

    public CanvasDrawer getDrawer() {
        return drawer;
    }
}
