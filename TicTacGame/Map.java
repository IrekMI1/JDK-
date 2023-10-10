package TicTacGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    private int fieldSizeX;
    private int fieldSizeY;

    public Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
//        int cellX = e.getX();
//        int cellY = e.getY();
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        this.fieldSizeX = fSzX;
        this.fieldSizeY = fSzY;

        System.out.printf("Mode: %b;\nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
    }
}
