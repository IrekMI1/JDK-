package TicTacGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle("TicTacToe");

        setResizable(false);
        setVisible(true);

        map = new Map();
        settings = new SettingsWindow(this);
        settings.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
        repaint();
    }

}
