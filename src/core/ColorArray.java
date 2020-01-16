package core;

import java.awt.*;

public class ColorArray {
    private RGB[][] colorInfo;

    public ColorArray(int widthSize, int heightSize) {
        colorInfo = new RGB[heightSize][widthSize];

        for(int i = 0; i < heightSize; ++i) {
            for(int j = 0; j < widthSize; ++j) {
                colorInfo[i][j] = new RGB(255, 255, 255);
            }
        }
    }

    public RGB[][] getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(int x, int y, Color color) {
        colorInfo[y][x].setColor(color);
    }
}